package kr.or.ddit.basic;

public class ThreadTest19 {
	public static void main(String[] args) {
		DataBox dataBox = new DataBox();
		
		ProducerThread th1 = new ProducerThread(dataBox);
		ConsemerThread th2 = new ConsemerThread(dataBox);
		th1.start();
		th2.start();
	}

}

// 데이터를 공통으로 사용하는 클래스
class DataBox{
	private String value;
	
	//저장된 데이터를 가져가는 메서드
	// ==> value변수의 값이 null이면 value변수에 문자열이 채워질 때까지 기다리고,
	//		value변수에 값이 있으면 해당 문자열을 반환한다.
	//		반환 후에는 value변수 값을 null로 만든다.
	public synchronized String getValue() {
		if(value==null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		// value변수에 데이터가 있을 때의 처리 내용
		String temp = value;
		System.out.println("쓰레드가 읽은 데이터 : "+ temp);
		
		value = null;
		notify();
		return temp;
	}
	
	//데이터를 저장하는 메서드
	// ==> value변수에 값이 있으면 value변수가 null이 될 때까지 기다린다.
	//		value변수 값이 null이 되면 새로운 데이터를 저장한다.
	public synchronized void setValue(String value) {
		if(this.value!=null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		this.value = value;
		System.out.println("Thread에서 새로 저장한 데이터 : "+value);
		
		notify();
	}
}

// 데이터를 넣어주는 쓰레드
class ProducerThread extends Thread{
	private DataBox dataBox;
	
	public ProducerThread(DataBox dataBox) {
		this.dataBox = dataBox;
	}

	@Override
	public void run() {
		String[] nameArr = {"홍길동", "이순신", "강감찬", "이몽룡"};
		for(int i=0; i<nameArr.length; i++) {
			dataBox.setValue(nameArr[i]);
		}
	}
	
}

//데이터를 꺼내서 사용하는 쓰레드
class ConsemerThread extends Thread{
	private DataBox dataBox;

	public ConsemerThread(DataBox dataBox) {
		this.dataBox = dataBox;
	}
	
	@Override
	public void run() {
		for(int i=0; i<4; i++) {
			String data = dataBox.getValue();
		}
	}
	
	
}