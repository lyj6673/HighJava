package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TcpMultiChatClient {
	public static void main(String[] args) {
		new TcpMultiChatClient().clientCharStart();
	}
	
	public void clientCharStart() {
		Socket socket = null;
		try {
			socket = new Socket("localhost", 7777);
			System.out.println("서버에 접속되었습니다...");
			//----------------------------------------
			//쓰레드 처리
			
			ClientSender sender = new ClientSender(socket);
			ClientReceiver receiver = new ClientReceiver(socket);
			
			sender.start();
			receiver.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}// 시작 메서드 끝...
	
	//메시지 전송용 쓰레드
	
	class ClientSender extends Thread{
		private Socket socket;
		private DataOutputStream dout;
		private DataInputStream din;
		
		private String name;
		private Scanner scan;
		
		//생성자
		public ClientSender(Socket socket) {
			this.socket = socket;
			scan = new Scanner(System.in);
			
			try {
				din = new DataInputStream(this.socket.getInputStream());
				dout = new DataOutputStream(this.socket.getOutputStream());
				
				if(din!=null) {
					//대화명을 입력해서 서버로 전송하고 서버에서
					//대화명 중복여부를 검사한 결과를 받아오는 작업을
					//대화명이 중복되지 않을 때까지 반복한다.
					
					while(true) {
						System.out.println("대화명 입력>>");
						String name = scan.nextLine();
						dout.writeUTF(name);	//대화명 전송
						
						//대화명의 중복 여부 검사 결과를 받는다.
						String feedback = din.readUTF();
						
						// 중복 여부 확인하기
						if("대화명중복".equals(feedback)) {
							//대화명이 중복될 때...
							System.out.println(name+"은(는) 중복되는 대화명입니다.");
							System.out.println("다른 대화명을 입력하세요....");
						}else {
							//대화명이 중복되지 않을 때...
							this.name = name;
							System.out.println(name + "대화명으로 대화방에 입장했습니다...");
							break; //반복문 탈출
						}
					}// while문 끝..
				}// if문 끝
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}// 생성자 끝
		@Override
		public void run() {
			try {
				// 키보드로 입력한 메시지를 서버로 전송한다.
				dout.writeUTF("["+name+"]"+scan.nextLine());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		
	}// ClientSender쓰레드 끝...
	
	//-----------------------------------------------------
	//메시지 수신용 쓰레드
	class ClientReceiver extends Thread{
		private Socket socket;
		private DataInputStream din;
		
		//생성자
		public ClientReceiver(Socket socket) {
			this.socket=socket;
			try {
				din = new DataInputStream(this.socket.getInputStream());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		@Override
		public void run() {
			while(din!=null) {
				try {
					//서버로부터 받은 메시지를 화면에 출력한다.
					System.out.println(din.readUTF());
				} catch (IOException e) {
					// TODO: handle exception
				}
			}
		}
	}

}
