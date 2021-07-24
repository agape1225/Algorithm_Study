package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ã¼À°º¹ {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int size = st.countTokens();
		int[] lost = new int[size];
		for(int i = 0; i < size; i++) lost[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		size = st.countTokens();
		int[] reserve = new int[size];
		for(int i = 0; i < size; i++) reserve[i] = Integer.parseInt(st.nextToken());
		
		Solution_Ã¼À°º¹ sol = new Solution_Ã¼À°º¹();
		System.out.println(sol.solution(N, lost, reserve));
	}

}
class Solution_Ã¼À°º¹ {
	int[] has;
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        has = new int[n + 2];
        
        for(int i = 0; i < reserve.length; i++) has[reserve[i]]++;       
        for(int i = 0; i < lost.length; i++) has[lost[i]]--;        
        for(int i = 1; i <= n; i++) {
            if(has[i] >= 0) answer++;
            else {
            	if(has[i - 1] == 1) {
            		has[i - 1] = has[i] = 0;
            		answer++;
            	}
            	else if(has[i + 1] == 1) {
            		has[i + 1] = has[i] = 0;
            		answer++;
            	}
            }
        }
        
        return answer;
    }
}
/* //¿À´ä lost = {5, 6, 7}, reserve = {6, 7, 8} ÀÏ ¶§ Á¤´ä : 7, Ãâ·Â°ª : 8
class Solution_Ã¼À°º¹ {
	int[] has;
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        has = new int[n + 2];
        
        for(int i = 0; i < reserve.length; i++) has[reserve[i]]++;       
        for(int i = 0; i < lost.length; i++) {
        	int s = lost[i];
        	has[s]--;
        	if(has[s] == 0) continue;
        	if(has[s - 1] == 1) {
        		has[s - 1] = has[s] = 0;
        	}
        	else if(has[s + 1] == 1) {
        		has[s + 1] = has[s] = 0;
        	}
        }
        for(int i = 1; i <= n; i++) {
            if(has[i] >= 0) answer++;
        }
        
        return answer;
    }
}
*/