package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/*
 문제) 
 	컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 	
 	컴퓨터의 가위 바위 보는 난수를 이용해서 구하고,
 	사용자의 입력은 showInputDialog()메서드를 이용하여 입력 받는다.
 	
 	입력 시간은 5초로 제한하고 카운트 다운을 진행한다.
 	5초안에 입력이 없으면 게임에 진 것으로 처리한다.
 	
 	5초 안에 입력이 있으면 승패를 구해서 결과를 출력한다.
 	
 	결과 예시)
 	1) 5초 안에 입력을 못했을 경우
 		-- 결 과 --
 		시간 초과로 당신이 졌습니다...
 	2) 5초 안에 입력을 했을 경우
 		-- 결 과 --
 		컴퓨터 : 가위
 		사용자 : 바위
 		결 과 : 당신이 이겼습니다.
 */
public class ThreadTest07 {
	public static void main(String[] args) {
		Thread th = new DataInput2();
		Thread th2 = new MyCountDown2();
		th.start();
		th2.start();
		
	}
	
}

class DataInput2 extends Thread{
	public static boolean inputCheck = false;

	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("가위바위보(5초 제한)");
		
		inputCheck = true; // 입력이 완료되면 inputCheck를 true로 변경
		if (str == null) {
            System.out.println("-- 결 과 --");
            System.out.println("잘못된 입력입니다. 다시 실행해주세요.");
            System.exit(0);
        }

        String[] options = {"가위", "바위", "보"};
        int random = (int) (Math.random() * 3);
        String com = options[random];

        System.out.println("-- 결 과 --");
        System.out.println("컴퓨터: " + com);
        System.out.println("사용자: " + str);

        // 가위바위보 승부 결정
        if (com.equals(str)) {
            System.out.println("결 과: 비겼습니다.");
        } else if ((com.equals("가위") && str.equals("보"))
                || (com.equals("바위") && str.equals("가위"))
                || (com.equals("보") && str.equals("바위"))) {
            System.out.println("결 과: 컴퓨터가 이겼습니다.");
        } else {
            System.out.println("결 과: 당신이 이겼습니다.");
        }

        System.exit(0);
	}
	
	
	
}

//카운트 다운을 진행하는 쓰레드
class MyCountDown2 extends Thread{
	@Override
	public void run() {
		for(int i=5; i>=1; i--) {
			System.out.println(i);
			
			// 입력이 완료되었는지 여부를 검사해서 입력이 완료되면 쓰레드를 종료시킨다.
			if(DataInput2.inputCheck==true) {
				return;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		System.out.println("-- 결 과 --.");
		System.out.println("시간 초과로 당신이 졌습니다...");
		System.exit(0);
	}
}