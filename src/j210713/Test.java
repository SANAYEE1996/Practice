package j210713;

public class Test {
	public static void tt(int n) {
		
		for(int i = 0; i < n; i++) {
			if( i%2 == 0) {
				System.out.println("들어 온 수 : "+n+" 짝수인 수 : "+i+"짝수 재귀");
				tt(i);
			}
			if( i%5 == 0){
				System.out.println("들어 온 수 : "+n+" 배수인 수 : "+i+"나머지 재귀");
				tt(i);
			}
		}
	}
	
	public static void main(String[] args) {
		tt(10);
	}
}
