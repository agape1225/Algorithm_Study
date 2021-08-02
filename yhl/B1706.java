package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1706 { //크로스워드
	static ArrayList<String> arr = new ArrayList<String>();
	static boolean[][][] vis; //0이 가로, 1이 세로
	static char[][] word;
	static int N, M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		word = new char[N][M]; vis = new boolean[N][M][2];
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) word[i][j] = s.charAt(j); 
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(word[i][j] == '#') continue;
				if(!vis[i][j][0]) col(i, j);
				if(!vis[i][j][1]) row(i, j);
			}
		}
		
		Collections.sort(arr);
		System.out.println(arr.get(0));
	}
	static void col(int r, int c) {
		String s = "" + word[r][c];
		vis[r][c][0] = true;
		boolean count = false;
		for(int i = c + 1; i < M; i++) {
			if(i >= M || word[r][i] == '#') break;
			
			count = true;
			s += word[r][i];
			vis[r][i][0] = true;
		}
		
		if(count) arr.add(s);
	}
	static void row(int r, int c) {
		String s = "" + word[r][c];
		vis[r][c][1] = true;
		boolean count = false;
		for(int i = r + 1; i < N; i++) {
			if(i >= N || word[i][c] == '#') break;
			
			count = true;
			s += word[i][c];
			vis[i][c][1] = true;
		}
		
		if(count) arr.add(s);
	}
}