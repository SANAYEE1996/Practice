

import java.util.Arrays;
import java.util.Comparator;

public class Solution9 {
	public int solution(int N, int[][] road, int K) {
        int answer = 1;
        int sum;
        int[] cnt = new int[N];
        Arrays.sort(road, new Comparator<int[]>() {
        	  @Override
        	  public int compare(int[] t1, int[] t2) {
        	    if (t1[0] == t2[0])
        	      return t1[1] - t2[1];
        	    else
        	      return t1[0] - t2[0];
        	  }
        	}
        );
        for(int i = 0; i < road.length; i++) {
        	sum = 0;
        	if(road[i][0] == 1) {
        		sum += road[i][2];
        		if(sum <= K && cnt[road[i][1]-1] != 1) {
        			cnt[road[i][1]-1] = 1;
        		}
        		count(road,K,road[i][1],sum,cnt);
        	}
        }
        
        for(int i = 0; i < road.length; i++) {
        	System.out.println(Arrays.toString(road[i]));
        }
        
        System.out.println(Arrays.toString(cnt));
        for(int i = 0; i < cnt.length; i++) {
        	answer+=cnt[i];
        }
        
        return answer;
    }
	
	public static void count(int[][] road, int K,int arrive,int sum,int[] cnt){
		int sum1 = sum;
		int sum2 = sum;
		System.out.println("몇번 재귀 들어오나 체크");
		if(sum < K) {
			for(int i = 0; i < road.length; i++) {
				if(road[i][1] == arrive && road[i][0] != 1) {
					sum1 += road[i][2];
					if(sum1 <= K && cnt[road[i][0]-1] != 1) {
						cnt[road[i][0]-1] = 1;
						count(road,K,road[i][0],sum1,cnt);
					}
					//count(road,K,road[i][0],sum1,cnt);
				}
				if(road[i][0] == arrive) {
					sum2 += road[i][2];
					if(sum2 <= K && cnt[road[i][1]-1] != 1) {
						cnt[road[i][1]-1] = 1;
						count(road,K,road[i][1],sum2,cnt);
					}
					//count(road,K,road[i][1],sum2,cnt);
				}
			}
		}
	}
	
	public static void count1(int[][] road, int K,int flag,int arrive,int sum,int[] cnt){
		if(sum < K) {
			for(int i = flag+1; i < road.length; i++) {
				if(road[i][0] == arrive) {
					sum += road[i][2];
					if(sum <= K && cnt[road[i][1]-1] != 1) {
						cnt[road[i][1]-1] = 1;
						count1(road,K,i,road[i][1],sum,cnt);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Solution9 s = new Solution9();
		int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		int[][] road2 = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		System.out.println("the answer is : " +s.solution(5, road, 3));
		System.out.println("the answer is : " +s.solution(6, road2, 4));
	}
}
