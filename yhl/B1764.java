package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class B1764 { //µË∫∏¿‚

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, Boolean> map = new TreeMap<>();
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			map.put(s, false);
		}
		
		int count = 0;
		for(int i = 0; i < m; i++) {
			String s = br.readLine();
			if(map.containsKey(s)) {
				map.replace(s, true);
				count++;
			}
		}
		sb.append(count + "\n");
		
		for(String s : map.keySet()) {
			if(map.get(s)) sb.append(s + "\n");
		}
		
		System.out.println(sb);
	}
}