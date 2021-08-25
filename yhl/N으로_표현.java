package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class N으로_표현 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		
		System.out.println(new Solution().solution(N, num));
	}
	static class Solution {
	    ArrayList<Integer>[] store = new ArrayList[9];
	    boolean[] vis = new boolean[32001];
		public int solution(int N, int num) {
	        for(int i = 1; i < 9; i++) store[i] = new ArrayList<Integer>();
	        String s = "";
	        
	        int count = 1;
	        while(count < 9) {
	        	s += N;
	        	int n = Integer.parseInt(s);	
	        	if(n == num) return count;
	        	if(n <= 32000) {
	        		vis[n]= true;
	        		store[count].add(n);
		        }
	        	
	        	for(int i = 1; i <= count; i++) {
	        		if(count + i > 8) break;
	        		for(Integer a : store[count]) {
	        			for(Integer b : store[i]) {
	        				int n1 = a, n2 = b;
	        				int[] res = {n1 + n2, n1 * n2, n1 - n2, n2 - n1, n1 / n2, n2 / n1};
	        				
	        				for(int j = 0; j < 6; j++) {
	        					if(res[j] <= 0 || res[j] > 32000 || vis[res[j]]) continue;
	        					if(res[j] == num) return i + count;
	        					
	        					store[i + count].add(res[j]);
	        					vis[res[j]] = true;
	        				}
	        			}
	        		}
	        	}
	        	
	        	count++;
	        }
	        
	        return -1;
	    }
	}
}