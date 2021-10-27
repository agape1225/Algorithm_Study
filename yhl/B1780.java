package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1780 { //종이의 개수
	static int N;
	static int[][] map;
	static int[] res = new int[3];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		solve(0, N, 0, N, N);
		for(int i = 0; i < 3; i++) System.out.println(res[i]);
	}
	static void solve(int stRow, int enRow, int stCol, int enCol, int n) {
		int num = map[stRow][stCol];
		for(int i = stRow; i < enRow; i++) {
			for(int j = stCol; j < enCol; j++) {
				if(num != map[i][j]) {
					n /= 3;
					
					for(int a = 0; a < 3; a++) {
						for(int b = 0; b < 3; b++) 
							solve(stRow + n * a, stRow + n * (a + 1), stCol + n * b, stCol + n * (b + 1), n);
					}
					
					//solve(stRow, stRow + n, stCol, stCol + n, n);
					//solve(stRow, stRow + n, stCol + n, stCol + n * 2, n);
					//solve(stRow, stRow + n, stCol + n * 2, stCol + n * 3, n);
					
					//solve(stRow + n, stRow + n * 2, stCol, stCol + n, n);
					//solve(stRow + n, stRow + n * 2, stCol + n, stCol + n * 2, n);
					//solve(stRow + n, stRow + n * 2, stCol + n * 2, stCol + n * 3, n);
					
					//solve(stRow + n * 2, stRow + n * 3, stCol, stCol + n, n);
					//solve(stRow + n * 2, stRow + n * 3, stCol + n, stCol + n * 2, n);
					//solve(stRow + n * 2, stRow + n * 3, stCol + n * 2, stCol + n * 3, n);
					
					return;
				}
			}
		}
		
		if(num == -1) res[0]++;
		else if(num == 0) res[1]++;
		else if(num == 1) res[2]++;
	}
}