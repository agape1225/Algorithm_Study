package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1074_2 { //Z
	private static int r, c, ans;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		ans = 0;
		Z(N);
		
		System.out.println(ans);
	}
	
	public static void Z(int N) {
		if(N == 0) {
			if(r == 1 & c == 1) ans += 3;
			else if(r == 1) ans += 2;
			else if(c == 1) ans += 1;
			return;
		}
		
		int n = (int)Math.pow(2, N) / 2;
		int num = n * n;
		
		if(n <= r && n <= c) {
			ans += num * 3;
			r -= n;
			c -= n;
		}
		else if(n <= r) {
			ans += num * 2;
			r -= n;
		}
		else if(n <= c) {
			ans += num;
			c -= n;
		}
		
		Z(N - 1);
	}
}