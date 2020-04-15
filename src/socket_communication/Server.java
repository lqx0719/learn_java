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
			System.out.println("�ȴ��ͻ���������.....");
			Socket socket = serverSocket.accept();
			
			InputStream inputStream = socket.getInputStream();
			InputStreamReader isReader = new InputStreamReader(inputStream);
			BufferedReader br = new BufferedReader(isReader);
			String info="";
			String temp;
			while((temp = br.readLine())!=null){
				info += temp;
				System.out.println("�ѽ��յ��ͻ�������");
				System.out.println("��ǰ�ͻ��˵���Ϣ��"+info+" ����ǰ�ͻ��˵ĵ�ַΪ��"+socket.getInetAddress().getHostName());
			}
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter printWriter=new PrintWriter(outputStream);
			printWriter.print("�������Ѿ��յ��ͻ��˵���Ϣ��");
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
