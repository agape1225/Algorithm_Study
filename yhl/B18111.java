package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B18111 { //마인크래프트
	private static int n, m, b;
	private static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		int maxH = -1, minH = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				maxH = Math.max(maxH, arr[i][j]);
				minH = Math.min(minH, arr[i][j]);
			}
		}
		
		int min[] = {Integer.MAX_VALUE, -1}; //min[0] = 시간, min[1] = 땅의 높이
		for(int i = minH; i <= maxH; i++) {
			int[] com = compare(i); //com[0] = 시간, com[1] = 땅의 높이
				
			if(com[0] == -1) continue;
			if(min[0] == com[0]) {
				if(min[1] < com[1]) min = Arrays.copyOf(com, 2);
			}
			else if(min[0] > com[0]) min = Arrays.copyOf(com, 2);
		}
		
		sb.append(min[0] + " " + min[1]);
		System.out.println(sb);
	}
	public static int[] compare(int h) {
		int[] ans = new int[2];
		int copyB = b; //블럭의 개수 저장
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				int curH = arr[i][j] - h;
				
				if(curH < 0) { //현재 블럭 높이보다 비교하는 높이가 더 높다. 즉, 블럭을 추가한다.
					//curH는 음수, 블럭을 수 만큼 빼주고, 시간을 수 만큼 더해준다.
					copyB += curH;
					ans[0] -= curH;
				}
				else if(curH > 0) { //현재 블럭 높이보다 비교하는 높이가 더 낮다. 즉, 블럭을 빼준다.
					//curH는 양수, 블럭을 수 만큼 더해주고, 시간을 수 만큼 *2하고 더해준다.
					copyB += curH;
					ans[0] += curH * 2;
				}
			}
		}
		if(copyB < 0) {
			ans[0] = -1;
			return ans;
		}
		ans[1] = h;
		
		return ans;
	}
}