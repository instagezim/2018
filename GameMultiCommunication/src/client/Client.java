package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	ClientConnection cc;


	public static void main(String[] args) {
		new Client();

	}

	public Client() {
		try {
			Socket s = new Socket("localhost", 3333);
			cc = new ClientConnection(s, this); //needs socket and this is the current object that is creating
			cc.start();
			
			listenForInput();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void listenForInput() {
		Scanner console = new Scanner(System.in); //listen for client
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
			cc.sendStringToServer(input);
		}
		cc.close();
	}

}
