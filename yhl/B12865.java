package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B12865 { //평범한 배낭

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] stuff = new int[N + 1][2], price = new int[N + 1][K + 1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int W = Integer.parseInt(st.nextToken()); //무게
			int V = Integer.parseInt(st.nextToken()); //가치
			
			stuff[i][0] = W; stuff[i][1] = V;
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= K; j++) {
				if(stuff[i][0] > j) price[i][j] = price[i - 1][j];
				else price[i][j] = Math.max(price[i - 1][j - stuff[i][0]] + stuff[i][1] , price[i - 1][j]);
			}
		}
		
		System.out.println(price[N][K]);
	}
}