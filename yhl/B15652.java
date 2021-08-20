package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15652 { //N°ú M (4)
	private static int N, M;
	private static int[] arr;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		
		search(0);
		System.out.println(sb);
	}
	
	public static void search(int K) {
		if(K == M) {
			for(int i = 0; i < M; i++) sb.append(arr[i]).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(K != 0 && arr[K - 1] > i) continue;
			arr[K] = i;
			search(K + 1);
		}
	}
}