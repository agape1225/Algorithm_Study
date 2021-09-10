package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B17219 { //비밀번호 찾기

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) sb.append(map.get(br.readLine())).append("\n");
		System.out.println(sb);
	}
}