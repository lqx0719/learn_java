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
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//读取控制台输入的内容
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            while (true){
                String readLine = br.readLine();
                pw.println(readLine);//将控制台输入的内容写入到服务端
                pw.flush();//刷新缓存

			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
