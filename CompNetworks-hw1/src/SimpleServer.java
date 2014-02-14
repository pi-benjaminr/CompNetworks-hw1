import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class SimpleServer {
	
	private static final int PORT = 3333;
	
	public static void main(String[] args) throws IOException { 
		PrintStream log = new PrintStream(new File("SimpleServerLog.txt"));
		
		ServerSocket ss = new ServerSocket(PORT);
		log.println("SERVER: ServerSocket created");
		while (true) {
			log.println("SERVER: Waiting for connection on port: " + PORT);
			Socket cs = ss.accept();
			log.println("SERVER: Client connected");
			
			BufferedReader r = new BufferedReader(new InputStreamReader(cs.getInputStream()));
			PrintStream ps = new PrintStream(cs.getOutputStream());
			String line;
			while ((line = r.readLine()) != null) {
				log.println("SERVER: Received: " + line);
				ps.println(line.toUpperCase());
			}
			log.println("SERVER: Client Disconnected");
			r.close();
			
		}
	}

}
