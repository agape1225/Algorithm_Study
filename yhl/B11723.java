package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11723 { //����

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean[] S = new boolean[21]; //0��° index�� true�� all
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			String s = br.readLine();
			int x = 0;
			
			/*  ������ ��� �κп��� ���� �ð��� ��� �� �ϴ�.
			 * try { x = Integer.parseInt(s.substring(s.indexOf(' ') + 1)); }
			 * catch(NumberFormatException e) {
			 * 
			 * }
			 */
			
			if(s.charAt(0) == 'a') {
				if(s.charAt(1) == 'd') {
					for(int j = 4 ; j < s.length(); j++) {
						x = x * 10 + s.charAt(j) - '0';
					}
					S[x] = true;
				}
				else if(s.charAt(1) == 'l') {
					Arrays.fill(S, false);
					S[0] = true;
				}
			}
			else if(s.charAt(0) == 'r') {
				for(int j = 7 ; j < s.length(); j++) {
					x = x * 10 + s.charAt(j) - '0';
				}
				S[0] = false;
				S[x] = false;
			}
			else if(s.charAt(0) == 'c') {
				for(int j = 6 ; j < s.length(); j++) {
					x = x * 10 + s.charAt(j) - '0';
				}
				if(S[x] || S[0]) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}
			else if(s.charAt(0) == 't') {
				for(int j = 7 ; j < s.length(); j++) {
					x = x * 10 + s.charAt(j) - '0';
				}
				if(S[0]) {
					S[0] = false;
					S[x] = true;
				}
				S[x] = !S[x];
			}
			else if(s.charAt(0) == 'e') S[0] = false;
		}
		
		System.out.println(sb);
	}
}