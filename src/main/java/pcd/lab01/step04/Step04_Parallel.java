package pcd.lab01.step04;

public class Step04_Parallel {

	public static void main(String[] args) throws Exception {
		int size = 1000;
		int n = size; 
		int k = size; 
		int m = size; 
		
		boolean debugging = false;

		System.out.println("Testing A["+n+","+k+"]*B["+k+","+m+"]");

		System.out.println("Initialising...");

		Mat matA = new Mat(n,m);
		matA.initRandom(10);

		if (debugging) {
			System.out.println("A:");
			matA.print();
		}
		
		Mat matB = new Mat(m,k);
		matB.initRandom(10);
		
		if (debugging){
			System.out.println("B:");
			matB.print();
		}
		
		System.out.println("Initialising done.");
		System.out.println("Computing matmul...");


		int nWorkers =  Runtime.getRuntime().availableProcessors() + 1;
		MatMulConcurLib.init(nWorkers);
				
		Chrono cron = new Chrono();
		cron.start();
		Mat matC = MatMulConcurLib.matmul(matA, matB);
		cron.stop();
						
		System.out.println("Computing matmul done.");

		if (debugging){
			System.out.println("C:");
			matC.print();
		}
		
		System.out.println("Time elapsed: "+cron.getTime()+" ms.");
		
	}

}
