package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B2960 { //에라토스테네스의 체

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[] P = new boolean[N + 1];
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i = 2; i <= N; i++) {
			if(!P[i]) {
				for(int j = i; j <= N; j += i) {
					if(P[j]) continue;
					P[j] = true;
					ans.add(j);
				}
			}
		}
		
		System.out.println(ans.get(K - 1));
	}
}