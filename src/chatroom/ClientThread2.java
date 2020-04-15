package chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import net.sf.json.JSONObject;


public class ClientThread2 extends Thread{
	public Socket socket;
	public String name;
	public ClientThread2(Socket socket,String name){
		this.socket = socket;
		this.name= name;
	}
	public void run(){
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("name", name);
			
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			while(true){
				String message = br.readLine();
				jsonObject.put("message", message);
				pw.println(jsonObject.toString());
				pw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
