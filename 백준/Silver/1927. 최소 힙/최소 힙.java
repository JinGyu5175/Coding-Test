import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException{
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // 기본: 최소 힙
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(pq.size() == 0) System.out.println(0);
				else System.out.println(pq.poll());
			}
			else {
				pq.add(num);
			}
		}


		
	}
}
