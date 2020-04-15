package chatroom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	public static ArrayList<Socket> socketList = new ArrayList<Socket>();
	public static void main(String[] args){
		try {
			ServerSocket serverSocket = new ServerSocket(8888);
			System.out.println("服务器已建立，等待连接中.....");
			while(true){
				Socket socket = serverSocket.accept();
				socketList.add(socket);
				new ServerThread(socket).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
