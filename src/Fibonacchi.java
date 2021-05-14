
public class Fibonacchi {

	public static void main(String[] args) {
		
		System.out.println(fibo(10));
		

	}
	private static int fibo(int n) {
		if(n <= 2) {
			return 1;
		}
		else {
            int a = 0;
            int b = 1;
            int sum = 0;
            
            for (int i = 2; i <= n; i++) {
                sum = (a + b)%1234567;
                a = b;
                b = sum;
            }
             
            return sum;
        }
	}
}
