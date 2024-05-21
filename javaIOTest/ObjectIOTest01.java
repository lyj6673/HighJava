package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectIOTest01 {
	public static void main(String[] args) {
		//Member의 인스턴스 생성
		Member mem1 = new Member("홍길동", 20, "대전");
		Member mem2 = new Member("홍길서", 30, "부산");
		Member mem3 = new Member("홍길남", 40, "광주");
		Member mem4 = new Member("홍길북", 50, "인천");
		
		//객체를 파일로 저장하기
		try {
			//출력용 스트림 객체 생성
			FileOutputStream fout = new FileOutputStream("d:/d_other/memObj.dat");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			ObjectOutputStream oout = new ObjectOutputStream(bout);
			
			//쓰기 작업
			System.out.println("객체 저장 작업 시작...");
			oout.writeObject(mem1);
			oout.writeObject(mem2);
			oout.writeObject(mem3);
			oout.writeObject(mem4);
			
			//객체를 저장할 때 마지막에 null값을 추가하여 EOFException을 방지할 수 있다.
			oout.writeObject(null);
			
			System.out.println("객체 저장 작업 완료 ...");
			oout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
