<<<<<<< HEAD
import java.util.Arrays;

class Solution {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		for (int i = 0; i < participant.length; i++) {
            if(i < completion.length && (completion[i].equals(participant[i])) == false){
	            answer = participant[i];
	            break;
            }
            else if (i == participant.length-1){
                answer = participant[i];
            }
		}

		return answer;
	}
=======

class Solution {
	public static void main(String args[]) {
		String dartResult = "1D2S3T*";
		int answer = 0;
		answer = score(dartResult,answer);
		
		
		System.out.println("the answer is "+answer);
	}
	
	private static int score(String s,int answer) {
		int a = 0;
		char c = 0;
		char d = 0;
		int b = 0;
		for(int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if(i < s.length()-1) d = s.charAt(i+1);
			if(Character.isDigit(c)){
				if(Character.getNumericValue(c) == 1 && Character.getNumericValue(d) == 0) {
					a = 10;
					i++;
					continue;
				}
				a = Character.getNumericValue(c);
			}
			else{
				if(c == 'S') {
					answer += a;
				}
				else if(c == 'D') {
					a = (int) Math.pow(a, 2);
					answer += a;
				}
				else if(c == 'T') {
					a = (int) Math.pow(a, 3);
					answer += a;
				}
				else if(c == '*') {
					answer = a*2 + b*a;
					b = 0;
				}
				else if(c == '#') {
					answer -= a*2;
				}
			}
		}
		
		return answer;
	}
	
>>>>>>> branch 'master' of https://github.com/SANAYEE1996/Practice.git
}