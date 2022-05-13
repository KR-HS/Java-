package kr.human.java0427;

public class Ex04 {
	static class Parent{
		int x=100;
		
		void method() {
			System.out.println("부모의 메서드");
		}

	}
	static class Child extends Parent{
		int x=123;
		void method() {
			System.out.println("자식의 메서드");
		}
	}
	
	public static void main(String[] args) {
		Parent parent=new Parent();
		Child child=new Child();
		
		System.out.println(parent.x);
		parent.method();
		
		System.out.println(child.x);
		child.method();
		
		Parent parent2 = new Child();
		System.out.println(parent2.x);
		parent2.method();
	}
}
