package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B8911 { //거북이
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		int[] rotX = {0, 1, 0, -1}, rotY = {1, 0, -1, 0}; //회전값, index 0이 시작 회전값
		for(int i = 0; i < t; i++) {
			String s = br.readLine();
			
			int minX = 0, maxX = 0, minY = 0, maxY = 0, curX = 0, curY = 0, index = 0; //시작 위치
			for(int j = 0; j < s.length(); j++) {
				char order = s.charAt(j);
				
				if(order == 'L') {
					if(--index == -1) index = 3;
					continue;
				}
				else if(order == 'R') {
					if(++index == 4) index = 0;
					continue;
				}
				else if(order == 'F') {
					curX += rotX[index];
					curY += rotY[index];
				}
				else {
					curX -= rotX[index];
					curY -= rotY[index];
				}
				
				maxX = Math.max(curX, maxX);
				minX = Math.min(curX, minX);
				maxY = Math.max(curY, maxY);
				minY = Math.min(curY, minY);
			}
			
			sb.append((maxX - minX) * (maxY - minY)).append("\n");
		}
		
		System.out.println(sb);
	}
}