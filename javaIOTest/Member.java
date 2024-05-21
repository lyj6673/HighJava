package kr.or.ddit.basic;

import java.io.Serializable;

public class Member implements Serializable{
	
	//transient ==> 직렬화가 되지 않을 멤버변수에 저장한다.
	
	private String name;
	private transient int age;
	private String addr;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	
}
