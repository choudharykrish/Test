package networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("Server started");
		ServerSocket ss = new ServerSocket(6665);
		System.out.println("Waiting for client");
		Socket sk = ss.accept();
		System.out.println("Client connected");
		Scanner sc = new Scanner(System.in);
		String msg;
		do{
			
			//Sending message
			OutputStream os = sk.getOutputStream();
			DataOutputStream dout = new DataOutputStream(os);
			System.out.println("Send message to Client (X to exit): ");
			msg = sc.nextLine();
			
			dout.writeUTF(msg);
			dout.flush();
			
			//Receiving message
			InputStream is = sk.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			String str = dis.readUTF();
			System.out.println("Client: " + str);
		}while(msg.equalsIgnoreCase("X"));
		ss.close();
		sk.close();	
		sc.close();
	}

}
