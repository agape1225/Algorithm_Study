package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 모의고사 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] answers = new int[n];
		for(int i = 0; i < n; i++) answers[i] = Integer.parseInt(st.nextToken());
		
		Solution_모의고사 sol = new Solution_모의고사();
		int[] answer = sol.solution(answers);
		
		for(int i = 0; i < answer.length; i++) System.out.println(answer[i]);
	}
}

class Solution_모의고사 {
    public int[] solution(int[] answers) {
    	int[] One = {1, 2, 3, 4, 5} , Two = {2, 1, 2, 3, 2, 4, 2, 5} , Three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    	int size = answers.length;
    	int[] answer = new int[3];
    	int one = 0, two = 0, three = 0;
        
        for(int i = 0; i < size; i++) {
        	if(one > 4) one = 0;
        	if(two > 7) two = 0;
        	if(three > 9) three = 0;
        	
        	if(One[one++] == answers[i]) answer[0]++;
        	if(Two[two++] == answers[i]) answer[1]++;
        	if(Three[three++] == answers[i]) answer[2]++;
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        int min = answer[0];
        arr.add(1);
        for(int i = 1; i < 3; i++) {
        	if(answer[i] == min) arr.add(i + 1);
        	else if(answer[i] > min) {
        		arr.clear();
        		arr.add(i + 1);
        		min = answer[i];
        	}
        }
        
        int n = arr.size(), index = 0;
        int[] ans = new int[n];
        for(Integer i : arr) ans[index++] = i;
        return ans;
    }
}