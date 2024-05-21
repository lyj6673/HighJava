package kr.or.ddit.basic;

//데몬 쓰레드 예제 ==> 자동 저장 기능 구현

public class ThreadTest08 {
	public static void main(String[] args) {
		AutoSaveThread autoSave = new AutoSaveThread();
		
		// 데몬 쓰레드로 설정하기 => 반드시 start() 전에 설정
		autoSave.setDaemon(true);
		System.out.println("데몬쓰레드 여부 : "+autoSave.isDaemon());
		autoSave.start();
		
		try {
			for(int i=1;i<=20;i++) {
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("main 쓰레드 종료..");
	}
}

// 자동 저장하는 쓰레드(3초에 한 번씩 자동으로 저장하는 쓰레드)
class AutoSaveThread extends Thread{
	//작업 내용을 저장하는 메서드
	public void save() {
		System.out.println("작업 내용을 저장합니다");
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		save();
	}
	
	
}