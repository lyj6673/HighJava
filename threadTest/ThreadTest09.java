package kr.or.ddit.basic;

// 쓰레드의 상태를 출력하는 예제
public class ThreadTest09 {
	public static void main(String[] args) {
		//못썻다... State
	}
}

//쓰레드 상태의 검사 대상이 되는 쓰레드
class TargetThread extends Thread{

	@Override
	public void run() {
		long k=0;
		for(long i=1L; i<=20_000_000_000L; i++) {
			k= k+1;
		}
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		k=0;
		for(long i=1L; i<=20_000_000_000L; i++) {
			k= k+1;
		}
	}
	
}

//검사 대상 쓰레드의 상태 값을 출력하는 쓰레드
class StatePrintThread extends Thread{
	private TargetThread target;
	
	//생성자
	public StatePrintThread(TargetThread target) {
		this.target = target;
	}

	@Override
	public void run() {
		while(true) {
			//쓰레드의 상태 값 구하기 ==> getState()메서드 이용
			//쓰레드의 상태 값은 enum(열거형)으로 선언되어 있다.
			Thread.State state = target.getState();
			System.out.println("TargetThread의 상태값 : "+state);
			
			if(state==Thread.State.NEW) { // 쓰레드의 상태가 NEW 상태이면
				target.start(); // 검사 대상 쓰레드 실행
			}
			if(state == Thread.State.TERMINATED) {
				break; //반복문 탈출
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
	
}
