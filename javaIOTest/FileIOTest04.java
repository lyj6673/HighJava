package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOTest04 {
	public static void main(String[] args) {
		
		//Scanner s = new Scanner(System.in);
//		try {
//			System.out.print("입력 >>");
//			int c = System.in.read();
//			
//			System.out.println((char)c);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		// 사용자가 입력한 내용을 그대로 파일로 저장하기
		// System.in ==> 콘솔(표준입출력장치)와 연결된 inputStream객체
		
		// InputStreamReader객체 ==> 바이트 기반의 스트림을 문자 기반의 스트림으로 변환해줌
		try {
			//입력용 스트림 객체 생성
			InputStreamReader isr = new InputStreamReader(System.in);
			
			//출력용 스트림 객체 생성
			FileWriter fw = new FileWriter("d:/d_other/testChar.txt");
			
			System.out.println("아무 내용이나 입력하세요. (입력의 끝은 Ctrl + Z 입니다.");
			
			int c;
			
			while((c=isr.read()) != -1) {
				fw.write(c); // 콘솔로 입력받은 데이터를 파일로 출력하기
				
			}
			
			// 스트림 닫기
			isr.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
