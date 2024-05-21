package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// 문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는
//		Student 클래스를 만든다.
//		Student 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만
//		매개변수로 받아서 초기화 처리를 한다. (이때 총점의 세 과목의 점수를 이용해서 초기화 한다.)
//		
//		이 Student 객체는 List에 저장하여 관리한다.

//		List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고,
//		총점의 역순(내림차순)으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬되는
//		외부 정렬 기준 클래스를 작성하여 정려된 결과를 출력하시오.
//		(외부 정렬 기준 클래스명 : SortByTotal)

//		등수는 List에 전체 데이터가 추가된 후에 구한다.

public class StudentTest {
	
	// 등수를 구하는 메서드
	public void createRanking(ArrayList<Student> students) {
		for(Student student1 : students) { //기준 데이터를 구하기 위한 반복문
			int rank=1;		// 처음에는 등수를 1로 초기화 해 놓고 시작
			
			for(Student student2 : students) {	//비교 대상을 나타내는 반복문
				
				//기준보타 큰 값을 만나면 rank값을 증가시킨다.
				if(student1.getTotal()<student2.getTotal()) {
					rank++;
				}
				
			}
			student1.setRank(rank);
		}
	}
	public static void main(String[] args) {
		StudentTest test = new StudentTest();
		ArrayList<Student> students = new ArrayList<Student>();
		
		students.add(new Student(20200341, "홍길동", 97,58,78));
		students.add(new Student(20200627, "이순신", 74,94,86));
		students.add(new Student(20201284, "성춘향", 55,85,67));
		students.add(new Student(20202648, "강감찬", 93,89,91));
		students.add(new Student(20201018, "일지매", 88,69,84));
		students.add(new Student(20205281, "변학도", 92,83,89));
		
		// 등수 구하는 메서드 호출
		test.createRanking(students);
		System.out.println("정렬 전...");
		for(Student student : students) {
			System.out.println(student);
		}
		System.out.println("----------------------------------");
		Collections.sort(students);
		
		System.out.println("정렬 후...");
		for(Student student : students) {
			System.out.println(student);
		}
		
		System.out.println("----------------------------------");
		Collections.sort(students, new SortByTotal());
		
		System.out.println("정렬 후...");
		for(Student student : students) {
			System.out.println(student);
		}
		
	}

}

class Student  implements Comparable<Student>{
	private int num;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private int rank;
	
	public Student(int num, String name, int kor, int eng, int math) {
		super();
		this.num=num;
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
		total=kor+eng+math;
		
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
	
	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math
				+ ", total=" + total + ", rank=" + rank + "]";
	}

	@Override
	public int compareTo(Student student) {
		return Integer.compare(this.getNum(), student.getNum());
	}

}

// 총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬
class SortByTotal implements Comparator<Student> {
	public int compare(Student student1, Student student2) {
		if(student1.getTotal()==student2.getTotal()) {
			return student1.getName().compareTo(student2.getName());
		}else {
			return Integer.compare(student1.getTotal(), student2.getTotal()) * -1;
		}
		
	}
	
}
