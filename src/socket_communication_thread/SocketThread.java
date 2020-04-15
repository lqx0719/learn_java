package socket_communication_thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Socket���̴߳����� �����������˽��յ��Ŀͻ������󣨴���Socket����
 */
public class SocketThread extends Thread {
    public Socket socket;
	public SocketThread(Socket socket){
    	this.socket = socket;
    }
    public void run(){
    	InputStream inputStream;
		try {
			inputStream = socket.getInputStream();
			InputStreamReader ir = new InputStreamReader(inputStream);
			BufferedReader br = new BufferedReader(ir);
			String info="";
			String temp;
			while(true){
				temp=br.readLine();
				System.out.println(socket.getInetAddress().getHostAddress()+" ,�˿ں�: "+socket.getPort()+", ˵: " +temp);
				ArrayList<Socket> socketList = Server.socketList;
				
				for(Socket s:socketList){
					OutputStream outputStream = s.getOutputStream();
					PrintWriter pw = new PrintWriter(outputStream);
					pw.println(socket.getInetAddress().getHostAddress()+" ,�˿ں�: "+socket.getPort()+", ˵: " +temp);
					pw.flush();

				}
			}
			
//			br.close();
//			ir.close();
//			inputStream.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
}
