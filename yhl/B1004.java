package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1004 { //� ����

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
			
			//������̳� ������ �� �� �ϳ��� �� �ȿ� ������ ������ �� �ȿ� ���� �Ѵ�.
			//��, ������̳� ������ �� �ϳ��� ���� �߽ɰ��� �Ÿ��� ���������� ������ count++�� �Ѵ�.
			int count = 0, N = Integer.parseInt(br.readLine());
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				int c1 = Integer.parseInt(st.nextToken());
				int c2 = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
			
				boolean in = false;
				int[] temp = new int[2]; //0�� �����, 1�� ������, temp�� ���� �߽ɰ��� �Ÿ�
				for(int j = 0; j < 2; j++) {
					temp[j] = (int)(Math.pow(x[j] - c1, 2) + Math.pow(y[j] - c2, 2));
					if(temp[j] < r * r) in = !in; // ������� �������� ��� �� �ȿ� ������ count++���� �ʴ´�.
				}
				
				if(in) count++;
			}
			
			sb.append(count).append("\n");
		}
		
		System.out.println(sb);
	}
}