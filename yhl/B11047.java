package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047 { //µ¿Àü 0
	private static int N, K;
	private static int[] coin;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		coin = new int[N];
		for(int i = 0; i < N; i++) coin[i] = Integer.parseInt(br.readLine());
		
		System.out.println(solve(N, 0));
	}
	public static int solve(int n, int count) {
		int size = n - 1, ans = count;
		
		if(K < coin[size]) return solve(size, ans);
		else {
			while(K >= coin[size]) {
				K -= coin[size];
				ans++;
			}
			
			if(K == 0) return ans;
			else return solve(size, ans);
		}
	}
}