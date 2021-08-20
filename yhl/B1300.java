package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1300 { //K¹øÂ° ¼ö

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		long st = 1, en = N * N, ans = 0;
		System.out.println(en);
		while(st <= en) {
			long mid = (st + en) / 2, count = 0;
			
			for(int i = 1; i <= N; i++) count += Math.min(N, mid / i);
			
			if(count < K) st = mid + 1;
			else {
				en = mid - 1;
				ans = mid;
			}
		}
		
		System.out.println(ans);
	}
}