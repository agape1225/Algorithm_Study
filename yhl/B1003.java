package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1003 { //피보나치 함수
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] fibZero = new int[41], fibOne = new int[41];
		fibZero[0] = 1; fibZero[1] = 0; fibOne[0] = 0; fibOne[1] = 1;
		for(int i = 2; i <= 40; i++) {
			fibZero[i] = fibZero[i - 2] + fibZero[i - 1];
			fibOne[i] = fibOne[i - 2] + fibOne[i - 1];
		}
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			System.out.println(fibZero[num] + " " + fibOne[num]);
		}
	}
}