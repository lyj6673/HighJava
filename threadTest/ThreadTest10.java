package kr.or.ddit.basic;

// yield() 메서드 연습용 예제
public class ThreadTest10 {
	public static void main(String[] args) {
		YieldTest th1 = new YieldTest("1번쓰레드");
		YieldTest th2 = new YieldTest("2번쓰레드");
		th1.start();
		th2.start();
		
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("--------------------------------1111111");
		th1.work = false;
		
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("--------------------------------2222222");
		th1.work = true;
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("--------------------------------33333333");
		th1.stop = true;
		th2.stop = true;
	}
}

// yield()메서드 연습용 쓰레드
class YieldTest extends Thread{
	public boolean stop = false;
	public boolean work = true;
	
	//생성자
	public YieldTest(String name) {
		super(name);
	}

	@Override
	public void run() {
		while(!stop) {
			if(work) {
				System.out.println(getName()+" 작업 중...");
			}else {
				System.out.println(getName()+" 양보...");
				Thread.yield();
			}
		}
	}
	
	
}