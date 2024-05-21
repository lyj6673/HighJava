package kr.or.ddit.basic;

public class ThreadTest18 {
	public static void main(String[] args) {
		WorkObject workObj = new WorkObject();
		
		WorkThread01 th1 = new WorkThread01(workObj);
		WorkThread02 th2 = new WorkThread02(workObj);
		
		th1.start();
		th2.start();
	}
}

//WorkObject의 method01()메서드만 호출하는 쓰레드
class WorkThread01 extends Thread{
	private WorkObject workObj;

	public WorkThread01(WorkObject workObj) {
		this.workObj = workObj;
	}

	@Override
	public void run() {
		for(int i=1;i<=10; i++) {
			workObj.method01();
		}
		synchronized (workObj) {
			workObj.notify();
		}
	}
}
//WorkObject의 method02()메서드만 호출하는 쓰레드
class WorkThread02 extends Thread{
	private WorkObject workObj;

	public WorkThread02(WorkObject workObj) {
		this.workObj = workObj;
	}

	@Override
	public void run() {
		for(int i=1;i<=10; i++) {
			workObj.method02();
		}
		synchronized (workObj) {
			workObj.notify();
		}
	}
}
// 공통으로 사용할 객체
class WorkObject{
	public synchronized void method01() {
		System.out.println("method01()메서드 실행 중...");
		
		notify();
		
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	
	public synchronized void method02() {
		System.out.println("method02()메서드 실행 중...");
		
		notify();
		
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
}
