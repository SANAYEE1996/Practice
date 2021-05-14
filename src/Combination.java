public class Combination {

	public static void main(String[] args) {
		
		int[] nums = {6,3,9,8,1,5,8,12,2,17,217,4,11};
		int[] cc = new int[combinationCount(nums.length,3)];
        boolean[] visited = new boolean[nums.length];
        comb(nums,visited,0,nums.length,3,cc);
        
        System.out.println(prim(cc));

	}
	
	public static int combinationCount(int n, int r) {
		if(n == r || r == 0) 
			return 1; 
		else 
			return combinationCount(n - 1, r - 1) + combinationCount(n - 1, r); 
	}
	public static int i = 0;
	static void comb(int[] arr, boolean[] visited, int start, int n, int r,int[] cc) {
        if (r == 0) {
            cc[i] = sum(arr, visited, n);
            i++;
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            comb(arr, visited, i + 1, n, r - 1,cc);
            visited[i] = false;
        }
    }
	
	static int sum(int[] arr, boolean[] visited, int n) {
		int sum = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sum += arr[i];
            }
        }
        return sum;
    }
	
	private static int prim(int[] arr) {
		int cnt = 0;
		
		for(int i = 0; i<arr.length; i++) {
			for(int j = 2; j < arr[i]; j++) {
				if(arr[i]%j == 0) break;
				if(j+1 == arr[i]) cnt++;
			}
		}
		
		return cnt;
	}
}
