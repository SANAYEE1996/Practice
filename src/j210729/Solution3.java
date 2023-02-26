package j210729;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution3 {
	public int solution(String[][] relation) {
        int answer = 0;
        int[] count = new int[1];
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> index = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < relation[0].length; i++) {
        	for(int j = 0; j < relation.length; j++) {
        		if(list.contains(relation[j][i]) == false) {
        			list.add(relation[j][i]);
        		}
        	}
        	if(list.size() == relation.length) {
        		index.add(i);
        		answer++;
        	}
        	list = new ArrayList<>();
        }
        String[][] check = new String[relation.length][relation[0].length - index.size()];
        for(int i = 0; i < relation.length; i++) {
        	int flag = 0;
        	for(int j = 0; j < relation[i].length; j++) {
        		if(index.contains(j)) {
        			continue;
        		}
        		else {
        			check[i][flag] = relation[i][j];
        			flag++;
        		}
        	}
        }
        for(int i = 0; i < check.length; i++) {
        	System.out.println(Arrays.toString(check[i]));
        }
        min(list,check,sb,0,count);
        	
        answer += count[0];
        return answer;
    }
	
	public static void min(ArrayList<String> list, String[][] check,StringBuilder sb,int flag,int[] count) {
		int size = list.size();
		boolean isMin = true;
		if(size == 0) {
			for(int j = flag; j < check[0].length; j++) {
				for(int i = 0; i < check.length; i++) {
					sb.append(check[i][j]);
					if(list.contains(sb.toString())) {
						isMin = false;
					}
					list.add(sb.toString());
					sb.setLength(0);
				}
				int index = j;
				if(index < check[0].length-1) {
					min(list,check,sb,++index,count);
				}
				list = new ArrayList<>();
			}
		}
		else {
			for(int j = flag; j < check[0].length; j++) {
				ArrayList<String> copy = new ArrayList<>();
				copy.addAll(list);
				for(int i = 0; i < check.length; i++) {
					sb.append(copy.get(i));
					sb.append(check[i][j]);
					if(copy.contains(sb.toString())) {
						isMin = false;
					}
					copy.set(i, sb.toString());
					sb.setLength(0);
				}
				if(isMin) {
					count[0]++;
				}
				if(isMin == false && j < check[0].length-1){
					sb.setLength(0);
					int index = j;
					min(copy,check,sb,++index,count);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Solution3 s = new Solution3();
		String[][] a = {
						{"100","ryan","music","2","daegu"},
						{"200","apeach","math","2","daegu"},
						{"300","tube","computer","3","seoul"},
						{"400","con","computer","4","jeju"},
						{"500","muzi","music","3","busan"},
						{"600","apeach","music","2","suwon"}
						};
		System.out.println(s.solution(a));
	}
}
