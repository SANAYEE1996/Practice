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
}