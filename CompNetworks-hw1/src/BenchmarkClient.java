import java.io.IOException;
import java.net.UnknownHostException;


public class BenchmarkClient {
	
	private static final int NUM = 10000;
	
	public static void main(String[] args) throws IOException {
		
		long startTime, endTime;
		double durationSimple, durationMT;
		
		SimpleClient.port = 3333;
		
		System.out.println("Starting to test SimpleServer...");
		startTime = System.nanoTime();
		for (int i = 0; i < NUM; i++) {
			Thread runClient = new Thread() {
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
		endTime = System.nanoTime();
		durationSimple = (endTime - startTime)/1000000000.0;
		
		
		
		SimpleClient.port = 4444;
		System.out.println("Starting to test MTServer...");
		startTime = System.nanoTime();
		for (int i = 0; i < NUM; i++) {
			Thread runClient = new Thread() {
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
		endTime = System.nanoTime();
		durationMT = (endTime - startTime)/1000000000.0;
		
		System.out.println("Runtime for " + NUM + " clients (in seconds):");
		System.out.println("Simple Server\t\t...\t" + durationSimple);
		System.out.println("Multithreaded Server\t...\t" + durationMT);
		
		
	}
	
	
}
