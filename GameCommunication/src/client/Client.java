package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	Socket cs;
	DataInputStream dis;
	DataOutputStream dos;
	
	
	public static void main(String[] args) {
		new Client();

	}
	
	public Client() {
		try {
			cs = new Socket("localhost", 3333);
			dis = new DataInputStream(cs.getInputStream());
			dos = new DataOutputStream(cs.getOutputStream());
			
			listenForInput();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void listenForInput() {
		Scanner console = new Scanner(System.in);
		//listen for client
		while(true) {//user entred
			while(!console.hasNextLine()){ //only run wenn we click run
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
 					e.printStackTrace();
				} //cpu asks the whole time: is there a line? is there a line?
			}
			String input = console.nextLine();
			
			if(input.toLowerCase().equals("quit")) {
				break;
			}
			
			try {
				dos.writeUTF(input);
				dos.flush(); //neu erweitert!?
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
				break; //wait of the while bellow
			}
		}
		
		
		//close resources
		try {
			dis.close();
			dos.close();
			cs.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
