package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class HotelTest {
	private HashMap<Integer, Room> hotelRoomMap;
	private Scanner scan;
	
	public HotelTest(){
		hotelRoomMap = new HashMap<Integer, Room>();
		scan = new Scanner(System.in);
		
		for (int room = 201; room <= 209; room++) {
            hotelRoomMap.put(room, new Room(room, "싱글룸", "-"));
        }
        for (int room = 301; room <= 309; room++) {
            hotelRoomMap.put(room, new Room(room, "더블룸", "-"));
        }
        for (int room = 401; room <= 409; room++) {
            hotelRoomMap.put(room, new Room(room, "스위트룸", "-"));
        }
	}
	public static void main(String[] args) {
		new HotelTest().hotelStart();
	}
	
	private void hotelStart() {
		System.out.println();
		System.out.println("***********************************");
		System.out.println("    호텔 문을 열었습니다. 어서오십시요.");
		System.out.println("***********************************");
		System.out.println();
		while(true) {
			int choice = displayMenu();
			switch(choice) {
			 case 1:
                 checkIn();		// 체크인
                 break;
             case 2:
            	 checkOut();		// 체크아웃
                 break;
             case 3:
                 roomState();		// 객실상태
                 break;
             case 4:		//프로그램 종료
         		System.out.println();
        		System.out.println("***********************************");
        		System.out.println("    호텔문을 닫았습니다.");
        		System.out.println("***********************************");
                 break;
             default :
            	 System.out.println("작업 번호를 잘못 입력했습니다.");
            	 System.out.println("다시 선택하세요");
			}
		}
	}
	private void checkOut() {
		System.out.println();
		System.out.println("---------------------------");
		System.out.println("  체크아웃 작업");
		System.out.println("---------------------------");
		System.out.println("체크아웃 할 방 번호 입력 >> ");
		int room = scan.nextInt();
        
        String roomType="";
        if(room>=201 && room<=209) {
        	roomType = "싱글룸";
        }
        else if(room>=301 && room<=309) {
        	roomType = "더블룸";
        }
        else if(room>=401 && room<=409) {
        	roomType = "스위트룸";
        }else {
        	System.out.println(room+"호 객실은 존재하지 않습니다.");
        	return;
        }
        
        if(hotelRoomMap.containsKey(room)) {
        	Room r = hotelRoomMap.get(room);
        	if(r.getName()=="-") {
        		System.out.println(room+"호 객실은 체크인 한 사람이 없습니다.");
	        	return;
        	}
        	System.out.println(room+"호 객실의 "+r.getName()+"님 체크아웃을 완료하였습니다.");
            hotelRoomMap.put(room, new Room(room,roomType,"-"));
            
            return;
        }
        
        
	}
	
	private void roomState() {
		System.out.println();
		System.out.println("---------------------------");
		System.out.println("  현재 객실 상태");
		System.out.println("---------------------------");
		System.out.println(" 방 번호   방 종류   투숙객이름");
		System.out.println("---------------------------");
		Set<Integer> keySet = hotelRoomMap.keySet();
			int num=0;
			for(Integer room : keySet) {
				num++;
				Room r = hotelRoomMap.get(room);
				System.out.println(" "+room + "\t"+r.getRoomtype()+"\t"+r.getName());
			}
		
		System.out.println("------------------------------------");
	}
	private void checkIn() {
		System.out.println();
		System.out.println("---------------------------");
		System.out.println("  체크인 작업");
		System.out.println("---------------------------");
		System.out.println("* 201~209 : 싱글룸");
		System.out.println("* 301~309 : 더블룸");
		System.out.println("* 401~409 : 스위트룸");
		System.out.println("---------------------------");
		 System.out.println("방 번호 입력 >> ");
	        int room = scan.nextInt();
	        

	        String roomType="";
	        if(room>=201 && room<=209) {
	        	roomType = "싱글룸";
	        }
	        else if(room>=301 && room<=309) {
	        	roomType = "더블룸";
	        }
	        else if(room>=401 && room<=409) {
	        	roomType = "스위트룸";
	        }else {
	        	System.out.println(room+"호 객실은 존재하지 않습니다.");
	        	return;
	        }
	        
	        if(hotelRoomMap.containsKey(room)) {
	        	Room r = hotelRoomMap.get(room);
	        	if(r.getName()!="-") {
	        		System.out.println(room+"호 객실은 이미 손님이 있습니다.");
		        	return;
	        	}
	        }
	        System.out.print("누구를 체크인 하시겠습니까?");
	        System.out.print("이름 입력 >> ");
	        String name = scan.next();
	        

	        hotelRoomMap.put(room, new Room(room,roomType,name));
	        
	        System.out.println("체크인이 완료되었습니다.");
	        return;
	}
	
	private int displayMenu() {
		System.out.println("메 뉴");
        System.out.println("1. 체크인  2. 체크아웃  3. 객실상태  4. 업무종료");
        System.out.println("--------------------------");
        System.out.println("선택 >> ");
        return scan.nextInt();
	}

}

class Room {
	int room;
	String roomType;
	String name;
	
	public Room(int room, String roomType, String name) {
		super();
		this.room = room;
		this.roomType = roomType;
		this.name = name;
	}
	
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public String getRoomtype() {
		return roomType;
	}
	public void setRoomtype(String roomtype) {
		this.roomType = roomtype;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
