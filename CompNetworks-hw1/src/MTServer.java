import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class MTServer {
	private static final int PORT = 4444;
	
	public static void main(String args[]) throws IOException {
		PrintStream log = new PrintStream(new File("MTServerLog.txt"));
		
		ServerSocket ss = new ServerSocket(PORT);
		log.println("SERVER: ServerSocket created");
		while (true) {
			log.println("MAIN: Waiting for client connection on port " + PORT);				
			Socket cs = ss.accept();
			log.println("MAIN: Client connected");
			new WorkerThread(cs, log).start();
		}
	}

}
