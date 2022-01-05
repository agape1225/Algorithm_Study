package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B9019 { //DSLR

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			int ini = Integer.parseInt(st.nextToken()), res = Integer.parseInt(st.nextToken());
			
			boolean[] vis = new boolean[10001];
			Queue<Node> Q = new LinkedList<>();
			
			Q.add(new Node(ini, ""));
			vis[ini] = true;
			
			while(!Q.isEmpty()) {
				Node cur = Q.remove();
				int num = cur.num;
				String R = cur.R;
				
				if(num == res) {
					sb.append(R);
					break;
				}
				
				int n = (num % 1000) * 10 + num / 1000;
				if(!vis[n]) {
					Q.add(new Node(n, R + "L"));
					vis[n] = true;
				}
				
				n = (num % 10) * 1000 + num / 10;
				if(!vis[n]) {
					Q.add(new Node(n, R + "R"));
					vis[n] = true;
				}
				
				n = num == 0 ? 9999 : num - 1;
				if(!vis[n]) {
					Q.add(new Node(n, R + "S"));
					vis[n] = true;
				}

				n = num * 2 % 10000;
				if(!vis[n]) {
					Q.add(new Node(n, R + "D"));
					vis[n] = true;
				}
			}
			
			System.out.println(sb);
		}	
	}
	
	static class Node {
		int num;
		String R = "";
		
		public Node(int num, String R) {
			this.num = num;
			this.R = R;
		}
	}
}