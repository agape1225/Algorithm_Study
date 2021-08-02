package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class B2012 { //등수 매기기
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N + 1];
		for(int i = 1; i <= N; i++) num[i] = Integer.parseInt(br.readLine());
		Arrays.sort(num);
		long ans = 0;
		for(int i = 1; i <= N; i++) ans += Math.abs(num[i] - i);
		System.out.println(ans);
	}
}