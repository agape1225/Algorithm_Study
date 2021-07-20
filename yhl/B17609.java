package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17609 { //회문
	private static String s;
	private static StringBuilder sb;
	private static boolean similar, del;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			s = br.readLine();
			
			int index = 0, lastIndex = s.length() - 1;
			
			similar = del = false;
			solve(index, lastIndex);
			
			if(!del) sb.append(0).append("\n");
			else if(similar) sb.append(1).append("\n"); 
			else sb.append(2).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void solve(int index, int lastIndex) {
		while(index < lastIndex) {
			char p1 = s.charAt(index), p2 = s.charAt(lastIndex);
			
			if(p1 != p2) {
				if(!del) {
					del = true;
					solve(index + 1, lastIndex);
					solve(index, lastIndex - 1);
					return;
				}
				else return;
			}
			
			index++; lastIndex--;
		}
		
		//여기까지 온 것은 다른 문자 없이 모든 문자열을 탐색했다는 의미. 즉, 회문이다.
		similar = true;
	}
}