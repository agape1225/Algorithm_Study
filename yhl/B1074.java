package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1074 { //Z
	private static int[][] num;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
	
		Z(n, r, c);
		
		System.out.println(Z(n, r, c));
	}

	public static int Z(int n, int row, int col) {
		if(n == 0) return 0;
		int half = 1 << (n - 1);
		if(row < half && col < half) return Z(n - 1, row, col);
		else if(row < half && col >= half) return half * half + Z(n - 1, row, col - half);
		else if(row >= half && col < half) return 2 * half * half + Z(n - 1, row - half, col);
		else return 3 * half * half + Z(n - 1, row - half, col - half);
	}
}
