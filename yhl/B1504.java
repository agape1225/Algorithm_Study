package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1504 { //특정한 최단 경로
	private static ArrayList<Edge>[] graph;
	private static int[] dist, dis;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int v1, v2, c; //1, 2번째 점, 거리
		dis = new int[6];
		dist = new int[N + 1];
		
		graph = new ArrayList[N + 1];
		for(int i = 0; i < N + 1; i++) graph[i] = new ArrayList<>();
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			v1 = Integer.parseInt(st.nextToken());
			v2 = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			graph[v1].add(new Edge(v2, c));
			graph[v2].add(new Edge(v1, c));
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		dis[0] = dijkstra(1, v1); dis[1] = dijkstra(1, v2); dis[2] = dijkstra(1, N);
		dis[3] = dijkstra(v1, v2); dis[4] = dijkstra(v1, N); dis[5] = dijkstra(v2, N);
		
		for(int i = 0; i < 6; i++) {
			if(dis[i] == -1) {
				System.out.println(-1);
				return;
			}
		}
		
		int ans[] = new int[3];
		ans[0] = dis[0] + Math.min(dis[3], dis[4] + dis[5]) + dis[5];
		ans[1] = dis[1] + Math.min(dis[3], dis[4] + dis[5]) + dis[4];
		ans[2] = dis[2] + dis[3] + dis[4] + dis[5];
		System.out.println(Math.min(ans[0], Math.min(ans[1], ans[2])));
	}
	
	public static int dijkstra(int st, int N) {
		if(graph[st].size() == 0 || graph[N].size() == 0) return -1;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(st, 0));
		
		Arrays.fill(dist, Integer.MAX_VALUE);		
		dist[st] = 0;
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int v = edge.v;
			
			if(v == N) return edge.weight;
			
			for(Edge next : graph[v]) {
				if(dist[next.v] >= dist[v] + next.weight) {
					dist[next.v] = dist[v] + next.weight;
					pq.add(new Edge(next.v, dist[next.v]));
				}
			}
		}
		return -1;
	}
	
	static class Edge implements Comparable<Edge>{
		int v, weight;
		
		public Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
		
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}