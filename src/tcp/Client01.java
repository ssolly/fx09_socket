package tcp;

import java.io.OutputStream;
import java.net.Socket;

public class Client01 {

	public static void main(String[] args) throws Exception {
		
		//(2) 서버와 접속 시도
		Socket sock = new Socket("localhost",12345);	//접속하고자하는 서버주소,서버포트 
		
		//(4) stream : 데이터를 주고 받는 통로
		OutputStream out = sock.getOutputStream();
		out.write(100);	// (데이터), 서버로 전송하는 데이터
		out.close();
		sock.close();
		
	}
	
}
