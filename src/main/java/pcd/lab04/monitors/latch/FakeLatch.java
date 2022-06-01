package pcd.lab04.monitors.latch;

/*
 * Latch - to be implemented
 */
public class FakeLatch implements Latch {

	private int count;
	
	public FakeLatch(int count) {
		this.count = count;
	}
	
	@Override
	public synchronized void await() throws InterruptedException {
		while (this.count > 0){
			wait();
		}
	}

	@Override
	public synchronized void countDown() {
		this.count = this.count - 1;
		if (this.count == 0){
			notifyAll();
		}
	}
}
