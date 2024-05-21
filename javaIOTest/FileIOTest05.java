package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 	사용자로부터 출력할 단을 입력 받아 구구단을 출력하는 프로그램을 작성하시오.
 	단, 구구단의 출력은 'd:/d_other/'폴더에 'gugudan.txt'파일로 저장되도록 한다.
 	(출력할 단은 Scanner로 입력 받는다.)
 */
public class FileIOTest05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("구구단의 단을 입력하세요");
		
		FileOutputStream fout = null;
		int c = sc.nextInt();
		try {
			// 바이트 기반의 파일 출력용 스트림 객체 생성
			fout = new FileOutputStream("d:/d_other/gugudan_byte.txt");
			
			fout.write((c+"단\n\n").getBytes("utf-8"));
			for(int i=1; i<=9;i++) {
				String result = c + "*"+i+"="+(c*i) + "\n";
				fout.write((result).getBytes("utf-8"));
			}
			System.out.println("출력 끝");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//스트림 닫기
			if(fout!=null) try {fout.close();}catch(IOException e) {}
		}
	}
}
