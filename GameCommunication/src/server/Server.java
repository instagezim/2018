package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	ServerSocket ss;
	Socket s1;
	DataInputStream dis;
	DataOutputStream dos;
	
	
	public static void main(String[] args) {
		new Server();
	}
	
	public Server() {
		try { //because when the port is blocked
			ss = new ServerSocket(3333);
			//accept a connection
			s1=ss.accept(); //socket variable s1 besetzt
			dis = new DataInputStream(s1.getInputStream());
			dos= new DataOutputStream(s1.getOutputStream());
			listenForData();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	private void listenForData() {
		while(true){
			try {
				while(dis.available() == 0) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				String dataIn = dis.readUTF();
				dos.writeUTF(dataIn);
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
			
		}
		//close resources
				try {
					dis.close();
					dos.close();
					s1.close();
					ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
}
