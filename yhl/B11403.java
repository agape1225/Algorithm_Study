package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11403 { //경로 찾기
	static int G;
	static int[][] map;
	static boolean[][] vis;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		G = Integer.parseInt(br.readLine());
		map = new int[G][G]; vis = new boolean[G][G];
		
		ArrayList<Integer>[] arr = new ArrayList[G];
		for(int i = 0; i < G; i++) arr[i] = new ArrayList<>();
		
		for(int i = 0; i < G; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < G; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) arr[i].add(j);
			}
		}
		
		for(int i = 0; i < G; i++) {
			Queue<Integer> Q = new LinkedList<>();
			Q.add(i);
			
			while(!Q.isEmpty()) {
				int cur = Q.remove();
				
				for(Integer j : arr[cur]) {
					if(vis[i][j]) continue;
					vis[i][j] = true;
					
					Q.add(j);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < G; i++) {
			for(int j = 0; j < G; j++) {
				if(vis[i][j]) sb.append(1);
				else sb.append(0);
				sb.append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}