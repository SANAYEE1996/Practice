import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		String[] str = new String[a];
		for(int i = 0; i < str.length; i++) {
			str[i] = sc.next();
		}
		Arrays.sort(str);
		for(int i = 0; i < str.length;i++) {
			System.out.println(str[i]);
		}
	}
	
}
