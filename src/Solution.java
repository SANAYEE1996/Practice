import java.util.Arrays;

public class Solution {
    public static void main(String args[]) {
    	int[] people = {70, 50, 80, 50,100,130,10,20,45,150,143,65};
    	int limit = 150;
    	
    	int answer = 0;
    	Arrays.sort(people);
    	System.out.println(Arrays.toString(people));
    	int sum = 0;
    	int cnt = 0;
    	
    	for(int i = 0; i < people.length; i++) {
    		sum += people[i];
    		cnt++;
    		if(cnt == 2 && sum <= limit) {
    			answer++;
    			cnt = 1;
    		}
    		else if(cnt == 2 && sum > limit) {
    			answer++;
    			sum = people[i];
    			cnt = 1;
    		}
    		
    	}
    	//Greedy algol
        System.out.println("the answer is " +answer);
    }
}