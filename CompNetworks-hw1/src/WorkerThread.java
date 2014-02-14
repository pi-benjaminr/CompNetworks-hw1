import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


public class WorkerThread extends Thread {
	
	Socket clientSocket;
	PrintStream log;
	
	public WorkerThread(Socket cs, PrintStream log) {
		this.clientSocket = cs;
		this.log = log;
	}

	@Override
	public void run() {
		log.println("WORKER" + Thread.currentThread().getId()
				+ ": Worker thread starting");
		try {
			BufferedReader r = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintStream ps = new PrintStream(clientSocket.getOutputStream());
			String line;
			while ((line = r.readLine()) != null) {
				log.println("WORKER" + Thread.currentThread().getId() + ": Received: " + line);
				ps.println(line.toUpperCase());
			}
			log.println("WORKER" + Thread.currentThread().getId() + ": Client disconnected");
			r.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.println("WORKER" + Thread.currentThread().getId() + ": Worker thread finished");
	}
	
	

}
