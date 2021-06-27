package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class B7662 { //이중 우선순위 큐
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			TreeMap<Integer, Integer> map = new TreeMap<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				
				char c = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				
				if(c == 'I') {
					if(map.containsKey(num)) map.put(num, map.get(num) + 1);
					else map.put(num, 1);
				}
				else if(c == 'D' && map.size() > 0) {
					if(num == 1) {
						int temp = map.lastKey();
						if(map.get(temp) > 1) map.put(temp, map.get(temp) - 1);
						else map.remove(temp);
					}
					else if(num == -1) {
						int temp = map.firstKey();
						if(map.get(temp) > 1) map.put(temp, map.get(temp) - 1);
						else map.remove(temp);
					}
				}
			}
			
			if(map.size() == 0) System.out.println("EMPTY");
			else System.out.println(map.lastKey() + " " + map.firstKey());
		}
	}
}