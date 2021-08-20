package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15654 { //N°ú M (5)
	static int N, M;
	static int[] arr, num;
	static boolean[] vis;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		num = new int[N];
		vis = new boolean[10001];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(num);
		
		search(0);
		System.out.println(sb);
	}
	static void search(int K) {
		if(K == M) {
			for(int i = 0; i < M; i++) sb.append(arr[i]).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!vis[num[i]]) {
				arr[K] = num[i];
				vis[num[i]] = true;
				search(K + 1);
				vis[num[i]] = false;
			}
		}
	}
}