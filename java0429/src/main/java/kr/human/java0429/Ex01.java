package kr.human.java0429;

import java.util.Arrays;

public class Ex01 {
	public static void main(String[] args) {
		
		Object[] objects = {1,1,2,"문자열",new Date()};
		
		System.out.println(Arrays.toString(objects));
		
		for(int i=0;i<objects.length;i++) {
			System.out.println(objects[i]);
			
			if(i==0) {
				Integer ii=(Integer)objects[i];
			}else if(i==1) {
				Double dd= (Double)objects[i];
			}
		}
		
	}
}
