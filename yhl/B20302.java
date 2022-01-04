package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20302 { //민트 초코
	static int[][] arr = new int[100001][2]; //에라토스테네스의 체 결과 저장, 0은 소수, 1은 몫
	static int[] num = new int[100001]; //음수면 유리수, 나머지는 정수
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //필요 없음
		
		//에라토스테네스의 체
		boolean[] vis = new boolean[100001];
		for(int i = 2; i < 100001; i++) {
			if(vis[i]) continue;
			
			for(int j = i; j < 100001; j += i) {
				if(vis[j]) continue;
				
				arr[j][0] = i;
				arr[j][1] = j / i;
				vis[j] = true;
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Math.abs(Integer.parseInt(st.nextToken()));
		if(n == 0) {
			System.out.println("mint chocolate");
			return;
		}
		else if(n != 1) solve(n, true);
		
		boolean isMul = false;
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			
			if(s.charAt(0) == '*') isMul = true;
			else if(s.charAt(0) == '/') isMul = false;
			else {
				n = Math.abs(Integer.parseInt(s));
				if(n == 1) continue;
				else if(n == 0) {
					System.out.println("mint chocolate");
					return;
				}
				
				solve(n, isMul);
			}
		}
		
		for(int i = 2; i < 100001; i++) {
			if(num[i] < 0) {
				System.out.println("toothpaste");
				return;
			}
		}
		
		System.out.println("mint chocolate");
	}
	
	static void solve(int n, boolean isMul) {
		if(isMul) num[arr[n][0]]++;
		else num[arr[n][0]]--;
		
		if(arr[n][1] == 1) return;
		
		solve(arr[n][1], isMul);
	}
}