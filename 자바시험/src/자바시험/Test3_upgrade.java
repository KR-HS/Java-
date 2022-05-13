package 자바시험;


//2월씩 6개줄 출력
import java.util.Scanner;

public class Test3_1 {
	public static void main(String[] args) {
		CalendarIn7 cal7 = new CalendarIn7();
		Scanner scanner = new Scanner(System.in);
		System.out.println("연도입력 : ");
		int year = scanner.nextInt();

		for (int i = 1; i < 7; i++) {

			System.out
					.println("\t\t" + year + "년\t" + (2 * i - 1) + "월\t\t\t\t\t\t\t\t" + year + "년\t" + 2 * i + "월\t");
			cal7.printCalendar(year, i);
			System.out.println(
					"\n--------------------------------------------------------------------------------------------------------------------------");
		}
	}
}

class CalendarIn7 {
	private int month[] = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };// 평년
	private int lmonth[] = new int[] { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };// 윤년

	// 윤년판단
	public boolean leapYearTF(int year) {
		boolean yearTF = false;
		if ((0 == (year % 4) && 0 != (year % 100)) || 0 == year % 400)
			yearTF = true;
		return yearTF;
	}

	// 윤년세기
	public int howManyLeapYear(int year) {
		int count = 0;
		for (int i = 1; i <= year; i++) {
			if (leapYearTF(i)) {
				count++;
			}
		}
		return count;

	}

	// 입력받은 년도부터 입력받은 년도의 년도 월일까지의 일수.
	public int howManyDaysInYearsMonth(int year, int month, int day) {
		int count = day;
		if (leapYearTF(year)) {
			for (int i = 0; i < month - 1; i++) {
				count += this.lmonth[i];
			}
		} else {
			for (int i = 0; i < month - 1; i++) {
				count += this.month[i];
			}
		}
		return count;
	}

	public int startDayInCal(int year, int month) {
		int count = 0;
		count+=((year-1)*365+(year-1)/4-(year-1)/100+(year-1)/400);
		count+=howManyDaysInYearsMonth(year, month, 1);
		return count % 7;

	}

	// 해당 월의 마지막 날인지 판단.
	public boolean isLastDay(int year, int month, int day) {
		boolean isL = false;

		if (!leapYearTF(year)) {
			if (day == this.month[month - 1])
				isL = true;
		}

		else {
			if (day == this.lmonth[month - 1])
				isL = true;
		}

		return isL;
	}

	// 년월의 마지막날을 구해주는 함수.
	public int getDates(int year, int month) {
		if (leapYearTF(year))
			return this.lmonth[month - 1];

		else
			return this.month[month - 1];
	}

	// 달력을 출력해주는 함수
	public void printCalendar(int year, int month) {
		int linecheck = 0; //토요일인지 판별
		int linecheck1 = 0; // 토요일인지 판별
		int l = 1;
		String temp = "";
		String temp1 = "";
		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat\t\tSun\tMon\tTue\tWed\tThu\tFri\tSat");

		//시작요일 판별
		linecheck = startDayInCal(year, 2 * month - 1);
		linecheck1 = startDayInCal(year, month * 2);
		
		for (int j = 0; j < linecheck; j++) {
			temp += "\t";
		}
		for (int j = 0; j < linecheck1; j++) {
			temp1 += "\t";
		}
		
		// 각월의 일수 구하기
		int count = getDates(year, 2 * month - 1);
		int count1 = getDates(year, 2 * month);
		
		//달력 출력
		System.out.print(temp);
		for (int i = 1; i <= count; i++) {
			
			System.out.print(i + "\t");
			linecheck++;
			if (i == count) {
				int m = 7 - linecheck;
				linecheck = 7;
				for (int num = 0; num < m; num++)
					System.out.print("\t");
			}
			if (linecheck == 7) {
				System.out.print("\t");
				linecheck = 0;
				
				if (l == 1)
					System.out.print(temp1);
				for (int k = 1; k <= 7; k++, l++) {
					if (l <= count1) {
						System.out.print(l + "\t");
						linecheck1++;
						if (linecheck1 == 7) {
							if (isLastDay(year, 2 * month, l)) {
								k=7;
								System.out.println();
								linecheck1 = 0;
								continue;
							}
							
							k = 7;
							System.out.println();
							linecheck1 = 0;
						}

					}
					else {
						System.out.println();
						break;
					}
				}
			}

		}
		if(l<count1) {
			System.out.printf("\t\t\t\t\t\t\t\t");
			for (int k = 1; k <= 7; k++, l++) {
				if (l <= count1) {
					System.out.print(l + "\t");
					linecheck1++;
					if (linecheck1 == 7) {
						if (this.isLastDay(year, 2 * month, l)) {
							return;

						}
						k = 7;
						System.out.println();
						linecheck1 = 0;
					}

				}

			}
		
		}
	}

}
