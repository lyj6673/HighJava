package kr.or.ddit.basic;

import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {
		//Collection들은 객체만 저장할 수 있다.
		
		//객체 생성
		Vector v1 =  new Vector();
		
		System.out.println("처음 크기 : "+v1.size());
		
		//데이터 추가하기 1 : add(추가할 데이터)
		//반환값 : 추가성공(true), 추가실패(false)
		
		v1.add("aaaa");
		v1.add(new Integer(111));
		//래퍼 클래스..?
		//기본데이터를 객체로 포장
		//이런 작업을 박싱(boxing)이라고 함
		
		v1.add(123); //오토박싱, 오토언박싱이 지원됨
		v1.add('a');
		v1.add(true);
		
		boolean r = v1.add(3.14);
		
		System.out.println("v1의 크기 : "+v1.size());
		System.out.println("반환값 : "+ r);
		System.out.println("v1 => "+v1.toString());
		System.out.println("v1 => "+v1);
		System.out.println("v1 => "+v1);
		
		//데이터 추가하기2 : addElement(추가할 데이터)
		//   ==> 이전 버전의 프로그램과의 호환성을 위해서 남아 있는 메서드
		v1.addElement("CCC");
		System.out.println("v1 => "+v1);
		
		//데이터 추가하기 3 : add(index, 데이터)
		// ==> 'index' 번쨰에 '데이터'를 끼워 넣는다.
		// ==> 'index'는 0부터 시작.  ==> 반환값은 없다
		v1.add(1,"KKK");
		System.out.println("v1=> "+ v1);
		
		//데이터 꺼내오기 : get(index)
		// ==> 'index'번째의 데이터를 꺼내서 반환한다.
		System.out.println("0번째 데이터 : "+v1.get(0));
		int iTemp = (int)v1.get(2); 
		System.out.println("iTemp : "+iTemp);
		//벡터에 여러 타입의 데이터가 들어갔기 때문에 나올 땐 object로 나옴
		//그래서 형변환 필요
		
		//데이터 수정하기 : set(index, 새로운데이터)
		// ==> 'index'번째의 데이터를 '새로운데이터'로 변경한다.
		// ==> 반환값 : 변경되기 전의 데이터
		String sTemp = (String)v1.set(0, "zzzz");
		System.out.println("v1 => "+v1);
		System.out.println("sTemp ; "+sTemp);
		System.out.println();
		
		//데이터 삭제하기 : remove(index)
		// ==> 'index'번째의 데이터를 삭제한다
		// ==> 반환값 : 삭제된 데이터
		v1.remove(0);
		System.out.println("삭제 후 v1 => "+v1);
		sTemp = (String)v1.remove(0);
		System.out.println("삭제 후 v1 => "+v1);
		System.out.println("삭제된 데이터 : "+sTemp);
		System.out.println();
		
		// 데이터 삭제하기 2 : remove(삭제할데이터)
		// ==> '삭제할데이터'를 찾아서 삭제한다
		// ==> '삭제할데이터'가 여러개면 이 중에 제일 첫번 째 자료가 삭제된다.
		v1.remove("CCC");
		System.out.println("CCC 삭제 후 v1 => "+v1);
		
		//v1.remove(123);
		//v1.remove(new Integer(123)); //방법1 ==> 자바 버전 1.9이후에는 사용 불가
		v1.remove(Integer.valueOf(123)); //방법2
		
		System.out.println("123 삭제 후 v1 => "+v1);
		
		//v1.remove('a');
		v1.remove(Character.valueOf('a'));
		System.out.println("a 삭제 후 v1 => "+v1);
		
		v1.remove(true);
		System.out.println("true 삭제 후 v1 => "+v1);
		
		v1.remove(3.14);
		System.out.println("3.14 삭제 후 v1 => "+v1);
		
		//전체 데이터 삭제하기 : clear();
		v1.clear();
		System.out.println("clear후 v1 => " + v1);
		
		//---------------------------------------------------
		/*
		 제네릭타입(Generic Type) ==> 
		 	 - 클래스 내부에서 사용할 데이터의 타입을 객체를 생성할 때
		 	     외부에서 지정해 주는 기법이다.
		 	 - 객체를 선언할 때 <>괄호 안에 그 클래스 내부에서 사용할 데이터의 타입을 정해주는 것을
		 	      말한다
		 	 - 이렇게 선언하게 되면 지정한 데이터 타입 이외의 다른 종류의 데이터를 저장할 수 없다.
		 	 - 이 때 제네릭으로 선언 될 수 있는 데이터 타입은 클래스형 이어야 한다.
		 	   (int => Integer, char => Character, boolean => Boolean 등..)
		 	 - 제네릭 타입으로 선언하게 되면 데이터를 꺼내올 때 별도의 형변환이 필요 없다.
		 */
		 Vector<Integer> v2 = new Vector<Integer>(); //int형 자료만 저장
		 Vector<String> v3 = new Vector<String>(); //String형 자료만 저장
		 
		 v3.add("안녕하세요...");
		 //v3.add(123);		//오류 : 지정한 제네릭 타입과 다른 종류를 저장할 수 없다.
		 
		 String sTemp2 = v3.get(0); //형변환 없이 사용할 수 있다.
		 
		 Vector<Vector> vv = new Vector<Vector>();
		 Vector<Vector<Vector>> vvv = new Vector<Vector<Vector>>();
		 System.out.println();
		 // ----------------------------------------------------
		  v3.clear();
		  System.out.println("v3의 size : "+v3.size());
		  
		  v3.add("AAAA");
		  v3.add("BBBB");
		  v3.add("CCCC");
		  v3.add("DDDD");
		  v3.add("EEEE");
		  
		  Vector<String> v4 = new Vector<String>();
		  v4.add("BBBB");
		  v4.add("EEEE");
		  
		  //데이터 삭제하기 3 : removeAll(Collection객체)
		  // ==> 데이터들 중에서 'Collection객체'가 가지고 있는 모든 데이터를 삭제한다.
		  // ==> 반환값 : 성공(true), 실패(false)
		  v3.removeAll(v4); //v3의 데이터들 중에서 v4가 가지고 있는 데이터들을 모두 삭제한다.
		  
		  System.out.println("v3 =>"+ v3);
		  System.out.println();
		  
		  v3.clear();
		  
		  v3.add("AAAA");
		  v3.add("BBBB");
		  v3.add("CCCC");
		  v3.add("DDDD");
		  v3.add("EEEE");
		  
		  //벡터의 데이터를 순서대로 모두 가져와 사용하기 ==> 반복문 이용하기 (주로 for문 사용)
		  for(int i=0; i<v3.size(); i++) {
			  System.out.println(i+"번째 자료 : " + v3.get(i));
		  }
		  System.out.println("---------------------------------");
		  
		  //향상된 for문
		  for(String str : v3) {
			  System.out.println(str);
		  }
		 	 
	}
}
