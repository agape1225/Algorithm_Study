package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_2 { //문자열 압축

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		Solution_String_2 sol = new Solution_String_2();
		int ans = sol.solution(s);
		System.out.println(ans);
	}
}
class Solution_String_2 {
    public int solution(String s) {
        int max = Integer.MAX_VALUE, size = s.length() / 2 + 1; //s가 반보다 클 때는 무조건 다르다.
        
        if(size == 1) return 1;
        while(--size > 0) { //s를 1씩 감소하면서 문자열 검사
        	int count, index;
        	String temp = "";
        	
        	Loop : for(int i = 0; i < s.length(); i = index) {
        		count = 1;
        		index = i + size; //현재 인덱스
        		if(index + size > s.length()) { //다음 인덱스까지 위치가 문자열 길이보다 길면 break
        			temp += s.substring(i);
        			break;
        		}
        		
        		String t1 = s.substring(i, index);
        		String t2;
        		
        		while((index += size) <= s.length() && (t2 = s.substring(index - size, index)).equals(t1)) { //s를 현재 인덱스에서 다음 단위까지 검사 후 비교 
        			if(index == s.length()) {
        				count++;
        				temp += count + t1;
        				break Loop;
        			}
        			count++;
        		}
        		
        		if(count != 1) temp += count + t1;        		
        		else temp += t1;
        		
        		index -= size;	
        	}
        	max = Math.min(max, temp.length());
        }
        return max;
    }
}