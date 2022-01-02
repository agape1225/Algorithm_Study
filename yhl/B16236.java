package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16236 { //아기 상어
	static int N, count;
	static int[][] map;
	static boolean[][] vis;
	static Queue<int[]> Q = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N]; vis = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 9) {
					Q.add(new int[] {i, j, 2, 0});
					count = 2;
					map[i][j] = 0;
					vis[i][j] = true;
				}
			}
		}
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		int res = 0, tempMove = Integer.MAX_VALUE, tempRow = Integer.MAX_VALUE, tempCol = Integer.MAX_VALUE;
		int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};
		
		while(!Q.isEmpty()) {
			int[] cur = Q.remove();
			int row = cur[0], col = cur[1], shark = cur[2], move = cur[3];
			
			//move가 -1이면 조건에 맞는 물고기를 찾았고, 큐의 특성상 더 돌려도 거리가 멀어져 의미가 없다.
			//즉, 큐를 멈추고 물고기 위치로 상어를 이동시킨다.
			if(move == -1) {
				res += tempMove;
				map[tempRow][tempCol] = 0;
				count--;
				
				//System.out.println("row : " + (tempRow + 1)+ " col : " + (tempCol + 1)+ " size : " + shark);
				
				if(count == 0) {
					shark += 1;
					count = shark;
				}
				
				//기존에 가지고 있던 정보를 모두 없애고 새로운 위치에서 시작한다.
				Q.clear();
				vis = new boolean[N][N];
				
				Q.add(new int[] {tempRow, tempCol, shark, 0});
				vis[tempRow][tempCol] = true;
				
				tempMove = Integer.MAX_VALUE; tempRow = Integer.MAX_VALUE; tempCol = Integer.MAX_VALUE;
				
				continue;
			}
			
			//거리가 가까운 먹을 수 있는 물고기 중에 조건에 맞는 위치 찾는다.
			if(map[row][col] < shark && map[row][col] != 0 && tempMove >= move) {
				if(tempMove == move) {
					if(tempRow < row) continue;
					else if(tempRow == row && tempCol < col) continue;
				}
				tempMove = move; tempRow = row; tempCol = col;
				
				Q.add(new int[] {row, col, shark, -1});
				vis[row][col] = true;
				continue;
			}
			
			//bfs
			for(int i = 0; i < 4; i++) {
				int r = row + dx[i], c = col + dy[i];
				
				//상어가 물고기보다 작거나 전에 거리가 멀면 continue
				if(r < 0 || c < 0 || r >= N || c >= N || vis[r][c] || map[r][c] > shark || tempMove <= move) continue;
				
				Q.add(new int[] {r, c, shark, move + 1});
				vis[r][c] = true;
			}
		}
		
		return res;
	}
}