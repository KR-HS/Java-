package kr.human.vo;

import lombok.Data;

@Data
public class PersonVO {
	private String name;
	private int age;
	private String[] hobby;
	private boolean gender;
	private String ip;
}
