package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 가장_먼_노드 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] edge = new int[M][2];
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			edge[i][0] = n1;
			edge[i][1] = n2;
		}
		
		System.out.println(new Solution().solution(N, edge));
	}

	static class Solution {
	    int[] count;
	    boolean[] vis;
		public int solution(int n, int[][] edge) {
	        vis = new boolean[n + 1];
			count = new int[n + 1];
	        Arrays.fill(count, Integer.MAX_VALUE);
			
			PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
			ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
			for(int i = 0; i <= n; i++) arr.add(new ArrayList<>());
	        for(int i = 0; i < edge.length; i++) {
	        	arr.get(edge[i][0]).add(edge[i][1]);
	        	arr.get(edge[i][1]).add(edge[i][0]);
	        }
			
	        PQ.add(new int[] {1, 0});
	        count[1] = 0;
	        int max = 0, ans = -1;
	        while(!PQ.isEmpty()) {
	        	int[] cur = PQ.remove();
	        	int node = cur[0], dis = cur[1];
	        	
	        	if(vis[node]) continue;
	        	vis[node] = true;
	        	
	        	if(max < dis) {
	        		max = dis;
	        		ans = 1;
	        	}
	        	else if(max == dis) ans++;
	        	
	        	for(Integer a : arr.get(node)) {
	        		if(vis[a]) continue;
	        		
	        		int d = dis + 1;
	        		if(count[a] > d) {
	        			count[a] = d;
	        			PQ.add(new int[] {a, d});
	        		}
	        	}
	        }
	        
	        return ans;
	    }
	}
}