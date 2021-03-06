package kr.human.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Ex05_Lambda05 {
	public static void main(String args[]) {
		// 매개변수의 타입과 반ㅇ환타입이 일치하는 함수형 인터페이스
		// UnaryOperator<T> : 인수 1개 리턴 1개
		// BinaryOperator<T> : 인수 2개 리턴 2개
		
		UnaryOperator<Integer> doubleValue = (i)->i*2;
		System.out.println(doubleValue.apply(4));
		System.out.println(doubleValue.apply(9));
		
		System.out.println(Math.pow(2,10));
		
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<10;i++) list.add((int)(Math.random()*101));
		System.out.println(list);
		
		
		//최대값, 최소값을 구하자
		int max = list.get(0), min= list.get(0);
		for(int i:list) {
			if(max<i) max=i;
			if(min>i) min=i;
		}
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		
		// 람다식으로 해보자
		BinaryOperator<Integer> maxFn=(n,m)->n<m?m:n;
		BinaryOperator<Integer> minFn=(n,m)->n>m?m:n;
		
		max=list.get(0); min = list.get(0);
		for(int i:list) {
			max= maxFn.apply(max,i); //Math.max(max,i)
			min= minFn.apply(min,i); //Math.min(min,i)
		}
		System.out.println("최대값 : "+max);
		System.out.println("최소값 : "+min);
	}
}
