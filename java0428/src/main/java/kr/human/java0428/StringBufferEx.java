package kr.human.java0428;

public class StringBufferEx {
	public static void main(String[] args) {
		StringBuffer sb1=new StringBuffer("한사람");
		StringBuffer sb2=new StringBuffer("한사람");
		
		//스트링 버퍼는 같은지 판단 못함
		System.out.println(sb1==sb2?"같다":"다르다");
		System.out.println(sb1.equals(sb2)?"같다":"다르다");
		
		//스트링으로 변환후 같은지 비교
		System.out.println(sb1.toString().equals(sb2.toString())?"같다":"다르다");
		
		System.out.println("용량 : "+sb1.capacity());
		sb1.append("하하하하하하");
		sb1.append("하하하하하하");
		sb1.append("하하하하하하");
		sb1.append("하하하하하하");
		sb1.append("하하하하하하"); // 값을 추가하면 용량이 자동으로 늘어남
	
		System.out.println("용량 : "+sb1.capacity());
		
		StringBuffer sb3= new StringBuffer();
		StringBuffer sb4=new StringBuffer(10000);
		System.out.println("용량 : " + sb3.capacity());
		System.out.println("용량 : " + sb4.capacity());
		
		int i=100; //기본자료형
		Integer ii=200; // 객체형(참조형 변수)
		
		int j=Integer.valueOf(ii); // 객체형을 기본자료형으로 바꿔줌 -> unboxing
		Integer jj= new Integer(i); // 기본자료형을 객체형으로 바꿔줌 -> boxing
		
		int k=ii; //Auto Unboxing
		Integer kk=i; // Auto Boxing
		
		System.out.println("-".repeat(50));
		
		i=Integer.valueOf("123"); // 리턴값이 Integer형
		ii=Integer.parseInt("123"); // 리턴값이 int형
		
		System.out.println(i);
		System.out.println(ii);
	}
}
