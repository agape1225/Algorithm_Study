package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2108 { //�����

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] count = new int[8001]; //0�� -4000, 4000�� 0, 8000�� 4000�̴�. �ֺ��� ���� �迭
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n]; //���� �����ϱ� ���� �迭, ���Ľ�Ų��.
		double average = 0; //��հ��� ���� ����
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine()); 
			arr[i] = num;
			count[num + 4000]++;
			average += num;
		}
		Arrays.sort(arr); //�߾Ӱ��� ����ϱ� ���� �����Ѵ�.
		average /= n; //��հ� ���
		
		int max = 0; //�ֺ�
		boolean isCheck = false; //�� ��°�� ���� ���� ���� ����
		for(int i = 1; i < 8001; i++) {
			if(count[i] > count[max]) {
				max = i;
				isCheck = false;
			}
			else if(count[i] == count[max]) {
				if(!isCheck) { //�� ��°�� ���� ���� ���� ����ȴ�.
					max = i;
					isCheck = true;
				}
			}
		}
		
		System.out.println(Math.round(average) + "\n" + arr[n / 2] + "\n" + (max - 4000) + "\n" + (arr[n - 1] - arr[0]));	
	}
}