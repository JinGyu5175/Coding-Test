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
		Deque<Integer> queue = new ArrayDeque<>();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			if(tmp.equals("push")) {
				int m = Integer.parseInt(st.nextToken());
				queue.add(m);
			}
			else if(tmp.equals("pop")){
				if(queue.isEmpty())System.out.println(-1);
				else {
					System.out.println(queue.pollLast());
				}
			}
			else if(tmp.equals("size")) {
				System.out.println(queue.size());
			}
			else if(tmp.equals("empty")) {
				if(queue.isEmpty())System.out.println(1);
				else System.out.println(0);
			}
			else if(tmp.equals("top")) {
				if(queue.isEmpty())System.out.println(-1);
				else System.out.println(queue.peekLast());
			}			
		}
	}
}
