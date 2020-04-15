package socket_communication_thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread2 implements Runnable{
	public Socket socket;
	public ClientThread2(Socket socket){
		this.socket = socket;
	}
	@Override
	public void run(){
		try {		
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//��ȡ����̨���������
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            while (true){
                String readLine = br.readLine();
                pw.println(readLine);//������̨���������д�뵽�����
                pw.flush();//ˢ�»���

			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
