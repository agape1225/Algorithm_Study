package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B6064 { //카잉 달력

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		Loop : while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			boolean bigM = false;
			int a = 0, b = 0, c = 0; //b는 최대공약수, c는 최소공배수
			
			if(M >= N) {
				bigM = true;
				a = M; b = N;
			}
			else {
				bigM = false;
				a = N; b = M;
			}
			
			while(a % b != 0) {
				int temp = b;
				b = a % b;
				a = temp;
			}
			c = M * N / b;
			
			if(bigM) {
				if(X == M) X = 0;
				
				int temp = Y;
				while(temp <= c) {
					if(temp % M == X) {
						System.out.println(temp);
						continue Loop;
					}
					temp += N;
				}
				
				System.out.println(-1);
			}
			else {
				if(Y == N) Y = 0;
				
				int temp = X;
				while(temp <= c) {
					if(temp % N == Y) {
						System.out.println(temp);
						continue Loop;
					}
					temp += M;
				}
				
				System.out.println(-1);
			}
		}
	}
}