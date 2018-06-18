package networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub

		System.out.println("Client started");
		Socket sk = new Socket("Localhost",6665);
		System.out.println("Client connected to server");
		Scanner sc = new Scanner(System.in);
		String msg;
		do{
			
			
			//Receiving message
			InputStream is = sk.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			String str = dis.readUTF();
			System.out.println("Server: " + str);
				
			
			//Sending message
			OutputStream os = sk.getOutputStream();
			DataOutputStream dout = new DataOutputStream(os);
			System.out.println("Send message to server (X to exit): ");
			msg = sc.nextLine();
			
			dout.writeUTF(msg);
			dout.flush();
		}while(msg.equalsIgnoreCase("X"));
		
		sc.close();
		sk.close();	

	}

}
