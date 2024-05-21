package kr.or.ddit.basic;

import java.util.Arrays;

/*
  10마리의 말들이 경주하는 경마 프로그램을 작성하시오.
  
  말은 Horse라는 이름의 쓰레드 클래스로 작성하는데
  이 클래스는 말이름(String), 등수(int), 현재위치(int)를 멤버변수로 갖는다.
  그리고 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬 기준이 있다. 
  	(Comparable 인터페이스 구현)
  	
  경기 구간은 1~50구간으로 되어 있다.
  
  경기가 끝나면 등수 순으로 정렬하여 출력한다.
  
  경기 중 중간 중간에 각 말들의 현재 위치를 출력하시오.(별도의 쓰레드로 작성한다.)
  예시)
  01번 말 이름 : ----->--------------------------------
  02번 말 이름 : -------->-----------------------------
  ...
  10번 말 이름 : --->----------------------------------
 */
public class ThreadTest12 {
	public static void main(String[] args) {
		
		Horse[] HorseArr = new Horse[] {
				new Horse("01번 뽀삐"),
				new Horse("02번 뚜비"),
				new Horse("03번 나나"),
				new Horse("04번 뽀"),
				new Horse("05번 텔레"),
				new Horse("06번 토비"),
				new Horse("07번 코난"),
				new Horse("08번 하이바라"),
				new Horse("09번 뭉치"),
				new Horse("10번 진구")
		};
		
		GameState gs = new GameState(HorseArr);
		
		for(Horse h : HorseArr) {
			h.start();   //말들의 경주 시작
		}
		gs.start();		//말들의 현재 위치를 출력하는 쓰레드 시작
		
		for(Horse h : HorseArr) {
			try {
				h.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		try {
			gs.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
        System.out.println();
        System.out.println("경기 끝");
        System.out.println();
        
        //등수의 오름차순으로 정렬하기
        Arrays.sort(HorseArr);
        
        System.out.println("경기 결과");
        System.out.println("순위 : ");
        for (Horse h : HorseArr) {
            System.out.println(h);
        }
	}
}
class HorseRace extends Thread{
	private Horse horse;
	
	@Override
	public void run() {
		while(horse.getCurrent()<50) {
			
		}
	}
	
}

class Horse extends Thread implements Comparable<Horse>{
	public static int currentRank = 0;	//말의 등수를 구하기 위한 변수
	
	private String name;
	private int rank;
	private int current;
	
	Horse(String name){
		super();
		this.name=name;
	}


	public String getName(String name) {
		return name;
	}


	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}
	

	@Override
	public String toString() {
		return "Horse [경주 마 =" + name + ", 등수 =" + rank + "]";
	}


	//등수를 기준으로 오름차순 정렬
//	@Override
	public int compareTo(Horse horse) {
		return Integer.compare(rank, horse.getRank());
	}
	
	@Override
	public void run() {
			
			for(int i=0;i<50;i++) {
				current = i; //말의 현재 위치 저장
				try {
					Thread.sleep((int)(Math.random()*500));
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
			}
			// 한 마리의 말의 경주가 끝나면 등수를 구해서 저장한다.
			currentRank++;
			this.rank = currentRank;
			
		
	}
	
}

class GameState extends Thread{
	private Horse[] hoArr;

	public GameState(Horse[] hoArr) {
		super();
		this.hoArr = hoArr;
	}

	@Override
	public void run() {
		while(true) {
			
			if(Horse.currentRank==hoArr.length) {
				break;
			}
			for(int i=1; i<=10; i++) {
				System.out.println();
			}
			for(Horse h : hoArr) {
				System.out.print(h.getName()+" : ");
				
				for(int i=0;i<50;i++) {
					if(h.getCurrent()==i) {
						System.out.print(">");
					}else System.out.print("-");
				}
				System.out.println(); //줄바꿈
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
	}
	
	
}
