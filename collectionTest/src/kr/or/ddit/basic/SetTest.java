package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class SetTest {
	public static void main(String[] args) {
		// List와 Set의 차이점
		// 1. List
		// - 데이터의 순서(index)가 있다.
		// 중복되는 데이터를 저장할 수 있다.
		
		// 2. Set
		// - 데이터의 순서(index)가 없다.
		// 중복되는 데이터를 저장할 수 없다.
		
		HashSet hs1 = new HashSet();
		
		//Set의 데이터 추가도 add()메서드를 이용한다.
		hs1.add("DD");
		hs1.add("AA");
		hs1.add(2);
		hs1.add("CC");
		hs1.add("BB");
		hs1.add(1);
		hs1.add(3);
		
		System.out.println("Set의 개수 : "+hs1.size());
		System.out.println("Set의 데이터 : "+hs1);
		
		// Set에 중복되는 데이터를 추가하면 false를 반환하고 데이터는 추가되지 않는다.
		boolean isAdd = hs1.add("FF");
		System.out.println("중복되지 않을 때 : "+ isAdd);
		System.out.println("Set의 데이터 : "+ hs1);
		
		isAdd = hs1.add("CC");
		System.out.println("중복될 때 : "+ isAdd);
		System.out.println("Set의 데이터 : "+ hs1);
		System.out.println();
		
		//Set의 데이터를 변경하려면 변경하는 명령이 따로 없기 때문에
		//해당 자료를 삭제한 후에 추가해 주는 방법으로 처리한다.
		
		// 삭제하는 메서드 :
		//	remove(삭제할 자료) ==> 반환값 : 삭제성공(true), 삭제실패(false)
		//	clear() ==> 전체 삭제
		
		
		// 예) "FF" 문자열을 "EE"문자열로 변경하기
		hs1.remove("FF");
		System.out.println("삭제 후 Set 데이터 : "+ hs1 );
		hs1.add("EE");
		System.out.println("Set의 데이터 : "+hs1 );
		System.out.println();
		
//		hs1.clear();
//		System.out.println("clear 후 Set 데이터 : "+ hs1 );
		
		//Set의 데이터는 순서(index)가 없기 때문에 List처럼 index로 데이터를
		//하나씩 불러올 수 없다. 그래서 데이터를 하나씩 차례로 얻기 위해서는
		//Iterator형 객체로 변환해야 한다.
		
		// -Set형의 데이터들을 Iterator형으로 변환하는 메서드 ==> iterator()
		
		//Set데이터를 iterator형
		Iterator it = hs1.iterator();
		
		//Iterator의 hasNext()메서드
		//	==> Iterator의 포인터가 가리키는 곳 다음 번째에 데이터가 있는지 검사
		//		(데이터가 있으면 true, 없으면 false)
		while(it.hasNext()) {
			//Iterator의 next()메서드
			//	==> Iterator의 포인터를 다음 번째 위치로 이동시킨 후 그 자리의 데이터를
			//		읽어서 반환한다.
			
			System.out.println(it.next());
		}
		System.out.println("------------------------------------");
		
		// 우리반 학생들 번호를 이용하여 추첨하는 프로그램을 작성해 보자.
		// 번호는 1번부터 26번까지 있고, 추첨할 인원은 3명이다.
		// 당첨 번호를 출력하시오.
		
		// 최소값부터 최대값 사이의 정수형 난수 만들기
		// (int)(Math.random() * (최대값-최소값+1)+최소값)
		
		// 53~76 사이의 난수 만들기
		//int rnd = (int)(Math.random()*(76-53+1)+53);
		//System.out.println("난수값 : "+rnd);
		
		HashSet<Integer> testSet = new HashSet<Integer>();
		while(testSet.size()<3) {
			testSet.add((int)(Math.random()*(26-1+1)+1));
		}
		System.out.println("당첨 번호 : "+testSet);
		
		// Set형의 자료를 List형으로 변환하기
		ArrayList<Integer> testList = new ArrayList<Integer>(testSet);
		
		System.out.println("List 데이터 출력하기...");
		for(int i=0; i<testList.size(); i++) {
			System.out.println(testList.get(i));
		}
		
		
		
	}
}
