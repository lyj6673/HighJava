package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TcpClient01 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Scanner scan = new Scanner(System.in);
		
		// 자신의 컴퓨터를 나타내는 방법
		// 1) 원래의 IP주소 : 예) 192.168.145.13
		// 2) 지정된 IP주소 : 127.0.0.1
		// 3) 원래의 컴퓨터 이름 : 예) DESKTOP-R6MIO5K
		// 4) 지정된 컴퓨터 이름 : localhost
		
		System.out.println("서버에 접속합니다...");
		
		// 접속할 서버의 IP주소(또는 컴퓨터이름)와 포트번호를 지정하여 Socket객체를 생성한다.
		// Socket객체는 생성이 완료되면 지정한 서버로 요청 신호를 보낸다.
		
//		Socket socket = new Socket("서버의 IP주소 또는 컴퓨터 이름", 포트번호);
		Socket socket = new Socket("localhost", 7777);
		
		// Socket객체가 생성된 이후는 서버와 연결이 완료된 상태가 된다.
		// 그러므로 서버에 연결된 상태에서 처리할 애용을 작성하면 된다.
		System.out.println("서버에 연결되었습니다...");
		System.out.println();
		
		System.out.print("서버로 보낼 메시지 입력 >> ");
		String str = scan.nextLine();
		
		// 서버로 데이터(메시지) 보내기
		OutputStream out = socket.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);
		
		dout.writeUTF(str);
		System.out.println("메시지를 보냈습니다...");
		System.out.println("-------------------------");
		System.out.println();
		
		// 서버가 보내준 메시지를 받아서 출력하기
		DataInputStream din = new DataInputStream(socket.getInputStream());
		System.out.println("서버로부터 받은 메시지 : " + din.readUTF());
		System.out.println();
		
		System.out.println("연결을 종료합니다...");
		
		
		// 스트림과 소켓 닫기
		dout.close();
		din.close();
		socket.close();
	}
}
