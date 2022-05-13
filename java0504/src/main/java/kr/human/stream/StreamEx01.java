package kr.human.stream;

import java.util.Random;

public class StreamEx01 {
	public static void main(String[] args) {
		
		//중간연산 : 연산결과가 반드시 다시 스트림, 반복적 적용 가능
		// 최종연산 : 연산 결과가 스트림이 아닌연산 ,1회성
		new Random().ints() // 스트림을 만든다.
		.distinct() // 스트림을 만들고 중복제거.
//		.filter(n->n>=1&&n<=45) // 걸러서
		.limit(6) //6개만
		.sorted() // 정렬
//		.forEach((n)->System.out.println(n)); //출력
		.forEach(System.out::println); // 출력 : 정적메서드 지정 (:: 연산자 사용);
		for(int i=0;i<10;i++) {
			new Random().ints(1,46).distinct().limit(6).forEach(n->System.out.println(n+" "));
			System.out.println();			
		}
	}
}
