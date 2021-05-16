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
        	
        	for(int i = 0; i < s.length(); i = index) {
        		count = 1;
        		index = i + size; //검사할 현재 문자열의 끝
        		if(index + size > s.length()) { //검사할 다음 인덱스의 위치들이 문자열 크기보다 크면 남은 문자열 더해준 뒤 break
        			temp += s.substring(i);
        			break;
        		}
        		
        		String t1 = s.substring(i, index); //검사할 현재 문자열
        		String t2; //검사할 다음 문자열
        		
        		//s를 현재 인덱스에서 다음 단위까지 검사 후 비교, 다음 문자열과 다를 때 반복문 끝남, index의 위치는 다음 문자열의 끝
        		while((index += size) <= s.length() && (t2 = s.substring(index - size, index)).equals(t1)) count++;
        		
        		if(count != 1) temp += count + t1; //중복된 것이 있으면 개수 + 문자열, 없으면 + 문자열
        		else temp += t1;
        		
        		index -= size; //현재 문자열과 다음 문자열이 다르기 때문에 다음 문자열의 시작 위치로 index 이동
        	}
        	max = Math.min(max, temp.length());
        }
        return max;
    }
}