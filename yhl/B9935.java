package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class B9935 { //¹®ÀÚ¿­ Æø¹ß

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String bombs = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		int size = bombs.length();
		char bomb = bombs.charAt(size - 1);
		Stack<Character> ans = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			ans.push(s.charAt(i));
			if(ans.size() < size) continue;

			StringBuilder tempSb = new StringBuilder();
			if(s.charAt(i) == bomb) {
				String temp = "";
				boolean isEqual = true;
				for(int j = size - 1; j >= 0; j--) {
					char c = ans.pop();
					
					temp += c;
					
					if(bombs.charAt(j) != c) {
						isEqual = false;
						break;
					}
				}
				
				if(!isEqual) {
					tempSb.append(temp);
					while(!ans.isEmpty()) tempSb.append(ans.pop());
					sb.append(tempSb.reverse());
				}
			}
		}

		StringBuilder tempSb = new StringBuilder();
		while(!ans.isEmpty()) tempSb.append(ans.pop());
		sb.append(tempSb.reverse());
		
		if(sb.length() == 0) System.out.println("FRULA");
		else System.out.println(sb);
	}
}