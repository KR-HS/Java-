package kr.human.java0427;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student extends Human{
	private String stuNo;
	
	public Student(String stuNo,String name) {
		super(name);
		this.stuNo=stuNo;
	}
	
	// 오바리이딩 : 기능 변경
	public void think() {
		System.out.println(".........");
		
	}
	
	//기능 추가
	public void study() {
		System.out.println("하늘천 땅지");
	}
}
