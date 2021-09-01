package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1922 { //네트워크 연결

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		ArrayList<ArrayList<int[]>> arr = new ArrayList<>();
		for(int i = 0; i <= N; i++) arr.add(new ArrayList<>());
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr.get(a).add(new int[] {b, c});
			arr.get(b).add(new int[] {a, c});
		}
		
		boolean[] vis = new boolean[N + 1];
		PQ.add(new int[] {1, 0});
		
		int ans = 0;
		while(!PQ.isEmpty()) {
			int[] cur = PQ.remove();
			
			if(vis[cur[0]]) continue;
			
			vis[cur[0]] = true;
			ans += cur[1];
			
			for(int[] x : arr.get(cur[0])) {
				int com = x[0], price = x[1];
				
				if(vis[com]) continue;
				
				PQ.add(new int[] {com, price});
			}
		}
		
		System.out.println(ans);
	}
}