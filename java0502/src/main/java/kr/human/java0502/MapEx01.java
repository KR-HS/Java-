package kr.human.java0502;

import java.util.Hashtable;

// Map : (키,값) 쌍으로 저장하는 자료구조
public class MapEx01 {
	public static void main(String[] args) {
		Hashtable<Integer, String> hashtable = new Hashtable<>();
		hashtable.put(1, "한사람");
		hashtable.put(2, "두사람");
		hashtable.put(3, "세사람");
		hashtable.put(1, "네사람"); // 넣기 : key는 set이다.
		System.out.println(hashtable.size() + "개 : " + hashtable);
		System.out.println(hashtable.get(2)); // 1개 얻기
		System.out.println(hashtable.contains(1)); // 있느냐?
		System.out.println(hashtable.contains(4));
		System.out.println("-".repeat(60));
		
		for(int key : hashtable.keySet()) {
			System.out.println(key + " : " + hashtable.get(key));
		}
		System.out.println("-".repeat(60));
		
		for(String value : hashtable.values()) {
			System.out.println(value);
		}
		System.out.println("-".repeat(60));
		
	}
}
