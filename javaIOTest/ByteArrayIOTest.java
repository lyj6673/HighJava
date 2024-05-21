package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		//스트림 객체 생성
		ByteArrayInputStream in = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		int data;	//읽어온 자료가 저장될 변수
		
		// read()메서드 이용하여 입력하기
		//		==> 더 이상 읽어올 자료가 없으면 -1을 반환한다.
		while((data = in.read()) != -1) {
			// 읽어온 자료를 처리하는 내용을 이 영역에 기술한다.
			
			// 읽어온 자료를 스트림으로 출력하기
			out.write(data);
		}
		
		//출력된 스트림 값을 배열로 변환해서 저장하기
		outSrc = out.toByteArray();
		
		//입출력 작업이 끝나면 사용했던 자원(스트림객체)을 반납(close)한다.
		try {
			in.close();
			out.close();
		} catch (IOException e) {
		e.printStackTrace();
		}
		
		System.out.println("inSrc : "+ Arrays.toString(inSrc));
		System.out.println("outSrc : "+ Arrays.toString(outSrc));
		
	}
}
