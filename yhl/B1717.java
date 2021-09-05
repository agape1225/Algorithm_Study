package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717 { //집합의 표현
	static int[] rank, root;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		rank = new int[N + 1]; root = new int[N + 1];
		for(int i = 0; i <= N; i++) {
			rank[i] = 0;
			root[i] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()), a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			
			if(u == 0) union(a, b);
			else sb.append(union_find(a, b)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int find(int x) {
		if(root[x] == x) return x;
		return root[x] = find(root[x]);
	}
	
	static void union(int x, int y) {
		x = find(x); y = find(y);
		
		if(x == y) return;
		
		if(rank[x] < rank[y]) root[x] = y;
		else {
			root[y] = x;
			
			if(rank[x] == rank[y]) rank[x]++;
		}
	}
	
	static String union_find(int x, int y) {
		x = find(x); y = find(y);
		
		if(x == y) return "YES";
		else return "NO";
	}
}