
public class PrimeCount {
	public static void main(String[] args) {
		int n = 100000;
		
        
        System.out.println(primeCount(n));
	}
	
	private static int primeCount(int n) {
		int cnt = 0;
		boolean[] isPrime = new boolean[n+1];
		for(int i=2; i<=n ; i++) 
			isPrime[i]=true;
        
		int root=(int)Math.sqrt(n); 
		
		for(int i=2; i<=root; i++){ 
			if(isPrime[i]==true){ 
				for(int j=i; i*j<=n; j++)
					isPrime[i*j]=false; 
			} 
		}
		for(int i =2; i<=n; i++) { 
			if(isPrime[i]==true) 
				cnt++; 
		}
		return cnt;
	}
}
