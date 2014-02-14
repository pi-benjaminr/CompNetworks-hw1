import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class SimpleClient {
	public static int port = 3333;
	
	public static void main(String args[]) throws UnknownHostException, IOException {
		PrintStream log = new PrintStream(new File("ClientLog.txt"));
		Socket s = new Socket("localhost", port);
		log.println("CLIENT: Client is connected to the server");
		BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintStream ps = new PrintStream(s.getOutputStream());
		ps.println("Hello World");
		String line = r.readLine();
		log.println("CLIENT: Received: " + line);
		log.println("CLIENT: closing connection");
		ps.close();
		
	}

}
