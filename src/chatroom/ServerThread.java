package chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ServerThread extends Thread{
	public Socket socket;
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	public void run(){
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(true){
				String info = br.readLine();
				JSONObject jsonObject = JSONObject.fromObject(info);
				String name = jsonObject.getString("name");
				String message = jsonObject.getString("message");
				System.out.println(socket.getInetAddress().getHostAddress()+" , "+socket.getPort()+" : "+message);
				for(Socket s :Server.socketList){
					PrintWriter pw = new PrintWriter(s.getOutputStream());
					
					pw.println(name+" : "+message);
					pw.flush();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
