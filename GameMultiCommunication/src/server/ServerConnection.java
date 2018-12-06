package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerConnection extends Thread { //necessary for multithread
	Socket socket;
	Server server;
	DataInputStream dis;
	DataOutputStream dos;
	boolean shouldRun = true;
	
	public ServerConnection(Socket socket, Server server) {
		super("ServerConnectionThread");
		this.socket = socket;
		this.server = server;
	}
	
	public void sendStringToAllClients (String text) {
		try {
			dos.writeUTF(text);
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void sendStringToClient(String text) {
		for (int index = 0; index > server.connections.size(); index++){
			ServerConnection sc = server.connections.get(index);
			sc.sendStringToClient(text);
		}
	}
	
	
	public void run() { //here we get datainput and output stream open from client
		try {
			dis = new DataInputStream(socket.getInputStream()); //socket statt s1
			dos= new DataOutputStream(socket.getOutputStream());

			
			while(shouldRun) {
				while(dis.available()==0) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				String textIn = dis.readUTF();
				sendStringToAllClients(textIn);
			}
			dis.close();
			dos.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
