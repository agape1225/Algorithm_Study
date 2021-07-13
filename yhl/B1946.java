package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1946 { //신입사원
	private static int[][] rank, temp;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			rank = new int[N][2]; temp = new int[N][2];
			for(int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				rank[j][0] = Integer.parseInt(st.nextToken());
				rank[j][1] = Integer.parseInt(st.nextToken());
			}
			merge_Sort(0, N);
			
			int ans = 1, min = rank[0][1];
			for(int j = 1; j < N; j++) {
				if(min > rank[j][1]) {
					ans++;
					min = rank[j][1];
				}
			}
			
			System.out.println(ans);
		}
	}
	public static void merge_Sort(int st, int en) {
		if(st + 1 == en) return;
		
		int mid = (st + en) / 2;
		
		merge_Sort(st, mid);
		merge_Sort(mid, en);
		merge(st, en);
	}
	public static void merge(int st, int en) {
		int mid = (st + en) / 2, firArr = st, secArr = mid;
		
		for(int i = st; i < en; i++) {
			if(firArr >= mid) temp[i] = rank[secArr++];
			else if(secArr >= en) temp[i] = rank[firArr++];
			else if(rank[firArr][0] <= rank[secArr][0]) temp[i] = rank[firArr++];
			else temp[i] = rank[secArr++];
		}
		
		for(int i = st; i < en; i++) rank[i] = temp[i];
	}
}