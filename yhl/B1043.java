package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1043 { //������

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int P = Integer.parseInt(st.nextToken());
		int[] know = new int[P];
		for(int i = 0; i < P; i++) know[i] = Integer.parseInt(st.nextToken()); //�ƴ� �����
	
		ArrayList<ArrayList<Integer>> people = new ArrayList<>(); //������� �� ��Ƽ�� �ִ´�.
		for(int i = 0; i <= N; i++) people.add(new ArrayList<>());
		
		ArrayList<ArrayList<Integer>> party = new ArrayList<>(); //��Ƽ�� ���� �ִ��� �־��ش�.
		for(int i = 0; i < M; i++) {
			party.add(new ArrayList<>());
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			for(int j = 0; j < n; j++) {
				int person = Integer.parseInt(st.nextToken());
				people.get(person).add(i); //����� i��° ��Ƽ�� ����.
				party.get(i).add(person); //i��° ��Ƽ�� ����� �ִ´�.
			}
		}
		
		boolean[] truth = new boolean[M], vis = new boolean[N + 1];
		Queue<Integer> Q = new LinkedList<>();
		for(int i = 0; i < P; i++) Q.add(know[i]); //�˰� �ִ� ����� �־��ش�.
		
		int ans = M;
		while(!Q.isEmpty()) {
			int cur = Q.remove();
			
			for(Integer a : people.get(cur)) { //������ �ƴ� ����� �����ִ� ��Ƽ�� ���ؼ�
				if(truth[a]) continue; //�ش� ��Ƽ�� �̹� �湮�ߴٸ� �Ѿ��,
				truth[a] = true; //�ƴϸ� �� ��Ƽ�� �������� ���ϵ��� �Ѵ�.
				ans--;
				
				for(Integer b : party.get(a)) { //��Ƽ�� �ִ� ������� �˾Ƴ���.
					if(vis[b]) continue; //�̹� �ذ��� ����̸� �Ѿ��.
					vis[b] = true; //�ƴϸ� �� ����� �ִ� ��Ƽ�� ����� Ȯ���ϱ� ���� ť�� �ְ� �湮������ �˸���.
					
					Q.add(b);
				}
			}
		}
		
		System.out.println(ans);
	}
}