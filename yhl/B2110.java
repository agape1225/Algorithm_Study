package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2110 { //공유기 설치

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sT = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(sT.nextToken());
		int C = Integer.parseInt(sT.nextToken());
		int[] home = new int[N];
		for(int i = 0; i < N; i++) home[i] = Integer.parseInt(br.readLine());
		Arrays.sort(home);
		
		int st = 1, en = home[N - 1] - home[0], ans = 0;
		while(st <= en) {
			int d = 0, fir = home[0], count = 1, mid = (st + en) / 2;
			for(int i = 1; i < N; i++) {
				d = home[i] - fir;
				if(mid <= d) {
					fir = home[i];
					count++;
				}
			}
			
			if(count >= C) {
				st = mid + 1;
				ans = mid;
			}
			else en = mid - 1;
			
		}
		
		System.out.println(ans);
	}
}