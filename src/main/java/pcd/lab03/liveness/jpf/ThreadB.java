package pcd.lab03.liveness.jpf;

import pcd.lab03.liveness.BaseAgent;
import pcd.lab03.liveness.Resource;

public class ThreadB extends BaseAgent {
 
	private Resource res;
	
	public ThreadB(Resource res){
		this.res = res;
	}
	
	public void run(){
		/*
		while (true){
			waitAbit();
			res.leftRight();
		}
		*/

		res.leftRight();

	}	
}
