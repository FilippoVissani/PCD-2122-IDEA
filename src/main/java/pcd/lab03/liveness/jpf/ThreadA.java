package pcd.lab03.liveness.jpf;

import pcd.lab03.liveness.BaseAgent;
import pcd.lab03.liveness.Resource;

public class ThreadA extends BaseAgent {
 
	private Resource res;
	
	public ThreadA(Resource res){
		this.res = res;
	}
	
	public void run(){
		/*
		while (true){
			waitAbit();
			res.rightLeft();
		}*/

		res.rightLeft();
	}	
}
