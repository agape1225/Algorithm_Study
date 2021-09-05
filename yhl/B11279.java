package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11279 { //ÃÖ´ë Èü

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Heap H = new Heap();
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) sb.append(H.remove()).append("\n");
			else H.add(num);
			//for(int j = 0; j < H.heap.length; j++) System.out.print(" " + H.heap[j] + " ");
			//System.out.println("size : " + H.size);
		}
		
		System.out.println(sb);
	}
	
	static class Heap {
		int[] heap = new int[10];
		int size = 0, index = 0; 
		
		void newSize() {
			heap = Arrays.copyOf(heap, heap.length * 2);
		}
		
		void add(int num) {
			if(size == heap.length) newSize();
			
			if(size == 0) {
				heap[0] = num;
				size++;
				return;
			}

			int parentIndex = 0, tempN = 0;
			
			if(size % 2 == 0) parentIndex = size / 2 - 1;
			else parentIndex = size / 2;
			
			index = size++;
			tempN = heap[parentIndex];
			
			while(num > tempN) {
				if(parentIndex == 0) {
					heap[index] = tempN;
					index = 0;
					break;
				}
				
				heap[index] = tempN;
				index = parentIndex;

				if(index % 2 == 0) parentIndex = index / 2 - 1;
				else parentIndex = index / 2;
				
				tempN = heap[parentIndex];
			}
			
			heap[index] = num;
		}
		
		int remove() {
			if(size == 0) return 0;
			
			int res = heap[0];
			if(size == 1) {
				heap = new int[10];
				size = 0;
				
				return res;
			}
			
			index = 0;
			int num = heap[--size], childIndex = 0, tempN = 0;
			
			if(size < 2 || heap[1] > heap[2]) {
				tempN = heap[1];
				childIndex = 1;
			}
			else {
				tempN = heap[2];
				childIndex = 2;
			}
			
			while(num < tempN) {
				heap[index] = tempN;
				index = childIndex;
				
				int left = index * 2 + 1, right = index * 2 + 2;
				if(left >= size) break;
				
				if(right == size || heap[left] > heap[right]) {
					tempN = heap[left];
					childIndex = left;
				}
				else {
					tempN = heap[right];
					childIndex = right;
				}
			}
			
			heap[index] = num;
			
			return res;
		}
	}
}