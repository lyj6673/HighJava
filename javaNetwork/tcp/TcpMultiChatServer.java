package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TcpMultiChatServer {
	// 접속한 클라이언트 정보를 저장할 Map객체변수 선언
	//		==> key값 : 접속한 사람 이름, value값 : 접속한 Client의 Socket객체
	private Map<String, Socket> clientMap;
	
	// 생성자
	public TcpMultiChatServer() {
		// clientMap을 동기화 처리가 가능하게 생성한다.
		clientMap = Collections.synchronizedMap(
						new HashMap<String, Socket>());
	}
	
	
	public static void main(String[] args) {
		new TcpMultiChatServer().chatStart();
	}
	
	// 시작 메소드
	public void chatStart() {
		ServerSocket server = null;
		Socket socket = null;
		
		try {
			server = new ServerSocket(7777);
			System.out.println("서버가 시작 되었습니다...");
			
			while(true) {
				socket = server.accept();	// 클라이언트의 접속을 기다린다.
				
				// 접속한 클라이언트 정보 출력해 보기
				System.out.println("[" + socket.getInetAddress()
						+ " : " + socket.getPort() + "]에서 접속했습니다...");
				
				//----------------------------------
				// 쓰레드 처리
				ServerReceiver th = new ServerReceiver(socket);
				th.start();
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}	// 시작 메소드 끝...
	
	// clientMap에 저장된 전체 사용자에게 메시지를 보내는 메소드
	private void sendToAll(String msg) {
		// clientMap에 저장된 데이터 개수만큼 반복처리 한다.
		for(String name : clientMap.keySet()) {
			try {
				// key값과 한 짝으로 저장된 Socket객체를 이용하여 출력용 스트림 객체를 생성한다.
				DataOutputStream dout =
						new DataOutputStream(
								clientMap.get(name).getOutputStream());
				
				dout.writeUTF(msg);		// 메시지 보내기
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	} // sendToAll()메소드 끝...
	
	//-----------------------------------------------
	// 서버에서 클라이언트로 메시지를 전송하는 Thread를 작성한다.
	class ServerReceiver extends Thread {
		private Socket socket;
		private DataOutputStream dout;
		private DataInputStream din;
		
		// 생성자
		public ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				// 소켓을 이용하여 스트림 객체를 생성한다.
				dout = new DataOutputStream(this.socket.getOutputStream());
				din = new DataInputStream(this.socket.getInputStream());
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		} // 생성자 끝...
		
		// 한 클라이언트가 접속이 완료되면 이 클라이언트는 처음에 '대화명'을 입력 받아서 전송한다.
		// 서버는 '대화명' 수신하고 이 '대화명'이 중복되는지 여부를 검사하여 검사 겨로가를
		// 클라이언트에게 보내준다. (대화명이 중복되지 않을 때까지 반복한다.)
		// 대화명이 중복되지 않으면 해당 대화명과 Socket정보를 Map에 추가한다.
		@Override
		public void run() {
			String name = "";
			try {
				
				// 대화명이 중복되지 않을 때까지 반복...
				while(true) {
					name = din.readUTF();		// 대화명 수신하기
					
					// 대화명 중복 여부 검사
					if(clientMap.containsKey(name)) {
						// 중복될 때..
						dout.writeUTF("대화명 중복");
					} else {
						// 중복되지 않을 때..
						dout.writeUTF("사용가능");
						break;	// 반복문 탈출
					}
				} // while문 끝..
				
				// 지금 접속한 사람을 기존에 접속되어 있는 사람들에게 알려준다.
				sendToAll("[ " + name + " ]님이 대화방에 입장했습니다...");
				
				// 대화명과 클라이언트의 Socket객체를 Map에 추가
				clientMap.put(name, socket);
				
				System.out.println("현재 접속자 수 : " + clientMap.size() + "명");
				
				// 한 클라이언트가 보내온 메시지를 받아서 다른 모든 접속자에게 전송한다.
				while(din!=null) {
					sendToAll(din.readUTF());
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				// 이 finally 영역이 실행된다는 것은 클라이언트의 접속이 종료되었다는 것을 의미한다.
				sendToAll("[ " + name + " ]님이 접속을 종료했습니다...");
				
				// Map에서 해당 자료를 삭제한다.
				clientMap.remove(name);
				
				System.out.println("[" + socket.getInetAddress()
					+ " : " + socket.getPort() + "]에서 접속을 종료했습니다...");
				System.out.println();
				
				System.out.println("현재 접속자 수 : " + clientMap.size() + "명");
				System.out.println();
			}
		}
	}
	
}
