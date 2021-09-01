package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1043 { //거짓말

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int P = Integer.parseInt(st.nextToken());
		int[] know = new int[P];
		for(int i = 0; i < P; i++) know[i] = Integer.parseInt(st.nextToken()); //아는 사람들
	
		ArrayList<ArrayList<Integer>> people = new ArrayList<>(); //사람들이 들어갈 파티를 넣는다.
		for(int i = 0; i <= N; i++) people.add(new ArrayList<>());
		
		ArrayList<ArrayList<Integer>> party = new ArrayList<>(); //파티에 누가 있는지 넣어준다.
		for(int i = 0; i < M; i++) {
			party.add(new ArrayList<>());
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			for(int j = 0; j < n; j++) {
				int person = Integer.parseInt(st.nextToken());
				people.get(person).add(i); //사람이 i번째 파티에 들어간다.
				party.get(i).add(person); //i번째 파티에 사람을 넣는다.
			}
		}
		
		boolean[] truth = new boolean[M], vis = new boolean[N + 1];
		Queue<Integer> Q = new LinkedList<>();
		for(int i = 0; i < P; i++) Q.add(know[i]); //알고 있는 사람을 넣어준다.
		
		int ans = M;
		while(!Q.isEmpty()) {
			int cur = Q.remove();
			
			for(Integer a : people.get(cur)) { //진실을 아는 사람이 속해있는 파티를 구해서
				if(truth[a]) continue; //해당 파티에 이미 방문했다면 넘어가고,
				truth[a] = true; //아니면 그 파티에 거짓말을 못하도록 한다.
				ans--;
				
				for(Integer b : party.get(a)) { //파티에 있는 사람들을 알아낸다.
					if(vis[b]) continue; //이미 해결한 사람이면 넘어간다.
					vis[b] = true; //아니면 그 사람이 있는 파티가 어딘지 확인하기 위해 큐에 넣고 방문했음을 알린다.
					
					Q.add(b);
				}
			}
		}
		
		System.out.println(ans);
	}
}