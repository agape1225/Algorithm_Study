package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2630 { //색종이 만들기
	private static int[][] map;
	private static int[] ans;
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		ans = new int[2]; //0은 white, 1은 blue
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		solve(0, 0, N);
		
		System.out.println(ans[0] + "\n" + ans[1]);
	}
	
	public static void solve(int row, int col, int n) {
		 if(n == 1) {
			 ans[map[row][col]]++;
			 return;
		 }
		 
		 int rule = map[row][col];
		 for(int i = row; i < row + n; i++) {
			 for(int j = col; j < col + n; j++) {
				 if(rule != map[i][j]) {
					 n /= 2;
					 solve(row, col, n);
					 solve(row + n, col, n);
					 solve(row, col + n, n);
					 solve(row + n, col + n, n);
					 return;
				 }
			 }
		 }
		 
		 ans[rule]++;
	}
}