package socket_communication_thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import org.omg.CORBA.portable.InputStream;

public class ClientThread1 implements Runnable{
	public Socket socket;
	public ClientThread1(Socket socket){
		this.socket = socket;
	}
	@Override
	public void run(){
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String info = "";
			String temp;
			while((temp = br.readLine())!= null){
				System.out.println(temp);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
