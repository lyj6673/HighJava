package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 문제)
 	'd:/d_other'폴더에 있는 '코알라.jpg' 파일을
 	'd:/d_other/연습용'폴더에  '복사본_코알라.jpg' 파일로 복사하는 프로그램을 작성하시오.
 */
public class FileCopyTest {
	public static void main(String[] args) {
		File sourceFile = new File("d:/d_other/코알라.jpg");
		
		if(!sourceFile.exists()) {
			System.out.println(sourceFile.getPath() + "파일이 없습니다.");
			System.out.println("복사 작업을 마칩니다");
			return;
		}
		
		try {
			//복사할 원본 파일을 읽어올 스트림 객체 생성
			FileInputStream fin = new FileInputStream(sourceFile);
			
			// 대상 파일로 저장할 스트림 객체 생성
			FileOutputStream fout =
					new FileOutputStream("d:/d_other/연습용/복사본_코알라.jpg");
			
			System.out.println("복사 작업 시작");
			
			int data;	//읽어온 데이터를 저장할 변수
			
			while((data = fin.read()) != -1) {
				fout.write(data);
			}
			
			//스트림 닫기
			fout.close();
			fin.close();
			System.out.println("복사작업 끝");
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
