package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1916 { //최소비용 구하기
	static ArrayList<ArrayList<Node>> arr = new ArrayList<>();
	static boolean[] vis;
	static int[] dis;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
		vis = new boolean[N + 1]; dis = new int[N + 1];
		for(int i = 0; i <= N; i++) arr.add(new ArrayList<>());
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr.get(a).add(new Node(b, c));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken()), v2 = Integer.parseInt(st.nextToken());
		
		Arrays.fill(dis, Integer.MAX_VALUE);
		System.out.println(dij(v1, v2));
		
	}

	static int dij(int st, int en) {
		PriorityQueue<Node> PQ = new PriorityQueue<>();
		PQ.add(new Node(st, 0)); dis[st] = 0;
		
		while(!PQ.isEmpty()) {
			Node cur = PQ.remove();
			int node = cur.node, distance = cur.dis;
			
			if(node == en) return distance;
			
			if(vis[node]) continue;
			vis[node] = true;
			
			for(Node i : arr.get(node)) {
				int n = i.node, d = distance + i.dis;
				if(vis[n]) continue;
				
				if(dis[n] > d) {
					dis[n] = d;
					PQ.add(new Node(n, d));
				}
			}
		}
		
		return -1;
	}
	
	static class Node implements Comparable<Node>{
		int node, dis;
		
		public Node(int node, int dis) {
			this.node = node;
			this.dis = dis;
		}
		
		public int compareTo(Node tar) { return this.dis < tar.dis ? -1 : 1; }
	}
}