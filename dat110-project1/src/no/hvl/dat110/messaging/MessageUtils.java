package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static final int MESSAGINGPORT = 8080;
	public static final String MESSAGINGHOST = "localhost";
	
	public static byte[] encapsulate(Message message) {
		
		byte[] segment = null;
		byte[] data;

		//Henter ut data fra meldingen
		data = message.getData();
		
		//Oppretter et nytt segment, som vi vet skal være 128 bytes
		segment = new byte[SEGMENTSIZE];
		
		Integer length = data.length;
	
		//Den første byten skal være lengden på segmentet
		segment[0] = length.byteValue();
				
		//Legger så inn payloaden. 
		for(int i = 0; i < data.length; i++) {
				
			segment[i+1] = data[i];
				
		}
		
		
		
		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {

		Message message = null;
		
		byte length = segment[0];
		
		//Lager en tom array for å hente ut payloaden
		byte[] payload = new byte[length]; 
		
		for(int i = 0; i < length; i++) {
			payload[i] = segment[i+1];
		}
			
		
		message = new Message(payload);
		
		return message;
		
	}
	
}
