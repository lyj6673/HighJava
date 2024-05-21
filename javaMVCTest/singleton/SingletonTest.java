package kr.or.ddit.singleton;

public class SingletonTest {
	public static void main(String[] args) {
		//MySingleton test1 = new MySingleton(); //외부에서 new 명령으로 생성불가
		
		MySingleton test2 = MySingleton.getInstence();
		MySingleton test3 = MySingleton.getInstence();
		
		System.out.println(test2);
		System.out.println(test3);
		System.out.println();
		System.out.println(test2 == test3);
		System.out.println(test2.equals(test3));
		
	}

}
