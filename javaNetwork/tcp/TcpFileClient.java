package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpFileClient {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost",7777);
			System.out.println("코알라.jpg를 저장합니다");
			File sourceFile = new File("d:/d_other/코알라.jpg");
			
			FileInputStream fin = new FileInputStream(sourceFile);

			OutputStream out = socket.getOutputStream();
			
			int data;	//읽어온 데이터를 저장할 변수
			
			while((data = fin.read()) != -1) {
				out.write(data);
			}
			
			// 스트림과 소켓 닫기
			out.close();
			fin.close();
			socket.close();
			System.out.println("서버에 저장되었습니다");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
