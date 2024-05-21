package kr.or.ddit.basic;

public class ArgsTest {
	//매개변수로 정수들을 받아서 이들의 합계를 구하는 메서드를 작성하시오.
			// (단, 이 정수들의 개수는 상황에 따라 달라질 수 있다.)
	
	// 배열을 이용한 방법
	public int sumArr(int[] data) {
		int sum =0;
				
		for(int i=0; i<data.length; i++) {
			sum+=data[i];
		}
		return sum;
	}
	//가변인수를 이용한 방법
	//가변인수 ==> 메서드를 호출할 때 인수의 개수가 다를 경우에 사용하는 방법
	//	가변인수는 메서드 안에서는 배열로 처리된다.
	//	가변인수는 메서드에서 한 개만 사용할 수 있다.
	public int sumArg(int... data) {
		int sum =0;
				
		for(int i=0; i<data.length; i++) {
			sum+=data[i];
		}
		return sum;
	}
	// 가변인수와 일반적인 매개변수를 같이 사용할 경우에는
	// 가변인수를 제일 뒤쪽에 배치해야 한다.
	public String sumArg2(String name, int... data) {
		int sum =0;
				
		for(int i=0; i<data.length; i++) {
			sum+=data[i];
		}
		return name +"씨의 총합 : "+sum;
	}
	
	public static void main(String[] args) {
		ArgsTest test = new ArgsTest();
		
		int[] numArr = {100,200,300,400};
		//int[] testArr = new int[] {100,200,300,400};
		
//		int[] a;
//		a= {1,2,3,4};
//		
//		int[] b;
//		b= new int[] {1,2,3,4,5};
		
		System.out.println(test.sumArr(numArr));
		System.out.println(test.sumArr(new int[] {1,2,3,4,5}));
		System.out.println();
		
		System.out.println(test.sumArg(100,200,300,400));
		System.out.println(test.sumArg(1,2,3,4,5));
		
		System.out.println(test.sumArg2("홍길동",40,50,60));
		
		int k =100;
		
	}

}
