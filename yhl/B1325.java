package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1325 { //ȿ������ ��ŷ
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
		
		//�ڽ��� �θ� �ŷ��Ѵ�. �θ� ��ŷ ���ϸ� �ڽı��� ��ŷ ���Ѵ�.
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