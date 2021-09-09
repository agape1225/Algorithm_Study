package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B5525 { //IOIOI
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		boolean isI = false;
		int count = 0, temp = 0, ans = 0;;
		for(int i = 0; i < M; i++) {
			if(temp == 3) {
				count++;
				temp = 1;
				if(count == N) {
					count--;
					ans++;
				}
			}
			
			if(isI && s.charAt(i) == 'O') {
				isI = false;
				temp++;
			}
			else if(s.charAt(i) == 'I') {
				if(isI) {
					temp = 1;
					count = 0;
				}				
				else {
					isI = true;
					temp++;
				}
			}
			else {
				count = 0;
				temp = 0;
				isI = false;
			}
		}
		
		System.out.println(ans);
	}
}