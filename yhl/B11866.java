package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11866 { //요세푸스 문제 0

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> Q = new LinkedList<>();
		for(int i = 1; i <= n; i++) Q.add(i);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<");
		while(Q.size() > 1) {
			for(int i = 1; i < k; i++) Q.add(Q.remove());
			sb.append(Q.remove() + ", ");
		}
		sb.append(Q.remove() + ">");
	
		System.out.println(sb);
	}
}