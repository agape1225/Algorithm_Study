package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class K¹øÂ°¼ö {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[][] com = new int[M][3];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			com[i][0] = Integer.parseInt(st.nextToken());
			com[i][1] = Integer.parseInt(st.nextToken());
			com[i][2] = Integer.parseInt(st.nextToken());
		}
		
		Solution sol = new Solution();
		int[] ans = sol.solution(arr, com);
		
		for(int a : ans) System.out.println(a + " ");
	}
	
	static class Solution {
	    public int[] solution(int[] array, int[][] commands) {
	        int size = commands.length;
	    	int[] answer = new int[size], arr;
	    	
	    	for(int i = 0; i < size; i++) {
	    		int len = commands[i][1] - commands[i][0] + 1;
	    		arr = new int[len];
	    		System.arraycopy(array, commands[i][0] - 1, arr, 0, len);
	    		Arrays.sort(arr);
	    		answer[i] = arr[commands[i][2] - 1];
	    	}
	        return answer;
	    }
	}
}
