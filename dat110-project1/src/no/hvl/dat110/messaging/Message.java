package no.hvl.dat110.messaging;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] data;

	public Message(byte[] data) {
		
		//Sjekker at data ikke er null og at lengden er mindre eller lik 127. 
		if(data != null && data.length <= 127) {
			this.data = data;
		}
		else {
			System.out.println("Data of wrong format");
		}
		
	}

	public byte[] getData() {
		return this.data; 
	}

}
