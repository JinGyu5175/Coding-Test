import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Deque<Integer> last_card = new ArrayDeque<>();
		// 위부터 1, 2, 3, 4 ,5
		for(int i = 0; i < n; i++) {
			last_card.add(i + 1);
		}
		
		Deque<Integer> first_card = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int order[] = new int [n];
		for(int i = 0; i < n; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < n; i++) {
			int num = order[n - i - 1];
			if(num == 1) {
				first_card.addFirst(last_card.pollFirst());

			}
			else if(num == 2) {
			    int ot = last_card.pollFirst();

			    if(first_card.isEmpty()) {
			        first_card.addFirst(ot);
			    } else {
			        int tmp = first_card.pollFirst();
			        first_card.addFirst(ot);
			        first_card.addFirst(tmp);
			    }
			}
			else if(num == 3) {
				first_card.addLast(last_card.pollFirst());
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!first_card.isEmpty()) {
		    sb.append(first_card.pollFirst()).append(" ");
		}
		System.out.println(sb);
		
	}
}
