package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TargetNumber{

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Integer> num = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) num.add(Integer.parseInt(st.nextToken()));
		
		int[] numbers = new int[num.size()];
		int size = 0;
		for(int a : num) numbers[size++] = a;
		
		int target = Integer.parseInt(br.readLine());
		Solution_TargetNumber sol = new Solution_TargetNumber();		
		int ans = sol.solution(numbers, target);
		
		System.out.println(ans);
	}
}
class Solution_TargetNumber {
    public int solution(int[] numbers, int target) {
    	int answer = 0, size = numbers.length;
    	
    	Queue<Pair_TargetNumber> Q = new LinkedList<>();
    	int num = numbers[0];
    	Q.add(new Pair_TargetNumber(num, 1));
    	Q.add(new Pair_TargetNumber(-num, 1));     
	        
    	while(!Q.isEmpty()) {
	        Pair_TargetNumber cur = Q.remove();
	        int ans = cur.getAns();
	        int count = cur.getCount();
	        		
			if(count == size) {
				if(ans == target) answer++;
			    continue;
			}
			
			Q.add(new Pair_TargetNumber(ans + numbers[count], count + 1));
			Q.add(new Pair_TargetNumber(ans - numbers[count], count + 1));
    	}
	  	
    	return answer;
    }
}
class Pair_TargetNumber{
	int ans, count;
	
	public Pair_TargetNumber(int ans, int count) {
		this.ans = ans;
		this.count = count;
	}
	public int getAns() {return ans;}
	public int getCount() {return count;}
	
}