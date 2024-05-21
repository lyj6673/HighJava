package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest02 {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		byte[] temp = new byte[4]; //4개짜리 배열 생성
		
		//스트림 객체 생성
		ByteArrayInputStream in = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		try {
//			// 읽어올 데이터가 있는지 확인
//			while(in.available()>0) {
////				in.read(temp);
////				out.write(temp);
//				
//				int len = in.read(temp); // 실제 읽어온 byte 수를 반환한다.
//				//temp배열의 내용 중 0번째부터 len갯수만큼 출력한다.
//				out.write(temp,0,len);
//				System.out.println("반복문에서 temp : "+Arrays.toString(temp));
//			}
			int len;
			while((len=in.read(temp))>0) {
				out.write(temp,0,len);
				
				outSrc = out.toByteArray();
			}
			
			outSrc = out.toByteArray();
			
			try {
				in.close();
				out.close();
			} catch (IOException e) {
			e.printStackTrace();
			}
			
			System.out.println("inSrc : "+ Arrays.toString(inSrc));
			System.out.println("outSrc : "+ Arrays.toString(outSrc));
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
