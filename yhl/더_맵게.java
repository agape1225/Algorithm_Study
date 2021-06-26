package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ´õ_¸Ê°Ô {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int num[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		
		Solution_´õ_¸Ê°Ô sol = new Solution_´õ_¸Ê°Ô();
		System.out.println(sol.solution(num, K));
	}
}

class Solution_´õ_¸Ê°Ô {
	public int solution(int[] num, int K) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int count = 0;
		
		for(int i = 0; i < num.length; i++) {
			if(map.containsKey(num[i])) map.put(num[i], map.get(num[i]) + 1);
			else map.put(num[i], 1);
		}
		
		while(map.firstKey() < K) {
			if(map.size() < 2) {
				if(map.get(map.firstKey()) < 2) return -1;
			}
			
			int temp;
			int n1 = map.firstKey();
			if((temp = map.get(n1)) > 1) map.put(n1, temp - 1);
			else map.remove(n1);
			int n2 = map.firstKey();
			if((temp = map.get(n2)) > 1) map.put(n2, temp - 1);
			else map.remove(n2);
			
			int n3 = n1 + n2 * 2;
			if(map.containsKey(n3)) map.put(n3, map.get(n3) + 1);
			else map.put(n3, 1);
			count++;
		}
		
		return count;
	}
}