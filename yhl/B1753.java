package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1753 { //최단경로
	private static int[] dis;
	private static boolean[] vis;
	private static int K;
	private static PriorityQueue<Pair> PQ = new PriorityQueue<>();
	private static HashMap<Integer, Integer>[] map;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		dis = new int[V + 1];
		vis = new boolean[V + 1];
		map = new HashMap[V + 1];
		for(int i = 1; i <= V; i++) map[i] = new HashMap<>();
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			if(map[u].containsKey(v) && map[u].get(v) < w) continue;
			map[u].put(v, w);
			if(u == K) PQ.add(new Pair(v, w));
		}
		
		dijk();
		for(int i = 1; i <= V; i++) {
			if(!vis[i]) sb.append("INF").append("\n");
			else sb.append(dis[i]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dijk() {
		Arrays.fill(dis, Integer.MAX_VALUE);
		vis[K] = true;
		dis[K] = 0;
		
		while(!PQ.isEmpty()) {
			Pair cur = PQ.remove();
			int node = cur.getNode();
			
			if(vis[node]) continue;
			dis[node] = cur.getW();
			vis[node] = true;
			
			for(Integer i : map[node].keySet()) {
				if(vis[i]) continue;
				int d = map[node].get(i) + cur.getW();
				if(dis[i] > d) {
					dis[i] = d;
					PQ.add(new Pair(i, map[node].get(i) + cur.getW()));
				}
			}
		}
	}
	
	static class Pair implements Comparable<Pair> {
		int node, w;
		
		Pair(int node, int w) {
			this.node = node;
			this.w = w;
		}
		
		int getNode() { return this.node; }
		int getW() { return this.w; }
		
		public int compareTo(Pair target) { return Integer.compare(this.w, target.w); }
	}
}