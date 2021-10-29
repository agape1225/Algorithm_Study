package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class B9081 { //단어 맞추기
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String s = br.readLine(), res = "";
			boolean isChanged = false;
			int indexI = -1, indexJ = -1;
			
			//최대한 뒤에서 바뀌는 것이 사전상 한칸 앞이다.
			//앞에서부터 비교하면서 더 큰 것이 나오면 해당 인덱스를 저장해준다.
			//뒤에 다시 바꿔줄 수 있다면 그 인덱스를 저장해준다.
			for(int i = 0; i < s.length(); i++) {
				char word = s.charAt(i), tmp = word;
				boolean tempChanged = false;
				for(int j = i + 1; j < s.length(); j++) {
					char temp = s.charAt(j);
					
					//선택한 알파벳이 한번도 안바뀐 경우, 해당 알파벳보다 큰 알파벳이 나오면
					//인덱스를 저장하고 tmp에 바꿀 알파벳을 저장해준다.
					if(!tempChanged && word < temp) {
						indexI = i;
						indexJ = j;
						tmp = temp;
						isChanged = true;
						tempChanged = true;
					}
					//알파벳을 한번 이상 바꿨을 경우, 바꾼 알파벳과 뒤에 알파벳을 비교해서
					//뒤에 알파벳이 원래의 알파벳보다 크고 바꾼 알파벳보다 작다면 인덱스를 저장하고 tmp에 알파벳을 새로 저장한다.
					else if(tempChanged && word < temp && tmp > temp) {
						indexJ = j;
						tmp = temp;
					}
				}
			}
			
			//단어를 교체했다면, 교체한 앞의 인덱스까지 저장한 뒤,
			// 남은 뒤에 인덱스부터 오름차순으로 정렬하고 저장한 문자열에 더해준다.
			if(isChanged) {
				String tempS = s.substring(0, indexI) + s.charAt(indexJ);
				tempS += s.substring(indexI + 1, indexJ) + s.charAt(indexI);
				tempS += s.substring(indexJ + 1, s.length());
				
				res = tempS.substring(0, indexI + 1);
				res += solve_sort(tempS.substring(indexI + 1, tempS.length()));
				
				sb.append(res).append("\n");
			}
			else sb.append(s).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static String solve_sort(String s) {
		TreeMap<Character, Integer> map = new TreeMap<>();
		for(int i = 0; i < s.length(); i++) {
			if(map.containsKey(s.charAt(i))) map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			else map.put(s.charAt(i), 1);
		}
		
		String res = "";
		for(Character c : map.keySet()) {
			for(int i = 0; i < map.get(c); i++) res += c;
		}
		
		return res;
	}
}