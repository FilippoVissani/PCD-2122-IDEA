package pcd.lab03.liveness;

public class ThreadB extends BaseAgent {
 
	private Resource res;
	
	public ThreadB(Resource res){
		this.res = res;
	}
	
	public void run(){
		while (true){
			waitAbit();
			res.leftRight();
		}
	}	
}
