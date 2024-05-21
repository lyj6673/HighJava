package kr.or.ddit.basic;

// 제너릭을 사용하지 않는 경우
class NonGeneric{
	public Object value;

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
/*
 - 제네릭 클래스를 만드는 방법
 형식)
 class 클래스명<제네릭타입글자>{
 	private 제네릭타입글자 변수명;		// 변수를 선언 할 때 제네릭을 사용할 경우
 	...
 	public 제네릭타입글자 메서드명(){
 		...
 		return 값;
 	}
 	
 	// 메서드의 매개변수의 타입으로 사용할 경우
 	public 반환값타입 메서드명(제네릭타입글자 변수명, ...){ 
 		...
 		}
 	}
 	
 	- '제네릭 타입 글자'로 많이 사용되는 글자
 		T ==> Type
 		k ==> key
 		V ==> Value
 		E ==> Element
 		
 */

// 제네릭을 사용하는 클래스 만들기
class MyGeneric<T>{
	private T value;	//변수에 사용
	
	public void setValue(T value) {	// 매개변수에 사용
		this.value = value;
	}
	public T getValue() {	//반환값에 사용
		return value;
	}
}

public class GenericTest {
	public static void main(String[] args) {
		NonGeneric non1 = new NonGeneric();
		non1.setValue("안녕하세요");
		
		NonGeneric non2 = new NonGeneric();
		non2.setValue(200);
		
		String sTemp = (String)non1.getValue();
		System.out.println("문자열 반환값 : "+sTemp);
		
		int itemp = (int)non2.getValue();
		System.out.println("정수형 반환값 : "+itemp);
		
		int iTemp2 = (int)non1.getValue();
		System.out.println("iTemp2 = "+iTemp2);
		
		System.out.println("-----------------------------");
		
		MyGeneric<String> my1 = new MyGeneric<>();
		my1.setValue("반갑습니다.");
		
		MyGeneric<Integer> my2 = new MyGeneric<>();
		my2.setValue(900);
		//my2.setValue("abc");	// 다른 종류의 데이터를 저장할 수 없다.
			
		String strTemp = my1.getValue(); //데이터를 꺼내올 때 형변환 없이 꺼내올 수 있다.
		int intTemp = my2.getValue();
		
		System.out.println("제네릭 문자열 반환값 : "+strTemp);
		System.out.println("제네릭 문자열 반환값 : "+intTemp);
	}

}
