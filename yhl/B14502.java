package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14502 { //������
	static int[][] map, w = new int[3][2];
	static boolean[][] room;
	static int N, M, count, ans;
	static ArrayList<int[]> arr = new ArrayList<>();
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		map = new int[N][M]; room = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
			
				if(n == 2) arr.add(new int[] {i, j});
				if(n == 0) {
					room[i][j] = true;
					count++; //�� ���� Ȯ��
				}
			}
		}
		
		ans = -1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(i == N - 1 && j == M - 2) break; //ù��° ���� ������ ���� ���������� �ι�° ���̸� ���� �� ���� ä������.
													//��, ���� �� ���� �� �� ���� ������ Ž������ �ʴ´�.
				
				if(room[i][j]) {
					w[0][0] = i; w[0][1] = j; //ù��° ��
					solve(i, j, 1);
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static void solve(int row, int col, int cnt) { //��Ʈ��ŷ
		if(cnt == 3) {
			ans = Math.max(ans, bfs());
			return;
		}
		
		int j = (col + 1) % M;
		for(int i = row; i < N; i++) {
			for(; j < M; j++) {
				if(room[i][j] && !(i == N - 1 && j == M - 1 && cnt == 1)) { //�ι�° ���� ������ ���� ������ ���̸� �� ��° ���� ����� ���� ������ Ž������ �ʴ´�.
					w[cnt][0] = i; w[cnt][1] = j; //���� ��
					solve(i, j, cnt + 1);
				}
			}
			j = 0;
		}
	}
	
	static int bfs() {
		boolean[][] vis = new boolean[N][M]; //true�� ��, false�� �� Ȥ�� ���̷���
		for(int i = 0; i < 3; i++) vis[w[i][0]][w[i][1]] = true;
		
		Queue<int[]> Q = new LinkedList<>();
		for(int i = 0; i < arr.size(); i++) Q.add(arr.get(i));
		int res = count - 3; //�� �� ���� ������ ������ �� ���� 3 ����
		
		while(!Q.isEmpty()) {
			int[] cur = Q.remove();
			int row = cur[0], col = cur[1];
			
			for(int i = 0; i < 4; i++) {
				int r = row + dx[i];
				int c = col + dy[i];
				
				if(r < 0 || c < 0 || r >= N || c >= M || vis[r][c] || map[r][c] != 0) continue;
				
				vis[r][c] = true; //���̷��� ����
				Q.add(new int[] {r, c});
				res--; //�� ����
			}
		}
		
		return res;
	}
}