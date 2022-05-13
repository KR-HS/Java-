package kr.human.java0428;

import java.util.StringTokenizer;

public class StringTokenizerEx {
	public static void main(String[] args) {
		String str="한놈,두식이,석삼,너구리,오징어";
		StringTokenizer st=new StringTokenizer(str);
		System.out.println(st.countTokens()+"개");
		
		StringTokenizer st2=new StringTokenizer(str,",");
		System.out.println(st2.countTokens()+"개");
		
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
		
		
		str="한놈,두식이,석삼,,,너구리,,오징어";
		// 연속된 구분자 무시
		System.out.println(new StringTokenizer(str,",").countTokens()+"개");
		System.out.println(str.split(",").length+"개");
		
		str="사과=100,배=900,딸기=1000,감=300";
		
		StringTokenizer st3= new StringTokenizer(str,"=,",true);
		while(st3.hasMoreTokens()) {
			String temp=st3.nextToken();
			if(temp.equals(","))System.out.println("원)");
			else if(temp.equals("="))System.out.print("(");
			else System.out.print(temp);
		}
		System.out.println("원)");
	}
	
}
