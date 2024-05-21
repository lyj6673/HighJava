package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileIOTest01 {
	public static void main(String[] args) {
		// 파일 내용 읽기 ==> byte기반 스트림 이용
		try {
			// 파일  입력용 스트림 객체 생성 ==> 이 때 읽어올 파일 정보를 넣어준다.
			
			// 방법 1 ==> 읽어올 파일 정보를 file객체로 구성해서 넣어주기
			File file = new File("d:d_Other/test.txt");
			FileInputStream fin = new FileInputStream("d:d_Other/test.txt");
			
			int c; //읽어온 데이터를 저장할 변수
			
			while((c=fin.read())!=1) {
				//읽어온 데이터를 화면에 출력하기
				System.out.println((char)c);
			}
			
			//스트림 닫기
			fin.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
