package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LottoStore {
//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("==========================");
//		System.out.println("Lotto 프로그램");
//		System.out.println("--------------------------");
//		System.out.println("1. Lotto 구입");
//		System.out.println(" 2. 프로그램 종료");
//		System.out.println("==========================");
//		System.out.println("메뉴 선택 : ");
//		int sel = sc.nextInt();
//		while(true) {
//			HashSet<Integer> ranSet = new HashSet<>();
//			ArrayList<HashSet<Integer>> lotto = new ArrayList();
//			if(sel==1) {
//				System.out.println("로또 구입 시작");
//				System.out.println("(1000원에 로또번호 하나입니다.)");
//				System.out.println("금액 입력 : ");
//				int money = sc.nextInt();
//				if(money>100000) {
//					System.out.println("최대 100장까지만 구매하실 수 있습니다");
//					continue;
//				}
//				
//				int num = money/1000;
//				int change = money%1000;
//				
//				 System.out.println("행운의 로또번호는 아래와 같습니다.");
//				for(int i=0; i<num; i++) {
//					 while (ranSet.size() < 6) {
//				            ranSet.add((int) (Math.random() * 45-1+1) + 1);
//				        }
//					 lotto.add(ranSet);
//					 System.out.println("로또번호"+(i+1)+" : "+lotto.get(i));
//					 ranSet.clear();
//				}
//	
//			    System.out.println("받은 금액은 "+money+"원이고 거스름돈은 "+change+"원 입니다.");
//			    break;
//				
//			}else break;
//		}
//		System.out.println("감사합니다");
//	}
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		new LottoStore().lottoStart();
	}
	
	//시작 메서드
	public void lottoStart() {
		while(true) {
			int choice = displayMenu();
			
			switch(choice) {
			case 1:
				buyLotto();
				break;
			case 2 :
				System.out.println("감사합니다.");
				break;
			default :
				System.out.println("작업 번호를 잘못 입력하셨습니다. ('1'또는 '2'를 입력하세요)");
			}
		}
		
	}
	
	//금액에 맞는 개수 만큼의 로또번호를 만들어서 출력하는 메서드
	private void createLotto(int money) {
		Set<Integer> lottoSet = new HashSet<Integer>();
		
		int count = money/1000;
		
		for(int i=1; i<=count; i++) {
			while(lottoSet.size()<6) {
				lottoSet.add((int)(Math.random() * 45-1+1) + 1);
			}
			ArrayList<Integer> lottoList = new ArrayList<Integer>(lottoSet);
			Collections.sort(lottoList);
			
			System.out.println("로또번호 "+i+" : "+ lottoList);
			lottoList.clear();
		}
	}
	
	private int buyLotto() {
		
		System.out.println("로또 구입 시작");
		System.out.println("(1000원에 로또번호 하나입니다.)");
		System.out.println("금액 입력 : ");
		int money = sc.nextInt();
		if(money<1000) {
			System.out.println("입력 금액이 너무 적습니다.");
			return;
		}
		if(money>101000) {
			System.out.println("입력 금액이 너무 많습니다.");
			return;
		
			//로또번호를 생성하는 메서드 호출
		createLotto(money);
		
		//거스름돈 계산 및 출력
		System.out.println("받은 금액은 "+money+"원이고 거스름돈은 "+(money%1000)+"원 입니다.");
		
	}
	
	//메뉴를 출력하고 작업 번호를 입력 받아 반환하는 메서드
	private int displayMenu() {
		System.out.println("==========================");
		System.out.println("Lotto 프로그램");
		System.out.println("--------------------------");
		System.out.println("1. Lotto 구입");
		System.out.println(" 2. 프로그램 종료");
		System.out.println("==========================");
		System.out.println("메뉴 선택 : ");
		return sc.nextInt();
	}

}
