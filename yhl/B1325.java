package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1325 { //효율적인 해킹
	private static ArrayList<Integer>[] com;
	private static boolean[] vis;
	private static int[] count;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//자식이 부모를 신뢰한다. 부모가 해킹 당하면 자식까지 해킹 당한다.
		com = new ArrayList[N + 1];
		count = new int[N + 1];
		
		for(int i = 1; i <= N; i++) com[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int child = Integer.parseInt(st.nextToken());
			int parent = Integer.parseInt(st.nextToken());
		
			com[child].add(parent);
		}
		
		for(int i = 1; i <= N; i++) {
			vis = new boolean[N + 1];
			bfs(i);
		}
		
		int max = 0;
		for(int i = 1; i <= N; i++) {
			if(max < count[i]) max = count[i];
		}
		for(int i = 1; i <= N; i++) {
			if(max == count[i]) sb.append(i).append(" ");
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int index) {
		Queue<Integer> Q = new LinkedList<>();
		
		Q.add(index);
		vis[index] = true;
		count[index]++;
		
		while(!Q.isEmpty()) {
			int cur = Q.remove();

			for(Integer x : com[cur]) {
				if(vis[x]) continue;
				
				Q.add(x);
				count[x]++;
				vis[x] = true;
			}
		}
	}
}