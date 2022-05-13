package kr.human.java0429;

import java.util.*;

public class ListEx02 {
	public static void main(String[] args) {
		// 대용량일 경우 초기값으로 용량을 지정하면 조금이라도 속도의 향상을 가져온다.
		Vector<Integer> v = new Vector<>(20,5); // 초기 용량값, 용량 증가값
		
		Random rnd=new Random();
		for(int i=0;i<v.capacity();i++) v.add(rnd.nextInt(101));
		
		System.out.println("용량 : "+v.capacity()+", 개수 :"+v.size());
		
		System.out.println(v);
		
		//데이터 중 50이상인 값을 제거하겠다.
		/*
		 // 앞에서 부터 지우면 인덱스값이 변경되어 당겨지므로 삭제되지 않는 값이 생긴다.
		 for(int i=0;i<v.size();i++){
		 	if(v.get(i)>=50) v.remove(i);
		 }
		 System.out.println("용량 : "+v.capacity()+", 개수 : "+v.size());
		 System.out.println(v);
		 */
		// 조건에 맞춰 지울때는 항상 뒤에서부터 작업
		for(int i=v.size()-1;i>=0;i--) {
			if(v.get(i)>=50) v.remove(i);
		}
     	 System.out.println("용량 : "+v.capacity()+", 개수 : "+v.size());
		 System.out.println(v);

	}
}
