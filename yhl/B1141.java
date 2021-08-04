package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1141 { //Á¢µÎ»ç
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] S = new String[N];
		for(int i = 0; i < N; i++) {
			S[i] = br.readLine();
		}
		Arrays.sort(S);
		int count = N;
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				boolean equal = true;
				for(int k = 0; k < S[i].length(); k++) {
					if(S[i].charAt(k) != S[j].charAt(k)) {
						equal = false;
						break;
					}
				}
				if(equal) {
					count--;
					break;
				}
			}
		}
		System.out.println(count);
	}
}