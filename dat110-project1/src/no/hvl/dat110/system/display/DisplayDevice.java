package no.hvl.dat110.system.display;

import no.hvl.dat110.rpc.RPCServer;
import no.hvl.dat110.system.controller.Common;


public class DisplayDevice {
	
	public static void main(String[] args) {
		
		System.out.println("Display server starting ...");
		
		// TODO - START
		// implement the operation of the display RPC server
		// see how this is done for the sensor RPC server in SensorDevice
				
		RPCServer server = new RPCServer(Common.DISPLAYPORT);
		
		server.run();
		server.stop();
		
		// TODO - END
		
		System.out.println("Display server stopping ...");
		
	}
}
