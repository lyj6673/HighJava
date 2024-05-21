package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


/*
 - 추가 조건
 1) '6. 전화번호 저장' 메뉴를 추가하고 구현한다.
 	 (저장파일명 : 'phoneData.dat'로 한다.)
 2) 이 프로그램이 시작될 때 저장된 파일이 있으면 그 파일을 읽어와 Map에 셋팅한다.
 3) 프로그램을 종료할 때 Map의 데이터가 변경되거나 추가 또는 삭제되면 저장 후 종료되도록 한다.
 */

public class PhoneBookTest {
	private HashMap<String, Phone> phoneBookMap;
	private Scanner scan;
	private String fileName = "d:/d_other/phoneData.dat";
	
	private boolean dataChange; //데이터의 변경 사항이 있으면 true가 저장된다.
	
	//생성자
	public PhoneBookTest() {
		phoneBookMap = load();
		if(phoneBookMap==null) {
			phoneBookMap = new HashMap<String, Phone>();
		}
		scan = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		new PhoneBookTest().phoneBookStart();
		
	}
	//시작메서드
	public void phoneBookStart() {
		System.out.println();
		System.out.println("***********************************");
		System.out.println("    전 화 번 호 관 리 프 로 그 램");
		System.out.println("***********************************");
		System.out.println();
		while(true) {
			int choice = displayMenu();
			switch(choice) {
			 case 1:
                 insert();		// 등록
                 break;
             case 2:
                 update();		// 수정
                 break;
             case 3:
                 delete();		// 삭제
                 break;
             case 4:
                 search();		// 검색
                 break;
             case 5:
            	 displayAll();		// 전체출력
                 break;
             case 6:
            	 save();		// 저장
                 break;
             case 0:
            	 if(dataChange==true){
            		 save();	//프로그램 종료
            	 }
                 break;
             default :
            	 System.out.println("작업 번호를 잘못 입력했습니다.");
            	 System.out.println("다시 선택하세요");
			}
		}
	}
		// 파일에 저장된 전화번호 정보를 읽어와 Map에 저장하여 반환하는 메서드
	private HashMap<String, Phone> load(){
		HashMap<String, Phone> pMap = null;		//반환값이 저장될 변수
		File file = new File(fileName);
		if(!file.exists()) {	//저장된 파일이 없으면
			return null;
		}
		ObjectInputStream oin = null;
		try {
			//객체 입력용 스트림 객체 생성
			oin = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(file)));
			
			// 방법1)로 저장했을 때
			Object obj = null;
			while((obj=oin.readObject()) != null) {
				Phone p = (Phone) obj;	//읽어온 자료를 원래의 자료형으로 형변환
				pMap.put(p.getName(),p); //읽어온 자료를 Map에 추가한다.
			}
			//--------------------------------------------------------
			// 방법2)로 저장했을 때
			//pMap = (HashMap<String, Phone>)oin.readObject();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}finally { 
			if(oin!=null) try {oin.close();} catch (IOException e) {}
		}
				
		return pMap;
	}
		
		
		//전화번호 저장 메서드
		private void save() {
			ObjectOutputStream oout = null;
			try {
				// 객체 출력용 스트림 객체 생성
				oout = new ObjectOutputStream(
						new BufferedOutputStream(
								new FileOutputStream(fileName)));
				
				// Map에 기록된 데이터를 파일로 저장하기
				
				// 방법1) Map에 등록된 Phone객체를 차례로 저장하는 방법
//				for(String name : phoneBookMap.keySet()) {
//					Phone p = phoneBookMap.get(name);	//value값(Phone객체)구하기
//					oout.writeObject(p);
//				}
//				oout.writeObject(null);	//파일의 끝을 의미하는 null값 지정
				//-----------------------------------------------------------
				// 방법2) Map객체 자체를 저장한다.
				oout.writeObject(phoneBookMap);
				//-----------------------------------------------------------
				dataChange = false;
				System.out.println("저장이 완료되었습니다...");
				}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				if(oout!=null)try {
					oout.close();
				} catch (IOException e) {
				}
			}
		}
	
	//전화번호 정보를 검색하는 메서드
		private void search() {
			System.out.println();
			System.out.println("검색할 전화번호 정보를 입력하세요...");
			System.out.println("이름 >>");
			String name = scan.next();
			
			//입력한 이름이 key값으로 없는지 검사
			if(!phoneBookMap.containsKey(name)) {
				System.out.println(name+"씨의 전화번호 정보가 없습니다.");
				System.out.println("삭제 작업을 마칩니다.");
				return;
			}
			Phone p = phoneBookMap.get(name);
			
			System.out.println();
			System.out.println(name+"씨의 전화번호 정보");
			System.out.println("--------------------");
			System.out.println("이름 : "+p.getName());
			System.out.println("전화 : "+p.getTel());
			System.out.println("주소 : "+p.getAddr());
			System.out.println("--------------------");
			System.out.println();
			System.out.println("검색 작업 끝");
			
		}
	//전화번호 정보를 삭제하는 메서드
		private void delete() {
			System.out.println();
			System.out.println("삭제할 전화번호 정보를 입력하세요");
			System.out.println("이름 >>");
			String name = scan.next();
			
			//입력한 이름이 key값으로 없는지 검사
			if(!phoneBookMap.containsKey(name)) {
				System.out.println(name+"씨의 전화번호 정보가 없습니다.");
				System.out.println("삭제 작업을 마칩니다.");
				return;
			}
			phoneBookMap.remove(name);
			
			System.out.println(name+"씨의 전화번호 정보를 삭제했습니다.");
			dataChange = true;
			
		}
	//전화번호 정보를 수정하는 메서드
	private void update() {
		System.out.println();
		System.out.println("수정할 전화번호 정보를 입력하세요");
		System.out.println("이름 >> ");
		String name = scan.next();
		
		//입력한 이름이 key값으로 없는지 검사
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨의 전화번호 정보가 없습니다.");
			System.out.println("수정 작업을 마칩니다.");
			return;
		}
		System.out.println("새로운 전화번호 >>");
		String newTel = scan.next();
		
		System.out.println("새로운 주소 >>");
		String newAddr = scan.next();
		
		/*
		 - Scanner객체에 대하여..
		 1) next(), nextInt(), nextDouble() ...
		 	==> 사이띄기(공백), Tab키, 엔터키를 구분 문자로 분리해서 분리된 자료만 가져간다.
		 	
		 2) nextLine()
		 	==> 한 줄 단위로 입력 한다.
		 		즉, 한 줄 전체(Enter키 포함)를 읽어가서 Enter키를 뺀 나머지 데이터를
		 		반환한다.
		    ==> 그래서 nextLine()를 사용하기 전에 'nextLine()'이 아닌
		    	입력 명령을 사용한 적이 있으면 '입력버퍼'를 비워 줘야 한다.
		 */
		
		//같은 key값에 새로운 전화번호 정보를 저장한다. ==> 수정작업
		phoneBookMap.put(name, new Phone(name,newTel,newAddr));
		
		System.out.println(name+"씨의 전화번호 정보를 수정했습니다.");
		dataChange = true;
	}
	
	//전체 자료를 출력하는 메서드
	private void displayAll() {
		System.out.println();
		
		Set<String>  keySet = phoneBookMap.keySet();
		
		System.out.println("------------------------------------");
		System.out.println(" 번호     이름     전화번호        주소");
		System.out.println("------------------------------------");
		
		if(keySet.size()==0) {
			System.out.println("등록된 전화번호 정보가 없습니다");
		}else {
			int num=0;
			for(String name : keySet) {
				num++;
				Phone p = phoneBookMap.get(name);
				System.out.println(" "+num + "\t"+p.getName() +
						"\t"+p.getTel()+"\t"+p.getAddr());
			}
		}
		
		System.out.println("------------------------------------");
		System.out.println("출력 끝");
	}
	
	//새로운 전화번호 정보를 등록하는 메서드
	private void insert() {
		System.out.println();
		System.out.println("새롭게 등록할 전화번호를 입력하세요.");
		 System.out.println("이름 >> ");
	        String name = scan.next();
	        
	        //이미 등록된 이름인지 검사
	        if(phoneBookMap.containsKey(name)) {
	        	System.out.println(name+"씨는 이미 등록된 사람입니다");
	        	return;
	        }
	        System.out.print("전화번호 >> ");
	        String tel = scan.next();
	        
	        scan.nextLine(); //입력버퍼 비우기
	        System.out.println("주소 >> ");
	        String addr = scan.nextLine();
	        
	        //Phone객체 생성 및 Map에 추가하기
	        //Phone p = new Phone(name, tel, addr);
	        //phoneBookMap.compute(name, p);
	        
	        phoneBookMap.put(name, new Phone(name,tel,addr));
	        
	        System.out.println(name + " 전화번호 정보 등록 완료!!");
	        
	        dataChange = true;
		
	}
	private int displayMenu() {
		System.out.println("메 뉴");
        System.out.println("1. 전화번호 등록");
        System.out.println("2. 전화번호 수정");
        System.out.println("3. 전화번호 삭제");
        System.out.println("4. 전화번호 검색");
        System.out.println("5. 전화번호 전체출력");
        System.out.println("6. 전화번호 저장");
        System.out.println("0. 프로그램 종료");
        System.out.println("--------------------------");
        System.out.println("메뉴 선택 : ");
        return scan.nextInt();
	}

}

class Phone implements Serializable{
    private String name;
    private String tel;
    private String addr;
    
    //생성자
    public Phone(String name,String tel,String addr) {
    	super();
    	this.name = name;
    	this.tel = tel;
    	this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}