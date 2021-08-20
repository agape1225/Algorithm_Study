package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1082 { //방 번호
	static String[] room, l; //room : 제일 큰 방번호, l : 방번호에 붙일 수 있는 제일 긴 문자열
	static boolean[] vis;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] P = new int[N]; //숫자들 가격
		for(int i = 0; i < N; i++) P[i] = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine()); //가지고 있는 돈
		room = new String[51]; l = new String[51];
		vis = new boolean[51];
		int index = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			room[P[i]] = Integer.toString(i);
			l[P[i]] = Integer.toString(i);
			vis[P[i]] = true;
			index = Math.min(index, P[i]);
		}
		
		for(int i = index + 1; i <= M ; i++) {
			String max = "0", max_len = "0";
			for(int j = 0; j < N; j++) {
				if(i < P[j]) continue;
				
				String s = Integer.toString(j), len = Integer.toString(j);
				if(i > P[j] && vis[i - P[j]]) {
					s += l[i - P[j]];
					len += l[i - P[j]];
				}
				
				if(s.length() > max.length() && s.charAt(0) != '0') max = s;
				else if(s.length() == max.length() && s.compareTo(max) > 0) max = s;
			
				if(len.length() > max_len.length()) max_len = len;
				else if(len.length() == max_len.length() && len.compareTo(max_len) > 0) max_len = len;
			}
			room[i] = max;
			l[i] = max_len;
			vis[i] = true;
			//System.out.println("M : " + i + " room : " + max + " l : " + max_len);
		}
		System.out.println(room[M]);
	}
}