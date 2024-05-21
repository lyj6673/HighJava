package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 파일을 전송하는 통신 프로그램을 작성하시오.

서버가 준비되고 클라이언트가 서버에 접속하면
1) 클라이언트가 'd:/d_other/' 폴더에 있는 '코알라.jpg'파일을
    읽어서 서버로 전송한다.
    ( 파일을 읽어서 소켓으로 출력한다. )
    
2) 서버는 클라이언트가 보내온 이미지 파일 데이터를 받아서
   서버의 'd:/d_other/연습용' 폴더에 저장한다.
   ( 소켓으로 읽어서 파일로 저장한다. )
   
   -- 서버프로그램 : TcpFileServer
   -- 클라이언트    : TcpFileClient
 */

public class TcpFileServer2 {
	public static void main(String[] args) {
		File saveDir = new File("d:/d_other/연습용");
		if(!saveDir.exists()) {
			saveDir.mkdirs();
		}
		
		ServerSocket server = null;
		Socket socket = null;
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		try {
			server = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다...");
			
			socket = server.accept();
			
			System.out.println("파일 수신 시작...");
			
			// 클라이언트는 전송할 파일 이름을 먼저 전송한 후
			// 파일의 내용을 읽어서 전송하는 순서로 작업이 진행될 예정
			
			// 클라이언트가 보내온 파일 이름 수신하기
			DataInputStream din =
					new DataInputStream(socket.getInputStream());
			String fileName = din.readUTF();
			
			// 저장할 파일 정보를 갖는 파일 객체 생성
			File saveFile = new File(saveDir, fileName);
			
			bin = new BufferedInputStream(din);
			bout = new BufferedOutputStream(new FileOutputStream(saveFile));
			
			byte[] temp = new byte[1024];
			int length = 0;
			
			while((length = bin.read(temp)) > 0) {
				bout.write(temp, 0, length);
			}
			bout.flush();
			System.out.println("파일 수신 작업 완료...");
			
		} catch (Exception e) {
			System.out.println("파일 작업 실패 !!!");
			e.printStackTrace();
		} finally {
			if(bin!=null) try { bin.close(); } catch (IOException e) { }
			if(bout!=null) try { bout.close(); } catch (IOException e) { }
			if(socket!=null) try { socket.close(); } catch (IOException e) { }
			if(server!=null) try { server.close(); } catch (IOException e) { }
		}
	}
}


/*
public class TcpFileServer {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(7777);
		System.out.println("서버의 접속을 기다립니다...");
		System.out.println();
		
		Socket socket = server.accept();
		
		System.out.println("클라이언트가 연결되었습니다...");
		System.out.println();
		
		System.out.println("접속한 상대방 컴퓨터의 정보 확인...");
		System.out.println("IP주소 : " +
					socket.getInetAddress().getHostAddress());
		System.out.println("Port번호 : " + socket.getPort());
		System.out.println();
		
		System.out.println("현재 컴퓨터의 정보 확인...");
		System.out.println("IP주소 : " + socket.getLocalAddress());
		System.out.println("Port번호 : " + socket.getLocalPort());
		System.out.println("-------------------------------------");
		System.out.println();
		
		InputStream in = socket.getInputStream();
		DataInputStream din = new DataInputStream(in);
		
		FileOutputStream fout = new FileOutputStream("D:/D_Other/연습용/복사본_코알라.jpg");
		
		int data;
		
		while((data = din.read()) != -1) {
			fout.write(data);
		}
		
		System.out.println();
		System.out.println("연결을 종료합니다...");

		in.close();
		din.close();
		fout.close();
		socket.close();
		server.close();
	}
}
*/