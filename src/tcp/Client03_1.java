package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client03_1 {

	public static void main(String[] args) throws Exception {
		Socket sock = new Socket("localhost",12345);
		
		OutputStream os = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		System.out.print("서버로 전송할 데이터 입력 : ");
		String s = new Scanner(System.in).next();
		dos.writeUTF(s);
		System.out.println("전송 완료");
		
		dos.close(); 
		os.close(); 
		sock.close();
	}
}
