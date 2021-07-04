package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1927 { //ÃÖ¼Ò Èü
	private static int[] H;
	private static int length = 10, index;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		H = new int[length];
		
		for(int i = 0; i < N; i++) {
			if(index == length) resize();
			
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				if(index == 0) sb.append(0).append("\n");
				else{ //remove
					sb.append(H[0]).append("\n");
					H[0] = H[--index];
					
					int parentIndex = 0, leftChildIndex = 1, rightChildIndex = 2;
					num = H[0];
					
					while(true) {
						int small = -1;
						
						if(leftChildIndex >= index && rightChildIndex >= index) {
							H[parentIndex] = num;
							break;
						}
						else if(rightChildIndex >= index) small = leftChildIndex;
						else {
							if(H[leftChildIndex] <= H[rightChildIndex]) small = leftChildIndex;
							else small = rightChildIndex;
						}
						
						if(num > H[small]) {
							H[parentIndex] = H[small];
							parentIndex = small; leftChildIndex = parentIndex * 2 + 1; rightChildIndex = parentIndex * 2 + 2;
						}
						else {
							H[parentIndex] = num;
							break;
						}
					}
				}
			}
			else { //add
				if(index == 0) {
					H[index++] = num;
					continue;
				}
				int parentIndex = (index - 1) / 2, parent = H[parentIndex], childIndex = index++;
				
				while(num < parent) {
					H[childIndex] = parent;
		
					childIndex = parentIndex;
					if(childIndex == 0) break;
					
					parentIndex = (parentIndex - 1) / 2;
					parent = H[parentIndex];
				}
				
				H[childIndex] = num;
			}
		}
		
		System.out.println(sb);
	}
	
	public static void resize() {
		length += length / 2;
		H = Arrays.copyOf(H, length);
	}
}