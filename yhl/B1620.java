package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B1620 { //나는야 포켓몬 마스터 이다솜
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map =  new HashMap<>();
		String[] S = new String[n + 1];
		
		for(int i = 1; i <= n; i++) {
			String s = br.readLine();
			map.put(s, i);
			S[i] = s;
		}
		for(int i = 0; i < m; i++) {
			String s = br.readLine();
			int num = -1;
			boolean isNum = false;
			
			try {
				num = Integer.parseInt(s);
				isNum = true;
			} catch(NumberFormatException e) {
				
			}
			
			if(isNum) System.out.println(S[num]);
			else System.out.println(map.get(s));
		}
	}
}