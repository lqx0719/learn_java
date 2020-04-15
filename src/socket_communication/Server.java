package socket_communication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	public static void main(String[] args){
		try {
			ServerSocket serverSocket = new ServerSocket(8888);
			System.out.println("等待客户端连接中.....");
			Socket socket = serverSocket.accept();
			
			InputStream inputStream = socket.getInputStream();
			InputStreamReader isReader = new InputStreamReader(inputStream);
			BufferedReader br = new BufferedReader(isReader);
			String info="";
			String temp;
			while((temp = br.readLine())!=null){
				info += temp;
				System.out.println("已接收到客户端连接");
				System.out.println("当前客户端的信息："+info+" 。当前客户端的地址为："+socket.getInetAddress().getHostName());
			}
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter printWriter=new PrintWriter(outputStream);
			printWriter.print("服务器已经收到客户端的消息！");
			printWriter.flush();
			socket.shutdownOutput();
			
			printWriter.close();
			outputStream.close();
			br.close();
			isReader.close();
			inputStream.close();
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
