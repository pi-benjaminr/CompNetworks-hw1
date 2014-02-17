import java.io.IOException;
import java.net.UnknownHostException;


public class BenchmarkClient {
	
	private static final int NUM = 1000000;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		long startTime, endTime;
		double durationSimple, durationMT;
		
		SimpleClient.port = 3333;
		
		System.out.println("Starting to test SimpleServer...");
		startTime = System.nanoTime();
		Thread runClient = new Thread(); //this variable will be used to tell us when the last thread finishes
		for (int i = 0; i < NUM; i++) { //spawn NUM threads
			runClient = new Thread() {
				public void run(){
					try {
						SimpleClient.main(null);
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		}
		runClient.join(); //waits for last thread to finish
		endTime = System.nanoTime();
		durationSimple = (endTime - startTime)/1000000000.0;
		
		
		
		SimpleClient.port = 4444;
		System.out.println("Starting to test MTServer...");
		startTime = System.nanoTime();
		for (int i = 0; i < NUM; i++) { //spawn NUM threads
			runClient = new Thread() {
				public void run(){
					try {
						SimpleClient.main(null);
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		}
		runClient.join(); //waits for the last thread to finish
		endTime = System.nanoTime();
		durationMT = (endTime - startTime)/1000000000.0;
		
		System.out.println("Runtime for " + NUM + " clients (in seconds):");
		System.out.println("Simple Server\t\t...\t" + durationSimple);
		System.out.println("Multithreaded Server\t...\t" + durationMT);
		
		
	}
	
	
}
