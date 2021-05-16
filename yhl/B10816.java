package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10816 { //숫자 카드 2

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			int min = 0, mid = n / 2, max = n - 1;
			int count = 0;
			
			while(min <= max) {
				if(arr[mid] > num) {
					max = mid - 1;
					mid = (max + min) / 2;
				}
				else if(arr[mid] < num) {
					min = mid + 1;
					mid = (max + min) / 2;
				}
				else {
					count++;
					for(int j = mid - 1; j >= 0; j--) {
						if(arr[j] != num) break;
						count++;
					}
					for(int j = mid + 1; j < n; j++) {
						if(arr[j] != num) break;
						count++;
					}
					break;
				}
			}
			
			sb.append(count).append(" ");
		}
		
// 배열에 하나씩 더해줌으로써 카운트를 구현
//		int[] countA = new int[20000001];
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for(int i = 0; i < n; i++) countA[Integer.parseInt(st.nextToken()) + 10000000]++;
//		
//		int m = Integer.parseInt(br.readLine());
//		st = new StringTokenizer(br.readLine());
//		for(int i = 0; i < m; i++) sb.append(countA[Integer.parseInt(st.nextToken()) + 10000000] + " ");
		
		System.out.println(sb);
	}
}