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
		int m = Integer.parseInt(st.nextToken());
		
		List<Integer>[] g = new ArrayList[n + 1];
		
		for(int i = 1; i < n + 1; i++) g[i] = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			g[a].add(b);
			g[b].add(a);
		}
		Deque<Integer> queue = new ArrayDeque<>();
		int count = 0;
		int flag[] = new int [n + 1];
		for(int i = 1; i < n + 1; i++) {
			if(flag[i] != 0) continue;
			queue.add(i);
			count += 1;
			flag[i] = 1;
			while(!queue.isEmpty()) {
				int num = queue.poll();
				for(int j = 0; j < g[num].size(); j++) {
					int tmp = g[num].get(j);
					if(flag[tmp] == 0) {
						flag[tmp] = 1;
						queue.add(tmp);
					}
				}
			}
		}
		System.out.println(count);
		
	}
}
