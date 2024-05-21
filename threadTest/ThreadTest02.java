package kr.or.ddit.basic;

public class ThreadTest02 {
	public static void main(String[] args) {
		//멀티 쓰레드 프로그램
		
		//Thread 클래스를 사용하는 방법
		
		// 방법1)
		// 1) Thread클래스 를 상속한 class를 작성한다.
		// 2) 이 class의 인스턴스를 생성한다.
		// 3) 생성된 인스턴스의 start()메서드를 호출해서 실행한다.
		
		// 방법 1-2)
		MyThread01 th1 = new MyThread01();
		
		// 방법 1-3)
		th1.start();
		
		//-----------------------------------------
		// 방법 2
		// 1) Runnable인터페이스를 구현한 class를 작성한다.
		// 2) 이 class의 인스턴스를 생성한다.
		// 3) Thread클래스의 인스턴스를 생성한다.
		//		(이 때 2번에서 생성한 인스턴스를 Thread클래스 생성자의 인수값으로 넣어서 생성한다.
		// 4) 생성된 Thread클래스의 인스턴스의 start()메서드를 호출해서 실행한다.
		
		// 방법 2-2
		MyRunner01 r = new MyRunner01();
		
		// 방법 2-3
		Thread th2 = new Thread(r);
		
		// 방법 2-4
		th2.start();
		
		// ---------------------------------------------------
		// 방법 3 ==> 방법2의 다른 방법
		// 익명 구현체를 이용하는 방법
		
		Runnable r2 = new Runnable() {

			@Override
			public void run() {
				for(int i=1; i<=10; i++) {
					System.out.print("@");
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO: handle exception
					}
				}
				
			}
			
		};
		Thread th3 =  new Thread(r2);
		th3.start();
		
	}
}

// 방법 1-1 ==> Thread클래스를 상속한 class를 작성한다.
class MyThread01 extends Thread{

	@Override
	public void run() {
		// 이 run()메서드 안에 이 쓰레드가 처리할 내용을 작성한다.
		for(int i=1; i<=10; i++) {
			System.out.print("*");
			
			try {
				// Thread.sleep(시간) 메서드 ==> 주어진 시간동안 작업을 멈춘다.
				// 시간은 밀리세컨드 단위를 사용한다. 즉, 1000은 1초를 의미한다.
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
	
}

class MyRunner01 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1; i<=10; i++) {
			System.out.print("$");
		}
		
		try {
			// Thread.sleep(시간) 메서드 ==> 주어진 시간동안 작업을 멈춘다.
			// 시간은 밀리세컨드 단위를 사용한다. 즉, 1000은 1초를 의미한다.
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
	}
	
}