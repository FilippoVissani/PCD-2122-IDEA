package pcd.lab04.monitors.barrier;

/*
 * Barrier - to be implemented
 */
public class FakeBarrier implements Barrier {

	private int nParticipants;
	private int actual;
	
	public FakeBarrier(int nParticipants) {
		this.nParticipants = nParticipants;
	}
	
	@Override
	public synchronized void hitAndWaitAll() throws InterruptedException {
		actual++;
		if (actual == nParticipants) {
			notifyAll();
		} else {
			while (actual < nParticipants) {
				wait();
			}
		}
	}

	
}
