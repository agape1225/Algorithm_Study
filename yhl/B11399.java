package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11399 { //ATM

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()), ans = 0;
		int P[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) P[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(P);
		
		for(int i = 0; i < N; i++) ans += P[i] * (N - i); //제일 작은 시간이 N번 .. 제일 큰 시간이 1번 나와야 최소 시간이다.
		System.out.println(ans);
	}
}