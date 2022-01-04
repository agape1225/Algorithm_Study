package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B11286 { //Àý´ñ°ª Èü

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Node> PQ = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				if(PQ.isEmpty()) sb.append(0);
				else sb.append(PQ.poll().origin_num);
				sb.append("\n");
			}
			else PQ.add(new Node(Math.abs(num), num));
		}
		
		System.out.println(sb);
	}

	static class Node implements Comparable<Node>{
		int origin_num, abs_num;
		
		public Node(int abs_num, int origin_num) {
			this.abs_num = abs_num;
			this.origin_num = origin_num;
		}
		
		public int compareTo(Node tar) {
			if(this.abs_num == tar.abs_num) return this.origin_num - tar.origin_num;
			
			return this.abs_num - tar.abs_num;
		}
	}
}