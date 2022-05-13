package 자바시험;

import java.util.Scanner;

public class Test2 {
	public static void main(String args[]) {
		int year,month;
		Scanner sc=new Scanner(System.in);
		

			System.out.print("년월을 입력하시오 (0은 종료 )");
			year=sc.nextInt();
			month=sc.nextInt();
			sc.close();
			
			//달력 출력 
			System.out.format("%16d년 %02d월\n\n",year,month);
			System.out.println("-".repeat(38));
			System.out.println("   일   월   화   수   목   금   토");
			System.out.println("-".repeat(38));
			
			int w=getWeek(getTotalDay(year,month,1));
			//1일의 위치를 맞추기 위해 공백 출력
			for(int i=0;i<w;i++) System.out.print("     ");
			// 1일부터 마지막 날까지 출력(토요일이면, 줄을 바꾸기)
			for(int i=1;i<=getLastDay(year,month);i++) {
				System.out.printf("%5d",i);
				if(getWeek(getTotalDay(year,month,i))==6)System.out.println();
			}
		
		
		}

	//요일( 0은 일요일, 6은 토요일)
	private static int getWeek(int total) {
		return total%7;
	}
	
	//총일수
	private static int getTotalDay(int year, int month, int day) {
		int total;
		//총일수 구하기
		//1. 전년도까지의 일수
		total=(year-1)*365+(year-1)/4-(year-1)/100+(year-1)/400;
		//2. 전월까지의 일수
		for(int i=1;i<month;i++) total+=getLastDay(year,i);
		//3. 일수
		total+=day;
		return total;
	}
	//주어진 년월의 마지막 날
	private static int getLastDay(int year,int month) {
		int m[]= {31,28,31,30,31,30,31,31,30,31,30,31};
		m[1]= year%400==0||year%4==0&&year%100!=0?29:28;
		return m[month-1];
	}
}
