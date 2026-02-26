import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException{
		PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < n; i++) {
			int m = Integer.parseInt(br.readLine());
			
			if(heap.isEmpty() && m == 0 ) {
				System.out.println(0);
				continue;
			}
			
			if(m == 0) {
				System.out.println(heap.poll());
			}
			
			else {
				heap.offer(m);
			}		
		}
	}
}

	
