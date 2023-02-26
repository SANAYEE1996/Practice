package j210723;

import java.util.Arrays;
import java.util.Comparator;

public class Solution5 {
	public String[] solution(String[] files) {
		StringBuilder sb = new StringBuilder();
		String a = "";
		String[][] type = new String[files.length][3];
		for(int i = 0; i < files.length; i++) {
			a = files[i].replaceAll("[^0-9]", "");
			type[i][0] = files[i].substring(0, files[i].indexOf(a));
			type[i][1] = a;
			type[i][2] = files[i].substring(files[i].indexOf(a)+a.length());
			//System.out.println(Arrays.toString(type[i]));
		}
		
		Arrays.sort(type, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].equals(o2[0])) {
                    int max = Math.max(Integer.parseInt(o2[1]), Integer.parseInt(o1[1]));
                    if(Integer.parseInt(o2[1]) == Integer.parseInt(o1[1])) {
                		return o1[1].compareTo("9999999");
                	}
                    else if(max == Integer.parseInt(o2[1])) {
                		return o2[1].compareTo("9999999");
                	}
                	else if(max == Integer.parseInt(o1[1])) {
                		return o1[1].compareTo("9999999");
                	}
                	else 
                		return o1[1].compareTo(o2[1]);
                }
                else
                    return o1[0].compareTo(o2[0]);
            }			
        });
		
        String[] answer = new String[files.length];
        for(int i = 0; i < answer.length; i++) {
        	sb.append(type[i][0]);
        	sb.append(type[i][1]);
        	sb.append(type[i][2]);
        	answer[i] = sb.toString();
        	sb.setLength(0);
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Solution5 s = new Solution5();
		String[] a = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		String[] b = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat","F-15"};
		System.out.println(Arrays.toString(s.solution(a)));
		System.out.println(Arrays.toString(s.solution(b)));
		
	}
}
