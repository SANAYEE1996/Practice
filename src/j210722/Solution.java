package j210722;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int temp = 0;
        for(int i = 0; i < road.length; i++) {
        	if(road[i][0] > road[i][1]) {
        		temp = road[i][0];
        		road[i][0] = road[i][1];
        		road[i][1] = temp;
        	}
        }
        
        Arrays.sort(road, new Comparator<int[]>() {
		    @Override
			public int compare(int[] o1, int[] o2) {
		    	 if(o1[0] == o2[0]) {
	                 return o1[1] - o2[1];
		    	 }else {
		    		 return o1[0] - o2[0]; 
		    	 }
	           }
        });
        
        for(int i = 0; i < road.length; i++) {
        	System.out.println(Arrays.toString(road[i]));
        }
        
        int[] city = new int[N];
        city[0] = 1;
        int sum ;
        for(int i = 0; i < road.length; i++) {
        	sum = 0;
        	if(road[i][0] == 1) {
        		sum += road[i][2];
        		if(sum < K) {
        			city[road[i][1]-1] = 1;
        			banbok(road,sum,road[i][1],i+1,city,K);
        		}
        		else if(sum == K) {
        			city[road[i][1]-1] = 1;
        		}
        	}
        }
        
        for(int i = 0; i < city.length; i++) {
        	answer += city[i];
        }
        
        return answer;
    }
    
    public static void banbok(int[][] road, int sum,int arrive ,int index,int[] city,int K) {
    	int arr;
    	int dis;
    	for(int i = index; i < road.length; i++) {
        	arr = 0;
        	dis = sum;
        	if(road[i][0] == arrive) {
        		dis += road[i][2];
        		arr = road[i][1];
        		if(dis < K) {
        			city[arr-1] = 1;
        			banbok(road,dis,arr,i+1,city,K);
        		}
        		else if(dis == K) {
        			city[arr-1] = 1;
        		}
        	}
            else if(road[i][0] > arrive) {
        		break;
        	}
        }
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		int[][] road2 = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		int[][] road3 = {{1,2,1},{1,3,1},{1,4,1},{1,5,1},{1,6,2}};
		System.out.println("the answer is : " +s.solution(5, road, 3));
		System.out.println("the answer is : " +s.solution(6, road2, 4));
		System.out.println("the answer is : " +s.solution(6, road3, 1));
		
	}
}

/*
        for(int i = 0; i < road.length; i++) {
        	System.out.println(Arrays.toString(road[i]));
        }
        
 * 
 * 
 * System.out.println(Arrays.toString(city));
 * System.out.println("종착지 // 거리 합 : "+dis +" 어디서 왔는지 : "
        						+road[i][0]+" 어디에서 멈췄는지 : " +arr);
 * 
 * System.out.println("재귀 몇번인지 체크 // 거리 합 : "+sum +" 어디서 왔는지 : "
    						+road[index-1][0]+" 어디로 가는지 : " +arrive+" 몇번째 행부터 진행할건지 : " +index);
 * 
 * 
 * */
