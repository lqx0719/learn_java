package socket_communication_thread;


import java.awt.List;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    /**
     * Socket�����
     */
	public static ArrayList<Socket> socketList = new ArrayList<Socket>();
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("��������������ȴ��ͻ�������..");

            while (true) {
                Socket socket = serverSocket.accept();// ���������ܵ����׽��ֵ�����,����һ��Socket����
                socketList.add(socket);
                SocketThread socketThread = new SocketThread(socket);
                socketThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
