package no.hvl.dat110.messaging;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import no.hvl.dat110.TODO;


public class Connection {

	private DataOutputStream outStream; // for writing bytes to the TCP connection
	private DataInputStream inStream; // for reading bytes from the TCP connection
	private Socket socket; // socket for the underlying TCP connection
	
	public Connection(Socket socket) {

		try {

			this.socket = socket;

			outStream = new DataOutputStream(socket.getOutputStream());

			inStream = new DataInputStream (socket.getInputStream());

		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void send(Message message) {

		byte[] data;
		
		try {
			
			//Bruker metoden fra MessageUtils for å innkapsle meldingen
			data = MessageUtils.encapsulate(message);
			
			//Skriver dataen til outStream
			outStream.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public Message receive() {

		Message message = null;
		byte[] data;
		
		System.out.println("Er no i receive-metoden");
				
		try {
			//Bruker intStream for å lese inn alle bytes
			data = inStream.readNBytes(MessageUtils.SEGMENTSIZE);
			System.out.println("[Connection]: receive --> data: " + data.toString());
			
			//Lager en ny melding ved å pakke ut data ved hjelp av metoden i MessageUtils
			message = MessageUtils.decapsulate(data);
			System.out.println("[Connection]: receive --> message: " + message.getData().length);

		} catch (IOException e) {
			System.out.println("Det gikk ikke :(");
			e.printStackTrace();
		}
		
		
		return message;
		
	}

	// close the connection by closing streams and the underlying socket	
	public void close() {

		try {
			
			outStream.close();
			inStream.close();

			socket.close();
			
		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}