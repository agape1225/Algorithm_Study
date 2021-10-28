package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1992 { //ÄõµåÆ®¸®
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) map[i][j] = s.charAt(j) - '0';
		}
		
		solve(0, N, 0, N, N);
		System.out.println(sb);
	}
	
	static void solve(int stRow, int enRow, int stCol, int enCol, int n) {
		int num = map[stRow][stCol];
		
		if(n == 1) {
			sb.append(num);
			return;
		}
		
		for(int i = stRow; i < enRow; i++) {
			for(int j = stCol; j < enCol; j++) {
				if(map[i][j] != num) {
					n /= 2;
					
					sb.append('(');
					for(int a = 0; a < 2; a++) {
						for(int b = 0; b < 2; b++) 
							solve(stRow + n * a, stRow + n * (a + 1), stCol + n * b, stCol + n * (b + 1), n);	
					}
					sb.append(')');
					return;
				}
			}
		}
		
		sb.append(num);
		return;
	}
}