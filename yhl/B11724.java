package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11724 { //연결 요소의 개수

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] arr = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) arr[i] = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			arr[n1].add(n2);
			arr[n2].add(n1);
		}
		
		Queue<Integer> Q = new LinkedList<>();
		boolean[] vis = new boolean[N + 1];
		Arrays.fill(vis, false);
		
		int count = 0;
		for(int i = 1; i <= N; i++) {
			if(vis[i]) continue;
			
			Q.add(i);
			vis[i] = true;
			count++;
			while(!Q.isEmpty()) {
				int cur = Q.remove();
				
				for(Integer a : arr[cur]) {
					if(vis[a]) continue;
					vis[a] = true;
					Q.add(a);
				}
			}
		}
		
		System.out.println(count);
	}
}