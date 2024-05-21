package kr.or.ddit.basic.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 	udp방식 : 비연결 지향, 데이터에 대한 신뢰성이 없다. 데이터가 순서대로 도착한다는 보장이 없다.
 			그렇지만 TCP방식보다 속도가 빠르다.
 	- DatagramSocket객체와 DatagramPacket객체를 이용해서 통신한다.
 	1) DatagramSocket : 데이터의 송 수신과 관련된 작업을 수행한다. (우체부)
 	2) DatagramPacket : 주고 받는 데이터와 관련된 작업을 수행한다 (소포)
 					==> 수신을 위한 생성자와 송신을 위한 생성자를 따로 제공한다.
 					
 	- TCP의 경우에는 Stream을 이용하여 송수신하지만
 	- UDP의 경우에는 데이터그램을 이용해서 송수신한다.
 */
public class udpServer {
	public static void main(String[] args) {
		try {
			//통신할 포트 번호를 지정하여 소켓객체를 생성한다.
			DatagramSocket socket = new DatagramSocket(8888);
			System.out.println("서버 실행 중...");
			
			while(true) {
				//수신한 메시지가 저장될 변수 선언
				byte[] inMsg = new byte[1024];
				
				//수신용 패킷 객체 생성하기
				//		==> 수신한 데이터가 저장될 byte배열, 이 배열의 길이를 인수로
				//			지정하여 객체를 생성한다.
				DatagramPacket inPacket = 
						new DatagramPacket(inMsg, inMsg.length);
				
				// 데이터 수신하기 ==> receive()메서드 이용
				// ==> 이 메서드는 데이터가 올 때까지 기다린다.
				// ==> 수신된 데이터의 패킷정보는 지정한 패킷변수(inPacket)에 저장된다.
				socket.receive(inPacket);
				
				// 받은 패킷에서 상대방의 주소, 포트 번호등을 알 수 있다.
				InetAddress address = inPacket.getAddress();
				int port = inPacket.getPort();
				
				System.out.println("상대방의 IP정보 : "+address);
				System.out.println("상대방의 PORT정보 : "+port);
				System.out.println();
				
				// 수신한 메시지 화면에 출력하기
				// 수신한 패킷객체.getLength() ==> 실제 읽어온 데이터의 길이를 반환한다.
				// 수신한 패킷객체.getData() ==> 실제 읽어온 데이터를 byte형 배열로 반환한다.
				//		==> 수신용 패킷객체를 생성할 때 지정한 byte형 배열에도 저장된다.
				String msg = new String(inMsg, 0, inPacket.getLength(), "utf-8");
				
				if("/end".contentEquals(msg)) {
					break;
				}
				
				System.out.println("수신한 메시지 : "+msg);
				System.out.println();
				//------------------------------------------------------
				
				// 상대방에게 메시지 보내기 (수신 받은 메시지를 그대로 송신한다.
				
				// 송신할 메시지를 byte형 배열로 변환한다.
				byte[] sendMsg = msg.getBytes("utf-8");
				
				// 송신용 패킷객체 생성
				// ==> 전송할 데이터가 저장된 byte형 배열, 이 배열의 길이,
				//		상대방의 주소정보, 상대방의 포트번호 이렇게 4가지를 지정하여 생성한다.
				DatagramPacket outPacket =
						new DatagramPacket(sendMsg, sendMsg.length, address, port);
				
				// 전송하기 ==> DatagramSocket객체의 send()메서드 이용
				socket.send(outPacket);
				
				System.out.println("송신완료...");
				System.out.println();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
