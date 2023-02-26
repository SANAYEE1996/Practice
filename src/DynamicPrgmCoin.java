
public class DynamicPrgmCoin {

	public static void main(String[] args) {
		
		int payback = 10000;
		int[] moneyCase = {10,50,100};
		
		System.out.println(Coin(moneyCase,payback));
	}
	
	private static int Coin(int[] c, int max){
		int DP[] = new int[max+1];
		DP[0] = 1;	
		
		for(int i = 0; i < c.length; i++){
			for(int n = 1; n <= max; n++){
				if(n-c[i] >= 0)	
					DP[n] += DP[n-c[i]];
			}
		}
		
		return DP[max]%1000000007;
	}
}
