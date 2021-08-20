package Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920 { //¼ö Ã£±â

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int A[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) A[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(A);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int min = A[0], mid = A[n / 2], max = A[n - 1];
			int minI = 0, midI = n / 2, maxI = n - 1;
			int M = Integer.parseInt(st.nextToken());
			
			while(true) {
				if(mid < M) {
					if(midI + 1 == maxI) {
						if(max == M) {
							bw.write(1 + "\n");
							break;
						}
						else {
							bw.write(0 + "\n");
							break;
						}
					}
					min = A[minI = midI]; mid = A[midI = (midI + maxI) / 2]; 
				}
				else if(mid > M) {
					if(midI - 1 == minI) {
						if(min == M) {
							bw.write(1 + "\n");
							break;
						}
						else {
							bw.write(0 + "\n");
							break;
						}
					}
					max = A[maxI = midI]; mid = A[midI = (midI + minI) / 2];
				}
				else {
					bw.write(1 + "\n");
					break;
				}
			}
			bw.flush();
		}
		bw.close();
	}
}