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
		
	
		if(data != null) {
			//Den første byten skal være lengden på segmentet
			segment[0] = (byte) data.length;
				
			//Legger så inn payloaden. 
			for(int i = 1; i < data.length+1; i++) {
				
				segment[i] = data[i-1];
				
			}
		}
		
		
		
		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {

		Message message = null;
		
		System.out.println("dette er i decapsulate" + segment);
		System.out.println("typen er " + segment.getClass().getSimpleName());
		
		System.out.println("segment.length " + segment.length);
		
		
		
		//Finner først ut hvor stor payloaden er.
		int payloadSize = (int) segment[0];
		
		//Lager en tom array for å hente ut payloaden
		byte[] payload = new byte[payloadSize]; 
		
		if(payloadSize > 0) {
			for(int i = 0; i < payloadSize; i++) {
				payload[i] = segment[i+1];
			}
			
		}

		message = new Message(payload);
		
		return message;
		
	}
	
}
