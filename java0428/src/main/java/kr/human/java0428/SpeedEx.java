package kr.human.java0428;

public class SpeedEx {
	public static void main(String[] args) {
		String str="";
		StringBuffer sBuffer=new StringBuffer();
		StringBuilder sBuilder=new StringBuilder();
		
		
		// String 객체는 불변 객체 => 변할수 없음. =>연산을 하면 항상 새로운 객체를 만들어서 리턴.
		long start = System.currentTimeMillis();
		for(int i=0;i<10000;i++) {
			str+="꽝";
		}
		System.out.println("실행시간 : "+ (System.currentTimeMillis()-start)+"ms");
		
		
		// StringBuffer나 StringBuilder는 가변객체로 여난을 하면 자기 자신이 변경
		// StringBuffer는 멀티스레드 프로그램에 안전하게 설계되어있고
		// StringBuilder는 싱글 스레드 프로그램에만 안전하게 설계되어 나중에 발표.
		start = System.currentTimeMillis();
		for(int i=0;i<10000;i++) {
			sBuffer.append("꽝");
		}
		System.out.println("실행시간 : "+ (System.currentTimeMillis()-start)+"ms");
		
		start = System.currentTimeMillis();
		for(int i=0;i<10000;i++) {
			sBuilder.append("꽝");
		}
		System.out.println("실행시간 : "+ (System.currentTimeMillis()-start)+"ms");
	}
}
