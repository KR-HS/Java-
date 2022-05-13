package kr.human.java0427;


class FinalMember{
	final double PI;  // final은 상수(변경금지)ㅜ
	
	// 초기값이 없는 상수 멤버를 가지는 클래스는 반드시 상수를 초기화할 수 있는 생성자.
	public FinalMember(double pi) {
		PI=pi;
	}
}

public class FinalInitEx {
	public static void main(String[] args) {
		FinalMember fm1=new FinalMember(3.14);
		System.out.println(fm1.PI);
		
		
		FinalMember fm2=new FinalMember(3.1415);
		System.out.println(fm2.PI);
		
		FinalMember fm3=new FinalMember(3.141592);
		System.out.println(fm3.PI);
	}
}
