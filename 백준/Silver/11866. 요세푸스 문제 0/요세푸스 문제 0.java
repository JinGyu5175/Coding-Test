import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n  = Integer.parseInt(st.nextToken());
		int m  = Integer.parseInt(st.nextToken());
		
		int arr[] = new int [n];
		Deque<Integer> deque = new ArrayDeque<>();
		for(int i = 1; i < n + 1; i++) {
			deque.add(i);
		}
		
		int result[] = new int [n];
		int tmp = 0;
		while(!deque.isEmpty()) {
			
			for(int i = 0; i < m - 1; i++) {
				int num = deque.poll();
				deque.add(num);				
			}
			
			result[tmp] = deque.poll();
			tmp++;
		}
		System.out.print("<");
		for(int i = 0; i < n; i++) {
			if(i != 0)System.out.print(", ");
			System.out.print(result[i]);
		}
		System.out.print(">");
	
	}
}
