package tcp;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server02 {

	public static void main(String[] args) throws Exception {
		
		ServerSocket server = new ServerSocket(12345);
		Socket sock = server.accept();
		
		InputStream is = sock.getInputStream();
		DataInputStream di = new DataInputStream(is);	//다양한 타입을 받을 수 있음
		
		String readData = di.readUTF();
		System.out.println("클라이언트로부터 전송받은 데이터 : " + readData);
		
		di.close();
		is.close();
		sock.close();
		server.close();
	}
}
