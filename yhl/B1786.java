package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1786 { //Ã£±â
	static int pi[];
	static String T, P;
	static int sizeT, sizeP;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = br.readLine();
		P = br.readLine();
		
		sizeT = T.length(); sizeP = P.length();
		pi = new int[sizeP];
		make_pi();
		System.out.println(KMP());
		System.out.println(sb);
	}

	static void make_pi() {
		for(int i = 1, j = 0; i < sizeP; i++) {
			while(j > 0 && P.charAt(i) != P.charAt(j)) j = pi[j - 1];
			if(P.charAt(i) == P.charAt(j)) pi[i] = ++j;
		}
	}
	
	static int KMP() {
		int res = 0;
		
		for(int i = 0, j = 0; i < sizeT; i++) {
			while(j > 0 && T.charAt(i) != P.charAt(j)) j = pi[j - 1];
			if(T.charAt(i) == P.charAt(j)) {
				if(j == sizeP - 1) {
					res++;
					j = pi[j];
					sb.append(i - sizeP + 2).append(" ");
				}
				else j++;
			}
		}
		
		return res;
	}
}