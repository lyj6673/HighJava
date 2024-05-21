package kr.or.ddit.basic;

import java.util.Properties;

public class PropertiesTest {
	/*
	 - Properties객체 ==> Map보다 축소된 기능의 객체라고 할 수 있다.
	 
	 Map은 key값과 value값에 모든 종류의 객체를 사용할 수 있지만
	 Properties는 key값과 value값에 'String'만 사용할 수 있다.
	 
	 Map은 get()메서드와 put()메서드를 이용하여 입출력 하지만
	 Properties는 getProperty()메서드와 setProperty()메서드를 이용하여 입출력한다.
	 
	 Properties는 데이터를 파일로 입출력 할 수 있다.
	 
	 */
	public static void main(String[] args) {
		Properties prop = new Properties();
		
		prop.setProperty("name", "홍길동");
		prop.setProperty("age", "20");
//		prop.setProperty("age", 20+"");
//		prop.setProperty("age", String.valueOf(20));
		
		prop.setProperty("tel", "010-8229-7228");
		prop.setProperty("addr", "대전");
		
		System.out.println("prop => "+prop);
		
		String name = prop.getProperty("name");
		int age = Integer.parseInt(prop.getProperty("age"));
		String tel = prop.getProperty("tel");
		String addr = prop.getProperty("addr");
		
		System.out.println("이름 : "+name);
		System.out.println("나이 : "+age);
		System.out.println("전화번호 : "+tel);
		System.out.println("주소 : "+addr);
		
	}

}
