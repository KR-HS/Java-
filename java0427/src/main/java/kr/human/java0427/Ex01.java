package kr.human.java0427;

class Parent {
	public Parent() {
		System.out.println("Parent 생성자 호출");
	}
}

class Child extends Parent {
	public Child() {
		super(); // 이 자리에 이 코드가 자동으로 삽입
		System.out.println("Child 생성자 호출");
	}
}

class GrandChild extends Child {
	public GrandChild() {
		super(); // 이 자리에 이 코드가 자동으로 삽입
		System.out.println("GrandChild 생성자 호출");
	}
}

class Some {
	int value;

	public Some(int value) {
		this.value = value;
	}
}

class SomeChild extends Some{
	public SomeChild(){
		//부모 생성자형태와 동일해야함 
		//default 는 super()이기 떄문에 부모클래스의 생성자가 인자를 받는 생성자일경우 사용자가 입력해야함.
		super(0); 
		
		
	}
}

class Name{
	String name;
	
	public Name(String name) {
		this.name=name;
	}
	
	@Override
	public String toString() {
		return name.toUpperCase(); // 대문자로 변환.
	}
}

class NameChild extends Name{
	int age;
	public NameChild(String name,int age) {
		super(name);
		this.age=age;
	}
	@Override
	public String toString() {
		return super.toString()+"("+age+"세)";
	}
}


public class Ex01 {
	public static void main(String[] args) {
		// 상속받은 클래스의 객체를 만들면 부모 클래스의 생성자부터 차례대로 호출.
		GrandChild grandChild = new GrandChild();

		NameChild nameChild = new NameChild("aaa",20);
		System.out.println(nameChild);
	}
}
