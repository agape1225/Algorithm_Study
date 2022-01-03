package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14500 { //테트로미노
	static int N, M, max;
	static int[][] map;
	static boolean[][] vis;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M]; vis = new boolean[N][M]; max = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) solve(i, j, 1, map[i][j]);
		}
		
		System.out.println(max);
	}
	
	static boolean check_rowcol(int row, int col) {
		if(row < 0 || col < 0 || row >= N || col >= M || vis[row][col]) return false;
		
		return true;
	}
	
	static void solve(int row, int col, int count, int sum) {
		if(count == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		vis[row][col] = true;
		
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		for(int i = 0; i < 4; i++) {
			int r = row + dx[i], c = col + dy[i];
			
			if(check_rowcol(r, c)) {
				solve(r, c, count + 1, sum + map[r][c]);
			
				if(count == 2) {
					vis[r][c] = true;
					
					for(int j = 0; j < 4; j++) {
						int r2 = row + dx[j], c2 = col + dy[j];
						
						if(check_rowcol(r2, c2)) max = Math.max(max, sum + map[r][c] + map[r2][c2]);
					}
					
					vis[r][c] = false;
				}
			}
		}
		
		vis[row][col] = false;
	}
}