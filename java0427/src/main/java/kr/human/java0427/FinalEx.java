package kr.human.java0427;

class Some2 {
	final public void show() {
		System.out.println("오버라이딩 할 수 없음.");
	}
}

class ChildSome2 extends FinalEx{
	public void show() {
		System.out.println("오버라이딩 할 수 없음");
	}
}


final class FinalClass{
	
}

class ChildFinalClass extends FinalClass{
	
}

public class FinalEx{
	static final int MAX=1024;
	final static int MAX2=1024;
	
	
}
