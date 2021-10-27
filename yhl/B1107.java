package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1107 { //리모컨
	static int N, M;
	static boolean[] b = new boolean[10];
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		if(M > 0) {
			String s = br.readLine();
			String[] index = s.split(" ");
			for(int i = 0; i < index.length; i++) b[Integer.parseInt(index[i])] = true;
		}
		if(M == 10) {
			System.out.println(Math.abs(N - 100));
			return;
		}
		
		int ans = 0;
		if(N == 100) ans = 0;
		else if(N < 100) ans = solve(0, 100);
		else ans = solve(101, N * 2 - 100);
		
		System.out.println(ans);
	}
	
	static int solve(int st, int en) {
		int res = Math.abs(N - 100);
		
		for(int i = st; i < en; i++) {
			int len = i, temp = 0; //len : 채널 자리스, temp : 숫자 누른 횟수
			boolean move = true;
			
			if(len == 0) {
				//채널 0으로 이동하고 원하는 채널로 이동한다.
				if(!b[len]) res = Math.min(res, Math.abs(N - i) + 1);
				continue;
			}
			
			while(len > 0) { //숫자를 눌러서 채널을 이동한다.
				int num = len % 10; //누룰 숫자
				len /= 10;
				temp++;
				
				if(b[num]) {
					move = false;
					break;
				}
			}
			
			if(move) { //채널 이동 후 +/-를 눌러서 원하는 채널로 이동한다.
				temp += Math.abs(N - i);
				res = Math.min(res, temp);
				//System.out.println("i : " + i + " temp : " + temp);
			}
		}
		
		return res;
	}
}
