package chatroom;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client2 {
	public static void main(String[] args){
		try {
			Socket socket = new Socket("localhost",8888);
			
			new ClientThread1(socket).start();
			new ClientThread2(socket,"lqx").start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
