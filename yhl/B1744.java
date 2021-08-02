package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1744 { //�� ����

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int count = 0;
		for(int i = 0; i < N; i++) {
			int d = Integer.parseInt(br.readLine());
			if(d <= 0) count++; //������ 0�� ���� Ȯ���Ѵ�.
			num[i] = d;
		}
		Arrays.sort(num);
		
		long ans = 0;
		int i = 0;
		boolean odd = false;
		
		if(count % 2 != 0) { //������ 0�� ������ Ȧ���� �Ѱ��� ����.
			count--;
			odd = true;
		}
		
		//������ 0 ���, 0�� ����� ���ϸ� ������� �۾����� ������ ���ϸ� ������� Ŀ����.
		while(i < count) ans += num[i++] * num[i++]; //������ ���ϸ� Ŀ����, ���ϸ� �۾�����.
		if(odd) ans += num[i++]; //Ȧ���� ���� ������ ���� ������ 0�� ���Ѵ�.
		
		//��� ���
		while(i < N && num[i] == 1) ans += num[i++]; //1�� ���ϴ°� �� ũ��.
		for(int j = N - 1; j >= i;) {
			if(j == i) { //�������� ���� ���� �ϳ��� ���Ѵ�.
				ans += num[j];
				break;
			}
			ans += num[j--] * num[j--]; //����� ���ϸ� �� Ŀ����.
		}
		System.out.println(ans);
	}
}