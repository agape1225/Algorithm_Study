package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class B1427 { //소트인사이드

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Character[] num = new Character[s.length()];
		for(int i = 0; i < s.length(); i++) num[i] = s.charAt(i);		
		Arrays.sort(num, Collections.reverseOrder());
		for(int i = 0; i < s.length(); i++) System.out.print(num[i]);
	}
}