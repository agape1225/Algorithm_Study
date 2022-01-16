package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17298 { //오큰수

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] arr = new int[N + 1][2];
		arr[0][0] = -1; arr[0][1] = 0;
		for(int i = 1; i <= N; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = 0;
		}
		
		//arr[i][0]은 입력 받은 숫자가 입력되어 있다.
		//arr[i][1]은 더 큰 숫자를 찾을 때까지 비교할 index가 들어있다.
		for(int i = N - 1; i > 0; i--) {
			int j = i + 1;
			
			while(arr[i][0] >= arr[j][0]) {
				if(arr[j][1] == 0) {
					j = 0;
					break;
				}
				
				j = arr[j][1];
			}
			
			arr[i][1] = j;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) sb.append(arr[arr[i][1]][0]).append(" ");
		System.out.println(sb);
	}
}