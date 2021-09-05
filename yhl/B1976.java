package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1976 { //여행 가자
	static int[] root, rank;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
		root = new int[N + 1]; rank = new int[N + 1];
		for(int i = 1; i <= N; i++) root[i] = i;
		for(int i = 1; i <= N; i++) {
			String[] c = br.readLine().split(" ");
			
			for(int j = 0; j < N; j++) {
				if(Integer.parseInt(c[j]) == 1) union(i, j + 1);
			}
		}
		
		String[] s = br.readLine().split(" ");
		int r = find(Integer.parseInt(s[0]));
		for(int i = 1; i < M; i++) {
			if(r != find(Integer.parseInt(s[i]))) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
	}
	
	static int find(int x) {
		if(x == root[x]) return x;
		
		return x = find(root[x]);
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
}