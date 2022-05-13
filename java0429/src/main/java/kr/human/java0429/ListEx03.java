package kr.human.java0429;

import java.util.*;

public class ListEx03 {
	public static void main(String[] args) {
		List<String> v = new ArrayList<>(); // 싱글스레드에만 안전하다.
		// 멀티스레드에서도 사용하려면?
		Collections.synchronizedList(v); //멀티스레드에서 안전하게 작동 => 동기화
		v.add("한사람");
		v.add("두사람");
		v.add("세사람");
		v.add("네사람");
		v.add("오사람");
		System.out.println(v.size()+" : "+v); // size :개수 
		v.add("세사람");
		v.add("네사람");
		v.add("오사람");
		System.out.println( v.size()+" : "+v);
		v.add("세사람");
		v.add("네사람");
		v.add("오사람");
		System.out.println(v.size()+" : "+v); 

		v.add("나인간");
		v.add("너인간"); //추가
		System.out.println(v.size()+" : "+v);

		
		v.set(0,"고친놈");

		System.out.println(v.size()+" : "+v);
		
		System.out.println(v.get(4));//가져오기

		
		v.remove(3);
		v.remove("세사람");//지우기
		System.out.println(v.size()+" : "+v);
		
		v.add(0,"추가인");
		v.add(5,"추가인2"); // 삽입
		System.out.println(v.size()+" : "+v);
		
		// 반복 1
		for(int i=0;i<v.size();i++) {
			System.out.println(v.get(i));
		}
		System.out.println("-".repeat(50));
		
		// 반복 2
		for(String s : v) {
			System.out.println(s);
		}
		System.out.println("-".repeat(50));
		
		//반복 3
		Iterator<String> it=v.iterator();
		while(it.hasNext()) 
			System.out.println(it.next());
		System.out.println("-".repeat(50));
		
		
		ListIterator<String> it2=v.listIterator();
		System.out.println(it2.next());
		System.out.println(it2.next());
		System.out.println(it2.next());
		System.out.println(it2.previous());
		System.out.println(it2.previous());
		System.out.println(it2.previous());
		System.out.println("-".repeat(50));
		v.clear();
		System.out.println(v.size()+" : "+v);
		
		v.add("줄어들까?");
		System.out.println(v.size()+" : "+v);
		
	}
}
