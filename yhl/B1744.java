package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1744 { //수 묶기

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int count = 0;
		for(int i = 0; i < N; i++) {
			int d = Integer.parseInt(br.readLine());
			if(d <= 0) count++; //음수와 0의 개수 확인한다.
			num[i] = d;
		}
		Arrays.sort(num);
		
		long ans = 0;
		int i = 0;
		boolean odd = false;
		
		if(count % 2 != 0) { //음수와 0의 개수가 홀수면 한개를 뺀다.
			count--;
			odd = true;
		}
		
		//음수와 0 계산, 0은 양수와 곱하면 결과값이 작아지고 음수와 곱하면 결과값이 커진다.
		while(i < count) ans += num[i++] * num[i++]; //음수는 곱하면 커지고, 더하면 작아진다.
		if(odd) ans += num[i++]; //홀수일 때는 마지막 남은 음수나 0을 더한다.
		
		//양수 계산
		while(i < N && num[i] == 1) ans += num[i++]; //1은 더하는게 더 크다.
		for(int j = N - 1; j >= i;) {
			if(j == i) { //마지막에 남은 수가 하나면 더한다.
				ans += num[j];
				break;
			}
			ans += num[j--] * num[j--]; //양수는 곱하면 더 커진다.
		}
		System.out.println(ans);
	}
}