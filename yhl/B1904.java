package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1904 { //01≈∏¿œ

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] b = new int[N + 1];
		
		b[0] = 1; b[1] = 2;
		for(int i = 2; i < N; i++) b[i] = (b[i - 2] + b[i - 1]) % 15746;
		System.out.println(b[N - 1]);
	}

}
