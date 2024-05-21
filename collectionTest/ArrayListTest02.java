package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 문제) 5명의 사람 이름을 입력 받아 ArrayList에 저장한 후에
 	  저장된 데이터들 중에서 '김'씨 성의 이름을 모두 출력하시오.
 	  (입력은 Scanner객체를 이용한다.)
 	  
 문제) 5명의 별명을 입력 받아 ArrayList에 저장한 후에
 	  이들 중에서 별명의 길이가 제일 긴 별명을 출력하시오.
 	  (단, 각 별명의 길이는 모두 다르게 입력한다)
 	  
 문제) 5명의 별명을 입력 받아 ArrayList에 저장한 후에
         이들 중에서 별명의 길이 가 제일 긴 별명들을 출력하시오.
         (단, 입력하는 별명의 길이는 같을 수 있다.)
 */
public class ArrayListTest02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> list = new ArrayList();
		
		for(int i=0; i<5; i++) {
			list.add(sc.next());
		}
		
		for(String name : list) {
//			if(name.substring(0,1).equals("김")) {
//				System.out.println(name);
//			}
			
//			if(name.charAt(0)=='김') {
//				System.out.println(name);
//			}
			
//			if(name.indexOf("김")==0) {
//				System.out.println(name);
//			}
			
			if(name.startsWith("김")) {
				System.out.println(name);
			}
		}
		
		
		
		
	}

}
