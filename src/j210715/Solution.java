package j210715;

import java.util.Arrays;

public class Solution {
	public String solution(String[] participant, String[] completion) {
		String answer = "";

		Arrays.sort(participant);
		Arrays.sort(completion);

		for (int i = 0; i < participant.length; i++) {
			if (i < completion.length) {
				if ((completion[i].equals(participant[i])) == false) {
					answer = participant[i];
					break;
				}
			} 
			else {
				answer = participant[participant.length - 1];
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa" };
		String[] completion = { "josipa", "filipa", "marina", "nikola" };

		System.out.println(s.solution(participant, completion));
	}

}
