package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1931 { //회의실 배정
	private static int[][] room, temp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		room = new int[N][2];
		temp = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			room[i][0] = Integer.parseInt(st.nextToken());
			room[i][1] = Integer.parseInt(st.nextToken());
		}
		
		merge_sort(0, N - 1); //정렬, 숫자가 같다면 두번째 인덱스 크기가 더 작은 것이 앞에 온다.
		
		int count = 1, t1 = room[0][0], t2 = room[0][1]; //t1은 시작 시간, t2는 종료 시간
		
		for(int i = 1; i < N; i++) {
			if(t1 == room[i][0] && t1 != t2) continue; // 방 시작 시간이 같으면 사용할 수 없다. 단, 시작 시간과 종료 시간이 같을 경우는 사용할 수 있다.
			
			if(t2 <= room[i][0]) { //이전의 종료 시간이 현재의 시작 시간보다 작거나 같으면 사용할 수 있다.
				count++;
				t1 = room[i][0]; t2 = room[i][1];
				continue;
			}
			if(t2 >= room[i][1]) { //이전의 종료 시간이 현재의 종료 시간보다 크거나 같으면 현재 시간으로 바꾼다. 사용할 수 있는 최대 개수가 더 많아진다.
				t1 = room[i][0]; t2 = room[i][1];
			}
		}
		
		System.out.println(count);
	}
	
	public static void merge_sort(int st, int en) {
		if(st < en) {
			int mid = (st + en) / 2;
			
			merge_sort(st, mid);
			merge_sort(mid + 1, en);
		
			int firArr = st, secArr = mid + 1;
			for(int i = st; i <= en; i++) {
				if(firArr > mid) temp[i] = room[secArr++];
				else if(secArr > en) temp[i] = room[firArr++];
				else if(room[firArr][0] < room[secArr][0]) temp[i] = room[firArr++];
				else if(room[firArr][0] == room[secArr][0]) {
					if(room[firArr][1] <= room[secArr][1]) temp[i] = room[firArr++];
					else temp[i] = room[secArr++];
				}
				else temp[i] = room[secArr++];
			}
			
			for(int i = st; i <= en; i++) room[i] = temp[i];
		}
	}
}