package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1389 { //케빈 베이컨의 6단계 법칙
	static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
	static int N, M;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		for(int i = 0; i <= N; i++) arr.add(new ArrayList<>());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken()), p2 = Integer.parseInt(st.nextToken());
			
			arr.get(p1).add(p2); arr.get(p2).add(p1);
		}
		
		int min = Integer.MAX_VALUE, ans = 0;
		for(int i = 1; i <= N; i++) {
			int m = dij(i);
			if(min > m) {
				min = m;
				ans = i;
			}
		}
		
		System.out.println(ans);
	}

	static int dij(int num) {
		Queue<int[]> Q = new LinkedList<>();
		boolean[] vis = new boolean[N + 1];
		int res = 0;
		
		Q.add(new int[] {num, 0});
		while(!Q.isEmpty()) {
			int[] cur = Q.remove();
			int node = cur[0], count = cur[1];
			
			if(vis[node]) continue;
			vis[node] = true;
			
			for(Integer a : arr.get(node)) {
				if(vis[a]) continue;
				
				res += count + 1;
				Q.add(new int[] {a, count + 1});
			}
		}
		
		return res;
	}
}