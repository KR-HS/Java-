package kr.human.java0429;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetEx01 {
	public static void main(String[] args) {
		// Set : 입력순서가 중요하지 않을때 사용한다. 중복을 자동으로 제거해 준다
		Set<Integer> set = new HashSet<>();
		System.out.println(set.size() + "개 : " + set);

		for(int i=1;i<5;i++) set.add(i); // 4개 추가
		System.out.println(set.size() + "개 : " + set);
		
		for(int i=1;i<5;i++) set.add(i); // 4개 추가
		System.out.println(set.size() + "개 : " + set); // 중복을 허용하지 않는다.
		
		for(int i=5;i<11;i++) set.add(i); // 6개 추가
		System.out.println(set.size() + "개 : " + set);
		
		for(int i : set) System.out.println(i);
		
		System.out.println();
		
		Iterator<Integer> it = set.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}
}
