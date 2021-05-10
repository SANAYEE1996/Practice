class Solution {
    public int solution(int[] arr) {
        int answer = -1;
        int div = 2;
        for(int i = 0; i<arr.length; i++) {
        	int a = arr[i];
        	for(int j = 0; j < arr.length; j++) {
        		if(arr[j] % div == 0) {
        			break;
        		}
        	}
        }
        
        
        return answer;
    }
}