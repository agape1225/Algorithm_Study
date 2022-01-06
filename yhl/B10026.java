package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B10026 { //적록색약
	static int N, count1 = 0, count2 = 0; //1은 적록색약이 아닌 사람, 2는 적록색약인 사람
	static char[][] map;
	static boolean[][] vis1, vis2;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
	
		map = new char[N][N]; vis1 = new boolean[N][N]; vis2 = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) map[i][j] = s.charAt(j);
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!vis1[i][j]) {
					bfs(i, j, false);
					count1++;
				}
				if(!vis2[i][j]) {
					bfs(i, j, true);
					count2++;
				}
			}
		}
		
		System.out.println(count1 + " " + count2);
	}
	
	static void bfs(int row, int col, boolean blind) {
		int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
		Queue<int[]> Q = new LinkedList<>();
		boolean[][] vis_color = new boolean[N][N];
		
		if(blind) vis_color = vis2;
		else vis_color = vis1;
		
		Q.add(new int[] {row, col});
		vis_color[row][col] = true;
		char color = map[row][col];
		
		while(!Q.isEmpty()) {
			int[] cur = Q.remove();
			
			for(int i = 0; i < 4; i++) {
				int r = cur[0] + dx[i], c = cur[1] + dy[i];
				
				if(r < 0 || c < 0 || r >= N || c >= N || vis_color[r][c]) continue;
				if(color != map[r][c]) {
					if(!blind) continue;
					if(color == 'B' || map[r][c] == 'B') continue;
				}
				
				Q.add(new int[] {r, c});
				vis_color[r][c] = true;
			}
		}
	}
}