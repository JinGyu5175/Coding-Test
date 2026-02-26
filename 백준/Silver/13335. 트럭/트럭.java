import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		Deque<Integer> wait_queue = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			wait_queue.add(num);
		}
		List<int[]> list = new ArrayList<>();
		int count = 0;
		while(!wait_queue.isEmpty()) {
			// 다리 다 건넌 트럭 삭제
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i)[1] == w) {
					list.remove(i);
				}
			}
			// 현재 다리 건너고 있는 트럭의 무게 합
			int sum = 0;
			for(int i = 0; i < list.size(); i++) {
				sum += list.get(i)[0];
			}
			
			// 대기중인 트럭이 진입 가능한 경우
			if(sum + wait_queue.peek() <= L) {
				int num = wait_queue.poll();
				list.add(new int[] {num, 0});
			}
			
			// 다리 건너고 있는 트럭 시간 추가해주기
			for(int i = 0; i < list.size(); i++) {
				list.get(i)[1] += 1;
			}
			
//			for(int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
//			}
			count++;

			
			
		}
		
		System.out.println(count + w);
		
	}
}
