package kr.human.java0429;

import java.util.*;


// Stack : 입력과 출력이 한곳에 있는 자료 구조. First in Last Out  : FILO
public class StackEx {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack.size() + "개 : "+stack);
		int i= stack.peek();
		System.out.println(i);
		System.out.println(stack.peek()); // 맨위의 값이 뭔지 알아본다. 제거되지 않음.
		
		i=stack.pop(); // 맨위의 데이터를 가져온다. 스택에서 제거
		System.out.println(i);
		System.out.println(stack.pop());
		
		//끝까지 모두 가져오기
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		//비어 있을때 꺼내면 에러
		//System.out.println(stack.pop());
	}
}
