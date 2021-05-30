package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class StackQueue_2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] pri = new int[n];
		for(int i = 0; i < n; i++) pri[i] = Integer.parseInt(st.nextToken());
		
		int loc = Integer.parseInt(br.readLine());
		
		Solution_StackQueue_2 sol = new Solution_StackQueue_2();
		System.out.println(sol.solution(pri, loc));
	}
}

class Solution_StackQueue_2 {
    public int solution(int[] pri, int loc) {
        int answer = 0, max = 0;
        int[] count = new int[10];
        Queue<int[]> Q = new LinkedList<>();
        
        for(int i = 0; i < pri.length; i++) {
        	max = Math.max(max, pri[i]);
        	count[pri[i]]++;
        	Q.add(new int[] {i, pri[i]});
        }
        
        while(!Q.isEmpty()) {
        	int[] cur = Q.remove();
        	int l = cur[0], p = cur[1];
        	
        	if(p < max) {
        		Q.add(new int[] {l, p});
        		continue;
        	}
        	else {
        		if(l == loc) return ++answer;
        		else {
        			count[p]--;
        			if(count[p] == 0) {
        				for(int i = max - 1; i > 0; i--) {
        					if(count[i] > 0) {
        						max = i;
        						break;
        					}
        				}
        			}
        			answer++;
        		}
        	}
        }
        return answer;
    }
}