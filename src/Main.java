import java.util.Scanner;

public class Main {
 
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
 
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int i = 1;
		while(true) {
			if(i*b + a > c*b)
				break;
			i++;
		}
		System.out.println(i);
	}
 
}