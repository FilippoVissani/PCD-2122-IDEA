package pcd.lab04.monitors;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchCell2 {

	private int value;
	private boolean available;
	private Lock mutex;   
	private Condition isAvail;

	public SynchCell2(){
		available = false;
		mutex = new ReentrantLock(); 
		isAvail = mutex.newCondition();
	}

	public void set(int v){
		try {
			mutex.lock();
			value = v;
			available = true;
			isAvail.signalAll();  
		} finally {
			mutex.unlock();
		}
	}
	
	public int get() {
		try {
			mutex.lock();
			if (!available){
				try {
					isAvail.await();
				} catch (InterruptedException ex){}
			} 
			return value;
		} finally {
			mutex.unlock();
		}
	}
}

