package kr.human.java0427;

import lombok.Getter;

@Getter
public class Human {
	private String name;
	
	public Human() {
		name="";
	}
	Human(String name){
		this.name=name;
	}
	
	public void think() {
		System.out.println(".......");
	}
}
