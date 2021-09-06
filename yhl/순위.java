package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 순위 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] res = new int[N][2]; //0이 이긴 사람, 1이 진 사람
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int win = Integer.parseInt(st.nextToken()), lose = Integer.parseInt(st.nextToken());
			res[i][0] = win; res[i][1] = lose;
		}
		
		System.out.println(new Solution().solution(N, res));
	}
	
	static class Solution {
	    ArrayList<ArrayList<Integer>> winner, loser;
		boolean[] vis;
	    
		public int solution(int n, int[][] res) {
			winner = new ArrayList<>(); loser = new ArrayList<>();
			
			for(int i = 0; i <= n; i++) {
				winner.add(new ArrayList<>());
				loser.add(new ArrayList<>());
			}
			
			for(int i = 0; i < res.length; i++) {
				int win = res[i][0], lose = res[i][1];
				
				winner.get(win).add(lose); //win에게 진 사람들을 인덱스 win에 저장
				loser.get(lose).add(win); //lose에게 이긴 사람들을 인덱스 lose에 저장
			}
			
			int ans = 0;
			for(int i = 1; i <= n; i++) {
				vis = new boolean[n + 1];
				if(bfs(n, i)) ans++;
			}
			
			return ans;
		}
		
		boolean bfs(int n, int person) {
			Queue<Integer> win = new LinkedList<>(), lose = new LinkedList<>();
			
			win.add(person); lose.add(person);
			vis[person] = true;
			
			while(!win.isEmpty()) {
				int cur = win.remove();
				
				for(Integer a : winner.get(cur)) {
					if(vis[a]) continue;
					
					vis[a] = true;
					win.add(a);
				}
			}
			
			while(!lose.isEmpty()) {
				int cur = lose.remove();
				
				for(Integer a : loser.get(cur)) {
					if(vis[a]) continue;
					
					vis[a] = true;
					lose.add(a);
				}
			}
			
			for(int i = 1; i <= n; i++) {
				if(!vis[i]) return false;
			}
			
			return true;
		}
	}
}