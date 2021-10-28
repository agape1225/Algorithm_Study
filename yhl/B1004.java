package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1004 { //어린 왕자

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] x = new int[2], y = new int[2];
			
			for(int i = 0; i < 2; i++) {
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			//출발점이나 도착점 둘 중 하나가 원 안에 있으면 무조건 원 안에 들어가야 한다.
			//즉, 출발점이나 도착점 중 하나와 원의 중심과의 거리가 반지름보다 작으면 count++를 한다.
			int count = 0, N = Integer.parseInt(br.readLine());
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				int c1 = Integer.parseInt(st.nextToken());
				int c2 = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
			
				boolean in = false;
				int[] temp = new int[2]; //0은 출발점, 1은 도착점, temp는 원의 중심과의 거리
				for(int j = 0; j < 2; j++) {
					temp[j] = (int)(Math.pow(x[j] - c1, 2) + Math.pow(y[j] - c2, 2));
					if(temp[j] < r * r) in = !in; // 출발점과 도착점이 모두 원 안에 있으면 count++하지 않는다.
				}
				
				if(in) count++;
			}
			
			sb.append(count).append("\n");
		}
		
		System.out.println(sb);
	}
}