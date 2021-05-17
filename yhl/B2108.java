package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2108 { //통계학

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] count = new int[8001]; //0은 -4000, 4000은 0, 8000은 4000이다. 최빈값을 위한 배열
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n]; //값을 저장하기 위한 배열, 정렬시킨다.
		double average = 0; //평균값을 위한 변수
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine()); 
			arr[i] = num;
			count[num + 4000]++;
			average += num;
		}
		Arrays.sort(arr); //중앙값을 출력하기 위해 정렬한다.
		average /= n; //평균값 계산
		
		int max = 0; //최빈값
		boolean isCheck = false; //두 번째로 작은 값을 위한 변수
		for(int i = 1; i < 8001; i++) {
			if(count[i] > count[max]) {
				max = i;
				isCheck = false;
			}
			else if(count[i] == count[max]) {
				if(!isCheck) { //두 번째로 작은 값일 때만 실행된다.
					max = i;
					isCheck = true;
				}
			}
		}
		
		System.out.println(Math.round(average) + "\n" + arr[n / 2] + "\n" + (max - 4000) + "\n" + (arr[n - 1] - arr[0]));	
	}
}