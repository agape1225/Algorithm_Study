package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B2665_2 { //미로만들기
	static int N;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) map[i][j] = s.charAt(j) - '0';
		}
		
		System.out.println(dij());
	}
	
	static int dij() {
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		boolean[][] vis = new boolean[N][N];
		
		PriorityQueue<Pair> PQ = new PriorityQueue<>();
		PQ.add(new Pair(0, 0, 0));
		
		while(!PQ.isEmpty()) {
			Pair cur = PQ.remove();
			int row = cur.row, col = cur.col, count = cur.count;
		
			if(row == N - 1 && col == N - 1) return count;
			if(vis[row][col]) continue;
			vis[row][col] = true;
			
			for(int i = 0; i < 4; i++) {
				int r = row + dx[i], c = col + dy[i];
				
				if(r < 0 || c < 0 || r >= N || c >= N || vis[r][c]) continue;
				
				if(map[r][c] == 1) PQ.add(new Pair(r, c, count));
				else PQ.add(new Pair(r, c, count + 1));
			}
		}
		
		return -1;
	}
	
	static class Pair implements Comparable<Pair> {
		int row, col, count;
		Pair(int row, int col, int count) {
			this.row = row;
			this.col = col;
			this.count = count;
		}
		
		public int compareTo(Pair target) { return this.count < target.count ? -1 : 1; }
	}
}