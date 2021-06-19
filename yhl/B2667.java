package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class B2667 { //단지번호붙이기
	private static int[][] map;
	private static boolean[][] vis;
	private static ArrayList<Integer> ans;
	private static int n;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		vis = new boolean[n][n];
		ans = new ArrayList<>();
			
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < n; j++) map[i][j] = s.charAt(j) - '0';
		}
		
		bfs();
		
		System.out.println(ans.size());
		for(int a : ans) System.out.println(a);
	}
	
	public static void bfs() {
		Queue<int[]> Q = new LinkedList<>();
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(vis[i][j] || map[i][j] == 0) continue;
				
				int count = 1;	
				Q.add(new int[] {i, j});
				vis[i][j] = true;
				
				while(!Q.isEmpty()) {
					int[] cur = Q.remove();
					int row = cur[0];
					int col = cur[1];
					
					for(int k = 0; k < 4; k++) {
						int x = row + dx[k];
						int y = col + dy[k];
						
						if(x < 0 || y < 0 || x >= n || y >= n || vis[x][y] || map[x][y] == 0) continue;
						
						Q.add(new int[] {x, y});
						vis[x][y] = true;
						count++;
					}
				}
				
				ans.add(count);
			}
		}
		
		Collections.sort(ans);
	}
}