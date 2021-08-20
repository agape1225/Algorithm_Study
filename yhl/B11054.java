package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11054 { //가장 긴 바이토닉 부분 수열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N], down = new int[N], up = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
		
		down[N - 1] = 0; up[0] = 0;
		int max = 0;
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(num[j] < num[i] && up[j] >= up[i]) up[i] = up[j] + 1;
			}
		}
		for(int i = N - 2; i >= 0; i--) {
			for(int j = N - 1; j > i; j--) {
				if(num[j] < num[i] && down[j] >= down[i]) down[i] = down[j] + 1;
			}
			
			max = Math.max(max, up[i] + down[i]);
		}
		System.out.println(max + 1);
	}
}