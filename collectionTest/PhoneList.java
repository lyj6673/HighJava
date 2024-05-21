package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;

public class PhoneList {
    HashMap<String, Phone> member = new HashMap<String, Phone>();
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        PhoneList phoneList = new PhoneList(); 


        System.out.println("메 뉴");
        System.out.println("1. 전화번호 등록");
        System.out.println("2. 전화번호 수정");
        System.out.println("3. 전화번호 삭제");
        System.out.println("4. 전화번호 검색");
        System.out.println("5. 전화번호 전체출력");
        System.out.println("0. 프로그램 종료");
        System.out.println("--------------------------");
        System.out.println("메뉴 선택 : ");
        int sel = sc.nextInt();
        if (sel < 0 || sel > 5) {
            System.out.println("잘못입력하셨습니다 다시 입력해주세요");
        } else {
            switch (sel) {
                case 1:
                    phoneList.telInsert();
                    break;
                case 2:
                    phoneList.telUpdate();
                    break;
                case 3:
                    phoneList.telDelete();
                    break;
                case 4:
                    phoneList.telSearch();
                    break;
                case 5:
                    phoneList.telList();
                    break;
                case 0:
                    break;
            }
        }
    }

    private void telInsert() {
        System.out.println("이름 >> ");
        String name = sc.nextLine();
        System.out.println("전화번호 >> ");
        System.out.println("주소 >> ");
    }

    private void telUpdate() {
        // 구현
    }

    private void telDelete() {
        // 구현
    }

    private void telSearch() {
        // 구현
    }

    private void telList() {
        // 구현
    }
}

//class Phone {
//    private String name;
//    private String tel;
//    private String addr;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getTel() {
//        return tel;
//    }
//
//    public void setTel(String tel) {
//        this.tel = tel;
//    }
//
//    public String getAddr() {
//        return addr;
//    }
//
//    public void setAddr(String addr) {
//        this.addr = addr;
//    }
//}
