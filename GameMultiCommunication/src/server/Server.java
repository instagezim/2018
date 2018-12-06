package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	ServerSocket ss;
	ArrayList<ServerConnection> connections = new ArrayList<ServerConnection>();
	boolean shouldRun = true;

	
	
	public static void main(String[] args) {
		new Server();
	}
	
	public Server() {
		try { //because when the port is blocked
			while(shouldRun) {
				ss = new ServerSocket(3333); //listen connections
				Socket s = ss.accept(); //pull it in socket
				ServerConnection sc = new ServerConnection(s, this); //
				connections.add(sc); //add serverconnetion to arraylist
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	
}
