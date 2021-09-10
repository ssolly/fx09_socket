package tcp;
//		↑ 신뢰할수있는 통신 방식, 연결지향 (↔ udp 통신 방식)

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server01 {

public static void main(String[] args) throws Exception {
		
		/*
		 # 서버 : 서비스를 제공하는 컴퓨터
		 # 클라이언트 : 서비를 제공받는 컴퓨터
		 # 컴퓨터 용량 : bit(8) → byte(1024) → Kbyte(1024) → Mbyte(1024) → GB → TB 
		 */
		
		//(1) 자기 자신의 서버로 구동 : 자기자신의 아이피와(port번호)를 구동
		//포트port : 2byte크기를 가지고 있으며, 특정 프로그램(어플리케이션)을 구분 지어준다 (0~ 65535)
		ServerSocket server = new ServerSocket(12345);	//(포트번호)
		System.out.println("접속 대기합니다");				
		Socket sock = server.accept();					//클라이언트와 연결대기
		//↑ 클라이언트의 정보 저장하는 객체 
		System.out.println("접속되었습니다");
		
		//(3) Socket sock 객체에 저장되어있는 정보 확인
		System.out.println(sock.getInetAddress());
		
		//(5) 클라이언트로부터 데이터를 받아옴
		InputStream input = sock.getInputStream();
		int readData = input.read();
		System.out.println("클라이언트로부터 받은 데이터 : " + readData);
		input.close();
		sock.close();
	}
}
