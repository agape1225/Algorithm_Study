package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class B9081 { //�ܾ� ���߱�
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String s = br.readLine(), res = "";
			boolean isChanged = false;
			int indexI = -1, indexJ = -1;
			
			//�ִ��� �ڿ��� �ٲ�� ���� ������ ��ĭ ���̴�.
			//�տ������� ���ϸ鼭 �� ū ���� ������ �ش� �ε����� �������ش�.
			//�ڿ� �ٽ� �ٲ��� �� �ִٸ� �� �ε����� �������ش�.
			for(int i = 0; i < s.length(); i++) {
				char word = s.charAt(i), tmp = word;
				boolean tempChanged = false;
				for(int j = i + 1; j < s.length(); j++) {
					char temp = s.charAt(j);
					
					//������ ���ĺ��� �ѹ��� �ȹٲ� ���, �ش� ���ĺ����� ū ���ĺ��� ������
					//�ε����� �����ϰ� tmp�� �ٲ� ���ĺ��� �������ش�.
					if(!tempChanged && word < temp) {
						indexI = i;
						indexJ = j;
						tmp = temp;
						isChanged = true;
						tempChanged = true;
					}
					//���ĺ��� �ѹ� �̻� �ٲ��� ���, �ٲ� ���ĺ��� �ڿ� ���ĺ��� ���ؼ�
					//�ڿ� ���ĺ��� ������ ���ĺ����� ũ�� �ٲ� ���ĺ����� �۴ٸ� �ε����� �����ϰ� tmp�� ���ĺ��� ���� �����Ѵ�.
					else if(tempChanged && word < temp && tmp > temp) {
						indexJ = j;
						tmp = temp;
					}
				}
			}
			
			//�ܾ ��ü�ߴٸ�, ��ü�� ���� �ε������� ������ ��,
			// ���� �ڿ� �ε������� ������������ �����ϰ� ������ ���ڿ��� �����ش�.
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