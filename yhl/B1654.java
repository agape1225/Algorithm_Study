package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1654 { //랜선 자르기

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken()); //k <= n
		
		long temp = 0;
		int[] lines = new int[k];
		for(int i = 0; i < k; i++) {
			int line = Integer.parseInt(br.readLine()); // 랜선 한 개
			lines[i] = line;
			temp = Math.max(line, temp);
		}
		
		int count = 0;
		long low = 1, mid = 0, high = temp; //랜선의 길이, 길수록 랜선의 개수가 적어진다.
		while(low < high) {
			mid = (high + low) / 2;
			count = 0; //만든 랜선 개수
			for(int i = 0; i < k; i++) count += lines[i] / mid;
			
			if(count >= n) low = mid + 1; //만든 랜선의 개수가 n보다 크거나 같을 때, 랜선의 길이를 늘린다.
			else high = mid; //만든 랜선의 개수가 n보다 작을 때, 랜선의 길이를 줄인다.
		}
		System.out.println("low:" + low + " mid:" + mid + " high:" + high + " count:" + count);
		count = 0;
		for(int i = 0; i < k; i++) count += lines[i] / low;
		
		if(count >= n) System.out.println(low);
		else System.out.println(low - 1);
	}
}