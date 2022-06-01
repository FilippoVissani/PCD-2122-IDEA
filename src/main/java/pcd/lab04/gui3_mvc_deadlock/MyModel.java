package pcd.lab04.gui3_mvc_deadlock;

import java.util.ArrayList;
import java.util.List;

public class MyModel {

	private List<ModelObserver> observers;
	private int state;
	
	public MyModel(){
		state = 0;
		observers = new ArrayList<ModelObserver>();
	}
	
	public synchronized void update(){
		state++;
		notifyObservers();
	}
	
	public synchronized int getState(){
		return state;
	}
	
	public synchronized void addObserver(ModelObserver obs){
		observers.add(obs);
	}
	
	private void notifyObservers(){
		for (ModelObserver obs: observers){
			obs.modelUpdated(this);
		}
	}
}
