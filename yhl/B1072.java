package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1072 { //°ÔÀÓ

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sT = new StringTokenizer(br.readLine());
		
		long X = Long.parseLong(sT.nextToken()), Y = Long.parseLong(sT.nextToken());
		long st = 0, en = X, mid, Z = 100 * Y / X, temp;
		
		if(Z >= 99 ) {
			System.out.println(-1);
			return;
		}
		
		while(true) {
			if(st + 1 == en) break;
			
			mid = (st + en) / 2;
			temp = 100 * (Y + mid) / (X + mid);
			if(temp - Z == 0) st = mid;
			else en = mid;
		}
		
		System.out.println(en);
	}
}