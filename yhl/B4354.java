package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B4354 { //¹®ÀÚ¿­ Á¦°ö
	static String s;
	static int[] pi;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		s = br.readLine();
		
		while(s.charAt(0) != '.') {
			int size = s.length();
			pi = new int[size];
			make_pi(size);
			
			int temp = 0, count = 1;
			for(int i = 1; i < size - 1; i++) {
				if(pi[i] != pi[temp] + 1) {
					if(pi[i] == 0) count = i + 1;
					else count = temp + 1;
				}
				temp = i;
			}
			
			if(pi[size - 1] % count != 0) sb.append(1).append("\n");
			else sb.append(pi[size - 1] / count + 1).append("\n");
			
			s = br.readLine();
		}
		
		System.out.println(sb);
	}

	static void make_pi(int size) {
		for(int i = 1, j = 0; i < size; i++) {
			while(j > 0 && s.charAt(i) != s.charAt(j)) j = pi[j - 1];
			if(s.charAt(i) == s.charAt(j)) pi[i] = ++j;
		}
	}
}
