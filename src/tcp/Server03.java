package tcp;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server03 {

	public static void main(String[] args) throws Exception {
		
		//main은 main대로 동작 후 thread 생성해서 생성한 곳에서 대기
		
		ServerSocket server = new ServerSocket(12345);
		System.out.println("서버 실행");
		
		while(true) {
			System.out.println("접속 대기중");
			Socket s = server.accept();		// (1) 클라이언트 대기
			new UserThread(s);				// (2) 클라이언트 만나면 userThread와 만남
		}
	}
}

class UserThread extends Thread {
	
	Socket s;								// (3) 클라이언트 정보
	
	public UserThread(Socket s) {			// (4) 클라이언트와 연결
		this.s = s;
		System.out.println(s.getInetAddress()+"님 접속 완료");
		start();
	}
	
	public void run() {						// (5) 개별 동작
		InputStream in;
		String readData = null;
		
		try {
			in = s.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			readData = dis.readUTF();		// (6) 여기서 대기
			System.out.println("전송받은 데이터 : " + readData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}