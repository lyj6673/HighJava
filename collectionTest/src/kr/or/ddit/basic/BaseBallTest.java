package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

// - 숫자 야구 게임 프로그램 만들기
// 컴퓨터의 숫자는 난수를 이용하여 구한다. (1~9 사이의 중복되지 않는 난수 3개)
// (스트라이크는 S, 볼은 B로 나타낸다.)

//	컴퓨터 난수 ==> 9 5 7

//	실행예시)
//	숫자 입력 >> 3 5 6
//	3 5 6 ==> 1S 0B
//	숫자 입력 >> 7 8 9
//	7 8 9 ==> 0S 2B
//	숫자 입력 >> 9 7 5
//	9 7 5 ==> 1S 2B
//	숫자 입력 >> 9 5 7
//	9 5 7 ==> 3S

//	축하합니다.
//	당신은 4번째 만에 맞췄습니다.


public class BaseBallTest {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        HashSet<Integer> ranSet = new HashSet<>();
	        int strike, ball, count;

	        // 컴퓨터가 생성한 난수 생성
	        while (ranSet.size() < 3) {
	            ranSet.add((int) (Math.random() * 9-1+1) + 1);
	        }
	        ArrayList<Integer> ranList = new ArrayList(ranSet);

	        count = 0;
	        do {
	        	strike = 0;
	            ball = 0;
	            
	            System.out.print("숫자 입력 >> ");
	            String num = sc.nextLine();
	            String[] myNum = num.split(" ");

	            for (int i = 0; i < 3; i++) {
	                int temp = Integer.parseInt(myNum[i]);
	                if (temp == ranList.get(i)) {
	                    strike++;
	                } else if (ranList.contains(temp)) {
	                    ball++;
	                }
	            }

	            System.out.println(num + " ==> " + strike + "S " + ball + "B");
	            count++;
	        } while (strike != 3);

	        System.out.println("축하합니다.");
	        System.out.println("당신은 " + count + "번째 만에 맞췄습니다.");
	}

}
