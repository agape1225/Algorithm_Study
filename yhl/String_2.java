package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_2 { //���ڿ� ����

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
        int max = Integer.MAX_VALUE, size = s.length() / 2 + 1; //s�� �ݺ��� Ŭ ���� ������ �ٸ���.
        
        if(size == 1) return 1;
        while(--size > 0) { //s�� 1�� �����ϸ鼭 ���ڿ� �˻�
        	int count, index;
        	String temp = "";
        	
        	Loop : for(int i = 0; i < s.length(); i = index) {
        		count = 1;
        		index = i + size; //���� �ε���
        		if(index + size > s.length()) { //���� �ε������� ��ġ�� ���ڿ� ���̺��� ��� break
        			temp += s.substring(i);
        			break;
        		}
        		
        		String t1 = s.substring(i, index);
        		String t2;
        		
        		while((index += size) <= s.length() && (t2 = s.substring(index - size, index)).equals(t1)) { //s�� ���� �ε������� ���� �������� �˻� �� �� 
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