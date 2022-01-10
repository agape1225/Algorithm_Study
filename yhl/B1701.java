package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1701 { //Cubeditor
	static String src;
	static int[] pi;
	static int size, check;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int res = 0;
		check = 0;
		while(true) {
			src = s.substring(check);
			size = src.length();
			
			if(size == 1) break;
			
			pi = new int[size];
			res = Math.max(res, make_pi());
			check++;
		}
		
		System.out.println(res);
	}
	
	static int make_pi() {
		int max = 0;
		
		for(int i = 1, j = 0; i < size; i++) {
			while(j > 0 && src.charAt(i) != src.charAt(j)) j = pi[j - 1];
			if(src.charAt(i) == src.charAt(j)) pi[i] = ++j;
			
			max = Math.max(max, pi[i]);
		}
		
		return max;
	}
}