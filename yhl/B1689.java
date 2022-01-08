package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B1689 { //°ãÄ¡´Â ¼±ºÐ

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dots = new int[N * 2][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d1 = Integer.parseInt(st.nextToken()), d2 = Integer.parseInt(st.nextToken());
			
			dots[i][0] = d1; dots[i][1] = 1;
			dots[i + N][0] = d2; dots[i + N][1] = -1;
		}
		
		Arrays.sort(dots, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
		
		int temp = 0, max = 0;
		for(int i = 0; i < 2 * N; i++) {
			temp += dots[i][1];
			max = Math.max(max, temp);
		}
		
		System.out.println(max);
	}
}