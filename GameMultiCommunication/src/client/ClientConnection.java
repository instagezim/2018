package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientConnection extends Thread{
	Socket s;
	DataInputStream dis;
	DataOutputStream dos;
	boolean shouldRun = true;

	public ClientConnection(Socket socket, Client client) {

		s = socket;



	}

	public void sendStringToServer(String text) {
		try {
			dos.writeUTF(text);
			dos.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public void run() {
		try {
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());

			while(shouldRun) {
				try {
					while(dis.available() == 0){//wenn nichts zu lesen ist (input)
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					String reply = dis.readUTF();		
					System.out.println(reply);
				} catch (IOException e) {
					e.printStackTrace();
					close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			close();
		}
	}





	public void close() {
		try {
			dis.close();
			dos.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
