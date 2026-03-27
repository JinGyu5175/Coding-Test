
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<int[]> graph[] = new ArrayList[n + 1];
		int dist[] = new int[n + 1];
		int INF = Integer.MAX_VALUE;
		
		for(int i = 1; i < n + 1; i++) {
			dist[i] = INF;
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[from].add(new int[] {cost, to});
			graph[to].add(new int[] {cost, from});
		}
		
		st = new StringTokenizer(br.readLine());
		int home_count = Integer.parseInt(st.nextToken());
		int mart_count = Integer.parseInt(st.nextToken());
		
		int home[] = new int[home_count];
		int mart[] = new int[mart_count];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < home_count; i++) {
			home[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < mart_count; i++) {
			mart[i] = Integer.parseInt(st.nextToken());
		}
		
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		for(int i = 0; i < mart_count; i++) {
			int ot = mart[i];
			dist[ot] = 0;
			pq.add(new int[] {0, ot});
		}
		
		while(!pq.isEmpty()) {
			int cur[] = pq.poll();
			int cost = cur[0];
			int v = cur[1];
			
			if(dist[v] < cost)continue;
			
			for(int next[] : graph[v]) {
				int nextCost = next[0];
				int nextV = next[1];
				
				int newCost = cost + nextCost;
				
				if(dist[nextV] > newCost) {
					dist[nextV] = newCost;
					pq.add(new int[] {newCost , nextV});
				}
			}
		}
		
		int min_value = Integer.MAX_VALUE;
		int result = -1;
		for(int h : home) {
			int cost = dist[h];
			if(cost != 0 && cost < min_value) {
				min_value = cost;
				result = h;
			}
			else if(cost == min_value && h < result) {
				result = h;
			}
		}
		System.out.println(result);
		
	}
}
