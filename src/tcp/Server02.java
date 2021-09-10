package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server02 {

	public static void main(String[] args) throws Exception {
		
		ServerSocket server = new ServerSocket(12345);
		Socket sock = server.accept();
		
		InputStream is = sock.getInputStream();
		DataInputStream di = new DataInputStream(is);	//다양한 타입을 받을 수 있음
		
		OutputStream os = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		System.out.print("서버연결 확인 : ");
		String s = new Scanner(System.in).next();
		dos.writeUTF(s);

		
		String readData = di.readUTF();
		System.out.println("클라이언트로부터 전송받은 데이터 : " + readData);
		
		di.close();
		is.close();
		sock.close();
		server.close();
	}
}
