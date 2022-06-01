package pcd.lab04.mandel4_concurrent_ext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * 
 * GUI component of the view.
 * 
 * @author aricci
 *
 */
public class ViewFrame extends JFrame implements ActionListener {

	private JButton startButton;
	private JButton stopButton;
	private JTextField cx;
	private JTextField cy;
	private JTextField diam;
	private JTextField state;
	private MandelbrotPanel setPanel;
	private ArrayList<InputListener> listeners;

	public ViewFrame(int w, int h){
		super("Mandelbrot Viewer");
		setSize(w,h);
		listeners = new ArrayList<InputListener>();
		
		cx = new JTextField(5);
		cy = new JTextField(5);
		diam = new JTextField(5);
		
		/* 
		 * suggested  starting points: 
		 * (0,0) diam 4
		 * (-0.75,0.1) diam 0.04
 		 * (0.7485,0.0505) diam 0.000004;
		 */
		cx.setText("0");
		cy.setText("0");
		diam.setText("4");
		
		startButton = new JButton("start");
		stopButton = new JButton("stop");
		JPanel controlPanel = new JPanel();
		controlPanel.add(new JLabel("center "));
		controlPanel.add(cx);
		controlPanel.add(cy);
		controlPanel.add(new JLabel("diam."));
		controlPanel.add(diam);
		controlPanel.add(startButton);
		controlPanel.add(stopButton);

		setPanel = new MandelbrotPanel(w,h); 
		setPanel.setSize(w,h);

		JPanel infoPanel = new JPanel();
		state = new JTextField(20);
		state.setText("Idle");
		state.setEditable(false);
		infoPanel.add(new JLabel("State"));
		infoPanel.add(state);
		JPanel cp = new JPanel();
		LayoutManager layout = new BorderLayout();
		cp.setLayout(layout);
		cp.add(BorderLayout.NORTH,controlPanel);
		cp.add(BorderLayout.CENTER,setPanel);
		cp.add(BorderLayout.SOUTH, infoPanel);
		setContentPane(cp);		
		
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

	public void updateImage(int[] image){
		SwingUtilities.invokeLater(() -> {
				setPanel.updateImage(image);
		});
	}
	
	public void updateText(final String s){
		SwingUtilities.invokeLater(() -> {
				state.setText(s);
		});
	}

	public void addListener(InputListener l){
		listeners.add(l);
	}
	
	public void actionPerformed(ActionEvent ev){
		String cmd = ev.getActionCommand(); 
		if (cmd.equals("start")){
			notifyStarted();
		} else if (cmd.equals("stop")){
			notifyStopped();
		}
	}

	private void notifyStarted(){
		Complex c0 = new Complex(Double.parseDouble(cx.getText()),Double.parseDouble(cy.getText()));
		double d = Double.parseDouble(diam.getText());
		for (InputListener l: listeners){
			l.started(c0, d);
		}
	}
	
	private void notifyStopped(){
		for (InputListener l: listeners){
			l.stopped();
		}
	}
	
	public class MandelbrotPanel extends JPanel {

		private BufferedImage image;
		
		public MandelbrotPanel(int w, int h){
			this.image = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
		}

		public void updateImage(int[] rgbData){
			int w = image.getWidth();
			int h = image.getHeight();
	        image.setRGB(0, 0, w, h, rgbData, 0, w);
	        repaint();
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);   
	        Graphics2D g2 = (Graphics2D)g;
	        g2.drawImage(image, 0, 0, null);  
	   }
	}

}
	
