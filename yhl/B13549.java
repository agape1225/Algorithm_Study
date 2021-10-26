package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B13549 { //¼û¹Ù²ÀÁú 3
	static int N, K;
	static boolean[] vis = new boolean[100001];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		System.out.println(dij());
	}
	static int dij() {
		PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		PQ.add(new int[] {N, 0});
		
		while(!PQ.isEmpty()) {
			int[] cur = PQ.remove();
			int n = cur[0], c = cur[1];
			
			vis[n] = true;
			
			if(n == K) return c;
			if(n > K) {
				PQ.add(new int[] {n - 1, c + 1});
				continue;
			}
			if(n > 0 && !vis[n - 1]) PQ.add(new int[] {n - 1, c + 1});
			if(n < 100000 && !vis[n + 1]) PQ.add(new int[] {n + 1, c + 1});
			if(n < 50001 && !vis[n * 2]) PQ.add(new int[] {n * 2, c});
		}
		
		return -1;
	}
}