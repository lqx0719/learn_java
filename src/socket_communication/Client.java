package socket_communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {

    /**
     * Socket客户端
     */
    public static void main(String[] args) {
        try {
			Socket socket = new Socket("localhost",8888);
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream);
			printWriter.print("服务器您好，我是LQXJason！");
			printWriter.flush();
			socket.shutdownOutput();
			
			InputStream inputStream = socket.getInputStream();
			InputStreamReader ir = new InputStreamReader(inputStream);
			BufferedReader br = new BufferedReader(ir);
			String info="";
			String temp;
			while((temp = br.readLine())!=null){
				info += temp;
				System.out.println("服务器发来的信息："+info);
			}
			
			br.close();
			ir.close();
			printWriter.close();
			outputStream.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

    }

}
