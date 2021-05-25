
import java.util.Scanner;

class Solution {


	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		int a = 0;
		int c = 1;
		
		for (int i = 1; i <= T; i++) {
			a = sc.nextInt();
			while(true) {
				if(Math.sqrt(a*c) - (int)Math.sqrt(a*c) == 0) {
					break;
				}
				c++;
			}
			System.out.println("#"+i+" "+c);
			a = 0;
			c = 1;
		}

		sc.close();
	}
	
}