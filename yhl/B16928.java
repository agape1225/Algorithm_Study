package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16928 { //뱀과 사다리 게임
	static boolean[] ladder, snake;
	static HashMap<Integer, Integer> ladder_move, snake_move;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		ladder = new boolean[101]; snake = new boolean[101];
		ladder_move = new HashMap<>(); snake_move = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken()), n2 = Integer.parseInt(st.nextToken());
			
			ladder[n1] = true;
			ladder_move.put(n1, n2);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken()), n2 = Integer.parseInt(st.nextToken());
			
			snake[n1] = true;
			snake_move.put(n1, n2);
		}
		
		boolean[] vis = new boolean[101];
		int[] dis = new int[101];
		int min = Integer.MAX_VALUE, check = 0;
		for(int i = 2; i <= 100; i++) {
			int temp = check;
			for(int j = i; j < i + 6; j++) {
				if(j > 100) break;
				
				if(vis[j]) continue;
				vis[j] = true;
				
				if(snake[j]) {
					dis[j] = Integer.MAX_VALUE;
					continue;
				}

				dis[j] = dis[temp] + 1;
				check = j;
				
				if(ladder[j]) min = Math.min(min, bfs(ladder_move.get(j)) + dis[j]);
			}
			
			i = check;
		}
		
		System.out.println(Math.min(min, dis[100]));
	}
	
	static int bfs(int num) {
		boolean[] vis = new boolean[101];
		Queue<int[]> Q = new LinkedList<>();
		
		Q.add(new int[] {num, 0});
		vis[num] = true;
		while(!Q.isEmpty()) {
			int[] cur = Q.remove();
			int spot = cur[0], count = cur[1];
			
			if(spot == 100) return count;

			for(int i = 1; i <= 6; i++) {
				int n = spot + i;
				
				if(n > 100) break;
				if(vis[n]) continue;
				vis[n] = true;
				
				if(ladder[n]) Q.add(new int[] {ladder_move.get(n), count + 1});
				else if(snake[n]) Q.add(new int[] {snake_move.get(n), count + 1});
				else Q.add(new int[] {n, count + 1});
			}
		}
		
		return Integer.MAX_VALUE;
	}
}