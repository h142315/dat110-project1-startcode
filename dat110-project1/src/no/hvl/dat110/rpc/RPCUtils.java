package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import no.hvl.dat110.TODO;

public class RPCUtils {
	
	public static byte[] encapsulate(byte rpcid, byte[] payload) {
		
		byte[] rpcmsg = null;
		
		// TODO - START
		
		// Encapsulate the rpcid and payload in a byte array according to the  RPC message syntax
		
		System.out.println("rpcid: " + rpcid);
		System.out.println("payload: " + payload);
		
		if(payload != null) {
			rpcmsg = new byte[(payload.length)+1];
			
			rpcmsg[0] = rpcid;
				
				
			for(int i = 0; i < payload.length; i++) {
				rpcmsg[i+1] = payload[i];
			}
		}
		
		System.out.println("Ny pakke klar: " + rpcmsg.length + ", "+ rpcmsg);
		
		// TODO - END
		
		return rpcmsg;
	}
	
	public static byte[] decapsulate(byte[] rpcmsg) {
		
		byte[] payload = null;
		
		// TODO - START
		
		// Decapsulate the rpcid and payload in a byte array according to the  RPC message syntax
		
		// Den første byten skal fortelle hva som er id
		byte rpcid = rpcmsg[0];
		
		// Payload skal være så stor som hele meldingen, minus 1 for den første
		payload = new byte[rpcmsg.length-1];
		
		// Går gjennom meldingen, og legger til hver byte
		for(int i = 0; i < rpcmsg.length-1; i++) {
			payload[i] = rpcmsg[i+1];
		}
			
		// TODO - END
		return payload;
		
	}
	
	public static byte[] marshallString(String str) {
		
		byte[] encoded = null;
		
		// TODO - START 
		
		// Lager en byte-array av String ved å bruke metoden getBytes.
		encoded = str.getBytes();
		
		// TODO - END
		
		return encoded;
	}
	
	public static String unmarshallString(byte[] data) {
		
		String decoded = null; 
		
		// TODO - START 
		
		// Henter tilbake strengen ved å bruke new String, og sende inn data og at det er UTF8 vi bruker. 
		decoded = new String(data, StandardCharsets.UTF_8);

		// TODO - END
		
		return decoded;
	}
	
	public static byte[] marshallVoid() {
		
		byte[] encoded = null;
		
		// TODO - START 
		
		encoded = new byte[0];
		// TODO - END
		
		return encoded;		
	}
	
	public static void unmarshallVoid(byte[] data) {
		
		///???????
		
		
	}
	
	public static byte[] marshallBoolean(boolean b) {
		
		byte[] encoded = new byte[1];
				
		if (b) {
			encoded[0] = 1;
		} else
		{
			encoded[0] = 0;
		}
		
		return encoded;
	}
	
	public static boolean unmarshallBoolean(byte[] data) {
		
		return (data[0] > 0);
		
	}
	
	public static byte[] marshallInteger(int x) {
		
		byte[] encoded = null;
		
		// TODO - START 
		
		// Lager en bytebuffer med 4 plasser siden det er en int
		ByteBuffer bb = ByteBuffer.allocate(4);
		
		// Putter inn tallet 
		bb.putInt(x);
		
		// Bruker .array for å hente ut arrayet til denne bufferen
		encoded = bb.array();
		// TODO - END
		
		return encoded;
	}
	
	
	public static int unmarshallInteger(byte[] data) {
		
		int decoded = 0;
		
		// TODO - START 
		
		// Bruker bytebuffer for å hente ut igjen integerverdien fra byte-arrayen
		decoded = ByteBuffer.wrap(data).getInt();
		// TODO - END
		
		
		return decoded;
		
	}
}
