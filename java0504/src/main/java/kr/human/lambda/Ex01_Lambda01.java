package kr.human.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex01_Lambda01 {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("사과","바나나","오렌지","포도","키위","파인애플");
		
		System.out.println(names);
		//정렬해서 출력
		Collections.sort(names);
		System.out.println(names);
		
		// 역순으로 정렬해서 출력 >> 기존의 방식
		Collections.sort(names,new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		System.out.println(names);
		
		// 2초 후에 HelloWorld를 출력하는 스레드
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(2000); // 일정시간 대기한다. 1/1000초 단위
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Hello World!");
			}
		}).start();
		
		
		// 위의 Comparator 인터페이스는 익명 개체 -> 람다식으로 변경 가능 (1회용)
		// 람다식 : 이름이 없는 메서드(1회용)
		Collections.sort(names,(o1,o2) -> o1.compareTo(o2));
		System.out.println(names);
		
		// Runnable 인터페이스를 람디식으로 표현
		new Thread(
			()->{
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("나는 언제실행?");
				
				
		}).start();
		
		// 사용자가 만든 인터페이스의 사용
		 System.out.println(new MyFunction() {
			 @Override
			 public int max(int a, int b) {
				 return a>b? a:b;
			 }
		 }.max(10,23));
		 
		 MyFunction mf=(a,b)->a>b?a:b;
		 System.out.println(mf.max(22,12));
		
	}
	
	public interface MyFunction {

		int max(int a, int b);

	}

}
