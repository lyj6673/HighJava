package kr.or.ddit.basic.tcp;

import java.awt.Panel;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
1) 클라이언트가 'd:/d_other/' 폴더에 있는 '코알라.jpg'파일을
   읽어서 서버로 전송한다.
   ( 파일을 읽어서 소켓으로 출력한다. )
*/
public class TcpFileClient2 {
	public static void main(String[] args) {
		new TcpFileClient().clientStart();
	}
	
	public void clientStart() {
		// 전송할 파일 정보를 갖는 File객체 생성
//		File file = new File("d:/d_other/코알라.jpg");
		File file = showDialog("OPEN");
		
		if(file==null) {
			System.out.println("전송할 파일을 선택하지 않았습니다...");
			return;
		}
		
		String fileName = file.getName();	// 파일 이름 구하기
		
		if(!file.exists()) {	// 전송할 파일이 있는지 확인
			System.out.println(fileName + " 파일이 존재하지 않습니다...");
			return;
		}
		
		Socket socket = null;
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		
		try {
			socket = new Socket("localhost", 7777);
			
			System.out.println("파일 전송 시작...");
			
			// 서버와 접속이 완료되면 처음에 파일이름을 전송한다.
			DataOutputStream dout =
					new DataOutputStream(socket.getOutputStream());
			dout.writeUTF(fileName);
			
			// 파일 내용을 읽어서 서버로 전송하기
			bin = new BufferedInputStream(new FileInputStream(file));
			bout = new BufferedOutputStream(dout);
			
			byte[] temp = new byte[1024];
			int len = 0;
			while((len = bin.read(temp)) > 0) {
				bout.write(temp, 0, len);
			}
			bout.flush();
			
			System.out.println("파일 전송 작업 완료...");
			
		} catch (Exception e) {
			 System.out.println("파일 전송 작업 실패!!!");
			 e.printStackTrace();
		} finally {
			if(bin!=null) try { bin.close(); } catch (IOException e) {	}
			if(bout!=null) try { bout.close(); } catch (IOException e) {	}
			if(socket!=null) try { socket.close(); } catch (IOException e) {	}
		}
	}
	
	public File showDialog(String option) {
		// SWING의 파일 열기 창, 저장 창 연습
		JFileChooser chooser = new JFileChooser();
		
		// 선택할 파일 확장자 설정
		FileNameExtensionFilter txt =
				new FileNameExtensionFilter("텍스트문서(*.txt)", "txt");
		
		FileNameExtensionFilter img =
				new FileNameExtensionFilter("이미지 파일",
						new String[] {"txt", "png", "gif"});
		
		FileNameExtensionFilter doc =
				new FileNameExtensionFilter("MS Word 파일", "doc", "docx");
		
		// '모든 파일' 목록 표시 여부 설정하기 (true : 나타남, false : 나타나지 않음)
		chooser.setAcceptAllFileFilterUsed(true);
		
		chooser.addChoosableFileFilter(doc);
		chooser.addChoosableFileFilter(img);
		chooser.addChoosableFileFilter(txt);
		
		// 확장자 목록 중 기본값으로 선택될 확장자 설정하기
		chooser.setFileFilter(txt);
		
		// Dialog 창이 나타낼 기본 경로 설정하기
		chooser.setCurrentDirectory(new File("D:/D_Other"));
		
		// 창 보여주기
		int result;
		if("OPEN".equals(option.toUpperCase())) {
			result = chooser.showOpenDialog(new Panel());	// 열기용			
		} else if("SVAE".equals(option.toUpperCase())) {
			result = chooser.showSaveDialog(new Panel());	// 저장용			
		} else {
			System.out.println("option 매개변수에는 'OPEN' 또는 'SAVE'만 사용하세요.");
			return null;
		}
		
		File selectedFile = null;
		// 보여진 창에서 파일을 선택한 후 '열기' 또는 '저장' 버튼을 눌렀을 경우 처리하기
		if(result == JFileChooser.APPROVE_OPTION) {
			selectedFile = chooser.getSelectedFile();
		}
		return selectedFile;
	}
}


/*
public class TcpFileClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		System.out.println("서버에 접속합니다...");
		System.out.println();
		
		Socket socket = new Socket("localhost", 7777);
		
		System.out.println("서버에 연결되었습니다...");
		System.out.println();
		
		File sourceFile = new File("D:/D_Other/코알라.jpg");
		FileInputStream fin = new FileInputStream(sourceFile);
		
		OutputStream out = socket.getOutputStream();
		
		int data;
		
		while((data = fin.read()) != -1) {
			out.write(data);
		}
		System.out.println();
		System.out.println("연결을 종료합니다...");

		out.close();
		fin.close();
		socket.close();
	}
}
*/