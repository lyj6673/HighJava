package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class URLTest02 {
	public static void main(String[] args) throws IOException {
		// URLConnection ==> 애플리케이션과 URL간의 통신 연결을 위한 클래스
		
		// 특정 서버의 정보와 파일 내용을 가져와 출력하는 예제
		URL url = new URL("https://www.naver.com/index.html");
		
		//URLConnection객체 구하기
		URLConnection conn = url.openConnection();
		
		// Header 정보 가져오기
		Map<String, List<String>> headerMap = conn.getHeaderFields();
		
		//headerMap의 key값과 value값 출력
		for(String key : headerMap.keySet()) {
			System.out.println(key + " : "+headerMap.get(key));
		}
		System.out.println("----------------------------------------");
		
		//해당 문서의 내용을 가져와 출력하기 (index.html 문서의 내용 가져오기)
		
		
		
		// 방법1) URLConnection객체를 이용하는 방법
		// 파일을 읽어오기 위한 스트림 객체 생성
//		InputStream is = conn.getInputStream();
//		InputStreamReader isr = new InputStreamReader(is,"utf-8");
//		BufferedReader br = new BufferedReader(isr);
//		
//		//자료의 내용을 읽어와 출력하기
//		String str = null;	//읽어온 자료가 저장될 변수
//		while((str = br.readLine())!=null) {
//			System.out.println(str);
//		}
//		br.close(); //스트림 닫기
		// 방법2) URL객체의 openStream()메서드를 이용하는 방법
		InputStream is2 = url.openStream();
		BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));
		
		//자료의 내용을 읽어와 출력하기
		String str2 = null;	//읽어온 자료가 저장될 변수
		while((str2 = br2.readLine())!=null) {
			System.out.println(str2);
		}
		br2.close(); //스트림 닫기
	}
}
