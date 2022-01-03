package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B5430 { //AC
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		Loop : while(T-- > 0) {
			StringBuilder sb = new StringBuilder();
			String P = br.readLine();
			int N = Integer.parseInt(br.readLine());
			String X = br.readLine();
			
			String[] xi = X.substring(1, X.length() - 1).split(",");
			int count = 0, lastCount = 0;
			boolean reverse = false;
			
			for(int i = 0; i < P.length(); i++) {
				char p = P.charAt(i);
				
				if(p == 'R') reverse = !reverse;
				else {
					if(reverse) lastCount++;
					else count++;
				}
				
				if(lastCount + count > N) {
					sb.append("error");
					System.out.println(sb);
					continue Loop;
				}
			}
			
			sb.append("[");
			if(reverse) {
				for(int i = xi.length - 1 - lastCount; i >= count; i--) sb.append(xi[i]).append(",");
			}
			else {
				for(int i = count; i < xi.length - lastCount; i++) sb.append(xi[i]).append(",");
			}
			
			if(sb.length() > 1) sb.replace(sb.length() - 1, sb.length(), "]");
			else sb.append("]");
			
			System.out.println(sb);
		}
	}
}