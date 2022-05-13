package kr.human.lambda;

public class Ex03_Lambda03 {
	// 인수도 없고 리턴값도 없다 ==> Runnable 사용
	public static void main(String[] args) {
		System.out.println("하하하하");
		System.out.println("\n");
		System.out.println("하하하하");
		
		//람다로 표현
		Runnable blankDoubleLine = ()->{
			System.out.println("\n");
		};
		System.out.println("하하하하");
		blankDoubleLine.run();
		System.out.println("하하하하");
		
		Runnable line = ()->System.out.println("-".repeat(50));
		System.out.println("하하하하");
		line.run(); //선그리기
		System.out.println("하하하하");
		line.run(); // 선그리기
	}
}
