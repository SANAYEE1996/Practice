import java.util.Scanner;

public class Main {
 
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		System.out.println(fibo(a));
		
		
	}
	
	private static int fibo(int n) {
		
		if(n == 1) return 0;
		else if(n == 2) return 1;
		else {
			for(int i = 0; i< n; i++) {
				
			}
			return fibo(n);
		}
	}
 
}