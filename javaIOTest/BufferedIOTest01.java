package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedIOTest01 {
	public static void main(String[] args) {
		//입출력의 성능 향상을 위해서 Buffered 스트림을 사용한다.
		try {
			FileOutputStream fout =
					new FileOutputStream("d:/d_other/bufferTest.txt");
			
			// 버퍼의 크기가 5인 버퍼스트림 객체 생성
			// 버퍼의 기본 크기는 8KB(8192bytes)이다.
			BufferedOutputStream bout =
					new BufferedOutputStream(fout, 5);
			
			for(int i='1'; i<'9';i++) {
				bout.write(i);
			}
			
			// 출력 작업이 끝나면 버퍼에 남아 있는 데이터를 모두 강제 출력 시켜야 한다.
			// 이때 flush가 그런 역할을 수행한다.
			//bout.flush();
			
			
			bout.close();	//보조스트림을 닫으면 보조스트림에서 사용한
							//기반이 되는 스트림도 같이 닫힌다.
			System.out.println("출력 작업 끝");
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
