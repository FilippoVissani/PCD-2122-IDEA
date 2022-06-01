package pcd.lab04.mandel3_concurrent;


/**
 * Class representing the set to be computed.
 * 
 * @author aricci
 *
 */
public class MandelbrotSet {
	
	private int w,h;
	private int nIterMax;
	private int image[]; 
	
	private Complex currentCenter;
	private double currentDiameter;
	
	public MandelbrotSet(int w, int h, int nIterMax){
		this.w = w;
		this.h = h;
		this.nIterMax = nIterMax;
        image = new int[w*h];
        currentCenter = null;
        currentDiameter = -1;
	}
	
	public int getSizeX(){
		return w;
	}
	
	public int getSizeY(){
		return h;
	}
	
	public int[] getImage(){
		return image;
	}

	public Complex getCurrentCenter(){
		return currentCenter;
	}
	
	public double getCurrentDiameter(){
		return currentDiameter;
	}
	
	/**
	 * Computing a slice of the set.
	 * 
	 * The method can be safely called concurrently by multiple threads
	 * specifying distinct slices.   
	 * 
	 * @param x0
	 * @param x1
	 * @param c0
	 * @param diamX
	 */
	public void computeSlice(int x0, int x1, Complex c0, double diamX){

	    double cx, cy;
	    double diamY = diamX * h / w;
	    double dx = diamX / w;
	    double dy = diamY / h;
	    double radiusX = diamX*0.5;
	    double radiusY = diamY*0.5;
		for (int x = x0; x < x1; x++ ){
			for (int y = 0; y < h; y++){
				cx = x*dx + c0.re() - radiusX;
				cy = c0.im()+radiusY - y*dy; 
				double color = computeColor(cx,cy,nIterMax);
				int c = (int)(color*255);
				image[y*w+x] = c+(c<<8)+(c<<16); //(int)(color*255*255*255);//c+(c<<8)+(c<<16);
			}
		}
	}
	
	private double computeColor(double x0, double y0, int maxIteration){
		int iteration = 0;		
		double x = x0;
		double y = y0;
		while ( x*x + y*y <= 4 &&  iteration < maxIteration ){
		    double xtemp = x*x - y*y + x0;
		    y = 2*x*y + y0;
		    x = xtemp;
		    iteration++;
		  }		 
		  if ( iteration == maxIteration ){
			  return 0;
		  } else {
			  return 1.0-0.001*iteration;
		  }
	}
}

