package kr.or.ddit.basic;
/*
   3개의 쓰레드가 각각 알파벳을 A~Z까지 출력하는데
   출력을 끝낸 
 */
public class ThreadTest11 {
	public static void main(String[] args) {
		DisplayCharacter[] disArr = new DisplayCharacter[] {
				new DisplayCharacter("홍길동"),
				new DisplayCharacter("이순신"),
				new DisplayCharacter("강감찬")
		};
		
		for(DisplayCharacter dis : disArr) {
			dis.start();
		}
		
		for(DisplayCharacter dis : disArr) {
			try {
				dis.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		System.out.println();
		System.out.println(" 경기 결과");
		System.out.println(" 순위 : "+DisplayCharacter.strRank);
	}
}

class DisplayCharacter extends Thread{
	public static String strRank=" "; //작업을 끝낸 순서대로 이름이 저장될 변수
	private String name;
	
	public DisplayCharacter(String name) {
		this.name=name;
	}

	@Override
	public void run() {
		for(char c='A';c<='Z';c++) {
			System.out.println(name+"의 출력문자 : "+c);
			try {
				Thread.sleep((int)(Math.random()*500));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		System.out.println(name+"의 출력 작업 끝");
		
		//출력이 끝난 쓰레드의 이름을 strRank변수에 추가한다.
		strRank += name + " ";
	}
	
}
