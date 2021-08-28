package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class B2665 { //미로만들기
	static int N;
	static int[][] map, count;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N]; count = new int[N][N];
		for(int[] i : count) Arrays.fill(i, Integer.MAX_VALUE);
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) map[i][j] = s.charAt(j) - '0';
		}
		
		bfs();
		System.out.println(count[N - 1][N - 1]);
	}
	
	static void bfs() {
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

		Queue<Pair> Q = new LinkedList<>();
		Q.add(new Pair(0, 0, 0));
		
		while(!Q.isEmpty()) {
			Pair cur = Q.remove();
			int row = cur.row, col = cur.col, cnt = cur.count;
			
			for(int i = 0; i < 4; i++) {
				int r = row + dx[i];
				int c = col + dy[i];
				
				if(r < 0 || c < 0 || r >= N || c >= N) continue;
				if(map[r][c] == 1) {
					if(count[r][c] > cnt) {
						count[r][c] = cnt;
						Q.add(new Pair(r, c, cnt));
					}
				}
				else {
					if(count[r][c] > cnt + 1) {
						count[r][c] = cnt + 1;
						Q.add(new Pair(r, c, cnt + 1));
					}
				}
			}
		}
	
	}
	
	static class Pair {
		int row, col, count;
		
		Pair(int row, int col, int count){
			this.row = row;
			this.col = col;
			this.count = count;
		}
	}
}