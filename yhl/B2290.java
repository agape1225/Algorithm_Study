package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2290 { //LCD Test
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		String Num = st.nextToken();
		int len = Num.length();
		char[] nums = new char[len];
		
		for(int i = 0; i < len; i++) nums[i] = Num.charAt(i);
		
		for(int i = 0; i < 2 * S + 3; i++) {
			for(int j = 0; j < len; j++) {
				switch(nums[j]) {
				case '0' :
					if(i == 0) add1(S);
					else if(i <= S) add3(S);
					else if(i <= S + 1) space(S);
					else if(i <= 2 * S + 1) add3(S);
					else add1(S);
					break;
				case '1' :
					if(i == 0) space(S);
					else if(i <= S) add2(S);
					else if(i <= S + 1) space(S);
					else if(i <= 2 * S + 1) add2(S);
					else space(S);
					break;
				case '2' :
					if(i == 0) add1(S);
					else if(i <= S) add2(S);
					else if(i <= S + 1) add1(S);
					else if(i <= 2 * S + 1) add4(S);
					else add1(S);
					break;
				case '3' :
					if(i == 0) add1(S);
					else if(i <= S) add2(S);
					else if(i <= S + 1) add1(S);
					else if(i <= 2 * S + 1) add2(S);
					else add1(S);
					break;
				case '4' :
					if(i == 0) space(S);
					else if(i <= S) add3(S);
					else if(i <= S + 1) add1(S);
					else if(i <= 2 * S + 1) add2(S);
					else space(S);
					break;
				case '5' :
					if(i == 0) add1(S);
					else if(i <= S) add4(S);
					else if(i <= S + 1) add1(S);
					else if(i <= 2 * S + 1) add2(S);
					else add1(S);
					break;
				case '6' :
					if(i == 0) add1(S);
					else if(i <= S) add4(S);
					else if(i <= S + 1) add1(S);
					else if(i <= 2 * S + 1) add3(S);
					else add1(S);
					break;
				case '7' :
					if(i == 0) add1(S);
					else if(i <= S) add2(S);
					else if(i <= S + 1) space(S);
					else if(i <= 2 * S + 1) add2(S);
					else space(S);
					break;
				case '8' :
					if(i == 0) add1(S);
					else if(i <= S) add3(S);
					else if(i <= S + 1) add1(S);
					else if(i <= 2 * S + 1) add3(S);
					else add1(S);
					break;
				case '9' :
					if(i == 0) add1(S);
					else if(i <= S) add3(S);
					else if(i <= S + 1) add1(S);
					else if(i <= 2 * S + 1) add2(S);
					else add1(S);
					break;
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	public static void add1(int S){ // --
		sb.append(" ");
		for(int i = 0; i < S; i++) sb.append("-");
		sb.append(" ");
	}
	public static void add2(int S){ //   |
		sb.append(" ");
		for(int i = 0; i < S; i++) sb.append(" ");
		sb.append("|");
	}
	public static void add3(int S){ // | |
		sb.append("|");
		for(int i = 0; i < S; i++) sb.append(" ");
		sb.append("|");
	}
	public static void add4(int S){ // |
		sb.append("|");
		for(int i = 0; i < S; i++) sb.append(" ");
		sb.append(" ");
	}
	public static void space(int S) {
		for(int i = 0; i < S + 2; i++) sb.append(" ");
	}
}