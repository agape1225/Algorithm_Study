package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Hash_1 { //완주하지 못한 선수

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] part = new String[n];
		String[] com = new String[n - 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());		
		for(int i = 0; i < n; i++) part[i] = st.nextToken();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n - 1; i++) com[i] = st.nextToken();
	
		Solution_Hash_1 sol = new Solution_Hash_1();
		System.out.println(sol.solution(part, com));
	}
}
class Solution_Hash_1 {
    public String solution(String[] participant, String[] completion) {
        String ans = "";
    	
    	int n = participant.length;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
        	String s = participant[i];
        	
        	if(map.containsKey(s)) map.replace(s, map.get(s) + 1);
        	else map.put(s, 1);
        }
        for(int i = 0; i < n - 1; i++) {
        	String s = completion[i];
        	     	
        	if(map.get(s).equals(1)) map.remove(s);
        	else map.replace(s, map.get(s) - 1);
        }
        
        for(String key : map.keySet()) ans = key;
        return ans;
    }
}