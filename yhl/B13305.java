package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B13305 { //¡÷¿Øº“

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] length = new int[N - 1], price = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N - 1; i++) length[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) price[i] = Integer.parseInt(st.nextToken());
		
		BigInteger ans = BigInteger.ZERO;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < N - 1; i++) {
			if(price[i] < min) min = price[i];
			BigInteger m = BigInteger.valueOf(min);
			BigInteger p = BigInteger.valueOf(length[i]);
			ans = ans.add(m.multiply(p));
		}
		System.out.println(ans);
	}
}