package kr.or.ddit.basic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest02 {
	public static void main(String[] args) {
		try {
			File file = new File("d:/d_other/out.txt");
			FileOutputStream fout = new FileOutputStream(file);
			
			for(char c='A'; c<='Z'; c++) {
				fout.write(c);	//c 변수의 데이터를 파일로 출력한다.
			}
			
			System.out.println("작업 완료...");
			
			fout.close();//스트림 닫기
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
