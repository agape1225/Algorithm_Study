package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1726 { //로봇
	private static int N, M, stRow, stCol, stRota, enRow, enCol, enRota; //N이 row M이 col, st는 시작 en은 마지막
	private static int[][] map;
	private static int[][][] count;
	private static boolean vis[][][];
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M]; count = new int[N][M][5]; vis = new boolean[N][M][5];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		stRow = Integer.parseInt(st.nextToken());
		stCol = Integer.parseInt(st.nextToken());
		stRota = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		enRow = Integer.parseInt(st.nextToken());
		enCol = Integer.parseInt(st.nextToken());
		enRota = Integer.parseInt(st.nextToken());

		System.out.println(bfs());
	}

	static int bfs() {
		int ans = Integer.MAX_VALUE;
		Queue<Pair> Q = new LinkedList<>();
		
		Q.add(new Pair(stRow - 1, stCol - 1, stRota));
		vis[stRow - 1][stCol - 1][stRota] = true;
		
		while(!Q.isEmpty()) {
			Pair cur = Q.remove();
			int row = cur.getRow(), col = cur.getCol(), rota = cur.getRota(), ct = count[row][col][rota];
			int[] tempCount = new int[5];
			tempCount = makeRota(rota, ct);
			
			if(row == enRow - 1 && col == enCol - 1) ans = Math.min(ans, tempCount[enRota]);
			
			for(int i = 1; i < 5; i++) {
				for(int j = 1; j < 4; j++) {
					int r = row, c = col, ro = i, co = tempCount[ro];

					if(ro == 1) c = col + j;
					else if(ro == 2) c = col - j;
					else if(ro == 3) r = row + j;
					else if(ro == 4) r = row - j;
					
					if(r < 0 || c < 0 || r >= N || c >= M || map[r][c] == 1) break;

					co++;
					if(vis[r][c][ro]) {
						count[r][c][ro] = Math.min(count[r][c][ro], co);
						continue;
					}
					
					Q.add(new Pair(r, c, ro));
					count[r][c][ro] = co;
					vis[r][c][ro] = true;
				}
			}
		}
		
		return ans;
	}
	
	/* 방향 정할 때, 명령 횟수
	 * 동/서 +2, 남북 +1
	 * 남/북 +2, 동서 +1
	 */
	static int[] makeRota(int rota, int count) {
		int[] res = {0, count, count, count, count}; //1 ~ 4, 동서남북
		
		switch(rota) {
		case 1 :
			res[2] += 2;
			res[3]++; res[4]++;
			break;
		case 2 :
			res[1] += 2;
			res[3]++; res[4]++;
			break;
		case 3 :
			res[4] += 2;
			res[1]++; res[2]++;
			break;
		case 4 :
			res[3] += 2;
			res[1]++; res[2]++;
			break;
		}
		
		return res;
	}
	
	static class Pair{
		int row, col, rota;
		
		Pair(int row, int col, int rota) {
			this.row = row;
			this.col = col;
			this.rota = rota;
		}
		
		int getRow() {
			return this.row;
		}
		int getCol() {
			return this.col;
		}
		int getRota() {
			return this.rota;
		}
	}
}