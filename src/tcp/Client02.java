package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client02 {

	public static void main(String[] args) throws Exception {
		
		Socket sock = new Socket("localhost",12345);
		
		InputStream is = sock.getInputStream();
		DataInputStream di = new DataInputStream(is);
		
		OutputStream os = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		String readData = di.readUTF();
		System.out.println("서버로부터 입력 확인 : " + readData);
		
		System.out.print("서버로 전송할 데이터 입력 : ");
		String s = new Scanner(System.in).next();
		dos.writeUTF(s);
		System.out.println("전송 완료");
		
		dos.close(); 
		os.close(); 
		sock.close();
		
	}
}
