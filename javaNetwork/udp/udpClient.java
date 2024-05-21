package kr.or.ddit.basic.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class udpClient {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		try {
			// 소켓 생성
			DatagramSocket socket = new DatagramSocket();
			
			//상대방의 주소 정보 구성하기
			InetAddress address = InetAddress.getByName("localhost");
			
			while(true) {
				// 전송할 메시지 입력
				System.out.println("전송할 메시지 입력 >>");
				String msg = scan.nextLine();
				
				// 전송용 패킷 객체 생성
				DatagramPacket outPacket = 
						new DatagramPacket(msg.getBytes("utf-8"),
								msg.getBytes("utf-8").length, address, 8888);
				// 전송하기
				socket.send(outPacket);
				
				if("/end".contentEquals(msg)) break;	//작업 중지 여부 검사
				
				System.out.println();
				
				// 상대방 보낸 메시지 받기
				byte[] inMsg = new byte[1024];
				
				// 수신용 패킷객체 생성
				DatagramPacket inPacket = 
						new DatagramPacket(inMsg, inMsg.length);
				
				// 데이터 수신하기
				socket.receive(inPacket);
				
				String message = new String(inPacket.getData(), 0, inPacket.getLength(), "utf-8");
				System.out.println("서버에서 보내온 메시지 : "+ message);
				System.out.println();
						
			}
			System.out.println("통신 끝");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
