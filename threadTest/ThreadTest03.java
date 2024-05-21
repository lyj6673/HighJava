package kr.or.ddit.basic;

public class ThreadTest03 {
	public static void main(String[] args) {
		// 쓰레드가 수행되는 시간 체크해보기
		Thread th = new Thread(new MyRunner02());
		
		//1970년 1월 1일 0시 0분 0초(표준시간)로 부터 경과한 시간을
		// 밀리세컨드(1/1000초) 단위로 반환한다.
		long startTime = System.currentTimeMillis();
		
		// 처리할 내용 ...
		th.start();
		try {
			th.join(); //현재의 위치에서 해당 쓰레드(현재는 변수 th에 저장된 쓰레드)가
					   // 종료될 때까지 기다린다.
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("경과 시간 : "+(endTime-startTime));
	}
}

class MyRunner02 implements Runnable{

	@Override
	public void run() {
		// 1부터 10억까지의 합계 구하기

		long sum = 0L;
		
		for(long i=1L; i<=1_000_000_000L; i++) {
			sum+= i;
		}
		System.out.println("합계 : "+sum);
	}
	
}
