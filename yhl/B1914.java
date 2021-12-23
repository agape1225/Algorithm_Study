package Practice;

import java.math.BigInteger;
import java.util.Scanner;

public class B1914 { //하노이 탑
	static int count;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N < 21) {
			hanoi(N, 1, 2, 3);
			
			System.out.println(count + "\n" + sb);
			System.out.println(count);
		}
		else {
			BigInteger ans = new BigInteger("1");
			BigInteger two = new BigInteger("2");
			
			for(int i = 0; i < N; i++) {
				ans = ans.multiply(two);
			}
			
			System.out.println(ans.subtract(new BigInteger("1")));
		}
	}
	
	static int hanoi(int k, int x, int y, int z) {
		if(k == 1) {
			sb.append(x).append(" ").append(z).append("\n");
			count++;
			return count;
		}
		
		hanoi(--k, x, z, y);
		sb.append(x).append(" ").append(z).append("\n");
		count++;
		hanoi(k, y, x, z);
		return -1;
	}
}