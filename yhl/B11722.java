package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11722 { //가장 긴 감소하는 부분 수열
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
		
		int[] count = new int[N];
		int max = 0;
		count[0] = 0;
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(num[j] > num[i] && count[j] >= count[i]) count[i] = count[j] + 1;
			}
			max = Math.max(count[i], max);
		}
		System.out.println(max + 1);
	}
}