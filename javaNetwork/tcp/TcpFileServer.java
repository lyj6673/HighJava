package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 파일을 전송하는 통신 프로그램을 작성하시오.
 
 서버가 준비되고 클라이언트가 서버에 접속하면
 1) 클라이언트가 'd:d_other/'폴더에 있는  '코알라.jpg'파일을
 	읽어서 서버로 전송한다.
 2) 서버는 클라이언트가 보내온 이미지 파일 데이터를 받아서
 	서버의  'd:d_other/연습용' 폴더에 저장한다.
 	
 	-- 서버 프로그램 : TcpFileServer
 	-- 클라이언트 : TcpFileClient
 */
public class TcpFileServer {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(7777);
		
		System.out.println("서버가 준비 중입니다..");
		
		Socket socket = server.accept();
		
		InputStream fin = socket.getInputStream();
		DataInputStream din = new DataInputStream(fin);
		
		try {
			FileOutputStream fout =
					new FileOutputStream("d:/d_other/연습용/복사본_코알라.jpg");
			
			System.out.println("저장 작업 시작");
			
			int data;	//읽어온 데이터를 저장할 변수
			
			while((data = fin.read()) != -1) {
				fout.write(data);
			}
			
			//스트림 닫기
			fout.close();
			fin.close();
			System.out.println("저장작업 끝");
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
