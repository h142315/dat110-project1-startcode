package no.hvl.dat110.messaging;


import java.io.IOException;

import java.net.Socket;
import java.net.UnknownHostException;

import no.hvl.dat110.TODO;

public class MessagingClient {
	
	private String server;
	private int port;
	
	public MessagingClient(String server, int port) {
		this.server = server;
		this.port = port;
	}
	
	// connect to messaging server
	public Connection connect () {
			
		Socket clientSocket;
		Connection connection = null;
		
		// TODO - START
		// create TCP socket for client and connection
		
		try {
			//Lager en ny Socket ved å sende inn server og port
			clientSocket = new Socket(server, port);
			
			//Lager et nytt objekt av Connection-klassen, med socket som parameter.
			connection = new Connection(clientSocket);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// TODO - END
		return connection;
	}
}
