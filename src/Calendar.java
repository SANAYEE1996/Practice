public class Calendar {
	private int year;
	private int month;
	private int day;

	private int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private boolean isLeafYear(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}

	public Calendar() {
		super();
	}

	public Calendar(int year) {
		this(year, 0, 0);
	}

	public Calendar(int year, int month) {
		this(year, month, 0);
	}

	public Calendar(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public void print() {
		if (year != 0 && month == 0 && day == 0) {
			print(year);
		} 
		else if (year != 0 && month != 0 && day == 0) {
			print(year, month);
		} 
		else if (year != 0 && month != 0 && day != 0) {
			print(year, month, day);
		}
	}
	
	public int sumday(int year,int month) {
		int sum = (year - 1) * 365 + year / 4 - year / 100 + year / 400;
		if (isLeafYear(year)) {
			monthArray[1] = 29;
			for (int i = 0; i < month - 1; i++) {
				sum += monthArray[i];
			}
		} 
		else {
			for (int i = 0; i < month - 1; i++) {
				sum += monthArray[i];
			}
		}
		return sum;
	}

	public void print(int year, int month, int day) {
		
		int sum = sumday(year,month);
		
		if (isLeafYear(year)) {
			sum += day - 1;
		} 
		else {
			sum += day;
		}

		switch (sum % 7) {
		case 0:
			System.out.println(year + "년 " + month + "월 " + day + "일은 : 일요일");
			break;
		case 1:
			System.out.println(year + "년 " + month + "월 " + day + "일은 : 월요일");
			break;
		case 2:
			System.out.println(year + "년 " + month + "월 " + day + "일은 : 화요일");
			break;
		case 3:
			System.out.println(year + "년 " + month + "월 " + day + "일은 : 수요일");
			break;
		case 4:
			System.out.println(year + "년 " + month + "월 " + day + "일은 : 목요일");
			break;
		case 5:
			System.out.println(year + "년 " + month + "월 " + day + "일은 : 금요일");
			break;
		case 6:
			System.out.println(year + "년 " + month + "월 " + day + "일은 : 토요일");
			break;
		}

	}

	public void print(int year, int month) {
		
		System.out.println();
		System.out.println(year + " 년 " + month + "달력입니다");
		System.out.println("일\t월\t화\t수\t목\t금\t토");

		int c = sumday(year,month) % 7;

		for (int j = 0; j < c; j++) {
			System.out.print("\t");
		}
		for (int i = 1; i <= monthArray[month - 1]; i++) {
			System.out.print(i + "\t");
			if ((i + c) % 7 == 0)
				System.out.println();
		}

		System.out.println();
	}

	public void print(int year) {
		for (int i = 1; i <= 12; i++) {
			print(year, i);
		}
	}

}