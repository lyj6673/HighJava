package kr.or.ddit.basic;

import java.io.FileReader;
import java.io.IOException;

public class FileIOTest03 {
	public static void main(String[] args) {
		// 문자 기반 스트림을 이용하여 파일 내용 읽기와 출력하기
		try {
			//파일 입력용 문자기반 스트림 객체 생성
			FileReader fr = new FileReader("d:/d_other/test.txt");
			
			int c;
			//자료 읽기
			while( (c = fr.read() ) != -1) {
				System.out.print((char)c);	//화면 출력
			}
			
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
