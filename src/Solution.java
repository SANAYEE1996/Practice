public class Solution {
    public static void main(String args[]) {
    	int[][] triangle = {     {7},
    						    {3,8},
    						   {8,1,0},
    						  {2,7,4,4},
    						 {4,5,2,6,5}
    						};
    	int answer = 0;
    	
    	dp(triangle);
    	
        System.out.println("the answer is " +answer);
    }
    
    private static int dp(int[][] arr) {
    	int n = arr.length;
    	for(int i = 1; i< arr.length; i++) {
    		for(int j = 0; j < arr[i].length; j++) {
    			if(j <1) arr[i][j] += arr[i-1][j];
    			else arr[i][j] += arr[i-1][j-1];
    		}
    	}
    	
    	return n;
    }
}