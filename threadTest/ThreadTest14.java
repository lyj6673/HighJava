package kr.or.ddit.basic;

//쓰레드에서 객체를 공통으로 사용하는 예제

/*
 	원주율을 계산하는 쓰레드와
 	계산이 완료되면 계산된 원주율을 출력하는 쓰레드가 있다.
 	
 	원주율을 저장하는 객체가 필요하다
 	이 객체를 두 쓰레드에서 공통으로 사용해서 처리한다.
 */
public class ThreadTest14 {
	public static void main(String[] args) {
		// 공통으로 사용할 객체를 생성한다.
		ShareData shareData = new ShareData();
		
		// 쓰레드 객체를 생성하고 공통으로 사용할 객체를 각각의 쓰레드에 주입한다.
		CalcPIThread ct = new CalcPIThread(shareData);
		
		PrintPIThread pt = new PrintPIThread();
		pt.setData(shareData);
		
		//쓰레드 실행
		ct.start();
		pt.start();
	}
}

// 원주율을 계산하는 쓰레드
class CalcPIThread extends Thread{
	private ShareData data;
	
	//생성자
	public CalcPIThread(ShareData data) {
		this.data=data;
	}

	@Override
	public void run() {
		/*
		 원주율 = (1/1 - 1/3 + 1/5 - 1/7 + 1/9 .... ) * 4
		 		   1 - 3 + 5 - 7 + 9 ...
		 		   
		 		   0   1   2   3   4
		 */
		double sum = 0.0;
		for(int i=1; i<1_000_000_000; i+=2) {
			if((i/2) % 2 == 0) {	//2로 나눈 몫이 짝수일 때
				sum += 1.0 / i;
			}else {
				sum -= 1.0 / i;
			}
		}
		//계산된 원주율을 관리하는 객체에 저장한다.
		data.result= sum*4;
		data.isOk = true;
	}
	
	
}
//계산된 원주율을 출력하는 쓰레드
class PrintPIThread extends Thread{
	private ShareData data;
	
	//setter
	public void setData(ShareData data) {
		this.data = data;
	}

	@Override
	public void run() {
		while(true) {
			if(data.isOk==true) {
				break;
			}else {
				Thread.yield();
			}
		}
		
		System.out.println();
		System.out.println("결과 : "+data.result);
		System.out.println("PI : " + Math.PI);
	}
	
	
	
}

// 원주율을 관리하는 클래스(공통으로 사용할 클래스)
class ShareData{
	public double result;	//계산된 원주율이 저장될 변수
	
	public boolean isOk = false; // 계산이 완료되었는지 여부를 나타내는 변수
}