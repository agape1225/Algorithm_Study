package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B17626 { //Four Squares

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[50001];
		Arrays.fill(num, 4);
		num[1] = 1; num[2] = 2; num[3] = 3;
		
		for(int i = 4; i <= N; i++) {
			if((int)Math.sqrt(i) * Math.sqrt(i) == i) {
				num[i] = 1;
				continue;
			}
			for(int j = 1; j * j < i; j++) {
				int a = num[i - j * j] + 1;
				if(num[i] > a) num[i] = a;
			}
		}
		
		System.out.println(num[N]);
	}
}