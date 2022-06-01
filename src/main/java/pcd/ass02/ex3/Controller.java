package pcd.ass02.ex3;

import io.vertx.core.Vertx;

public class Controller {

	private Flag stopFlag;
	private Statistics stats;
	private AnalyserView view;
	
	public Controller(Statistics stats) {
		this.stats = stats;
		this.stopFlag = new Flag();
	}
	
	public synchronized void setView(AnalyserView view) {
		this.view = view;
	}
	
	public synchronized void notifyStarted(String selectedDir) {
		Vertx  vertx = Vertx.vertx();
		vertx.deployVerticle(new AnalyserAgent(stats, selectedDir, view));
	}
	
	public synchronized void notifyStopped() {
		stopFlag.set();
	}

}
