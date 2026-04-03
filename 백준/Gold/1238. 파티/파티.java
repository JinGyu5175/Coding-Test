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
		int x = Integer.parseInt(st.nextToken());
		List<int[]> graph[] = new ArrayList[n + 1];
		List<int[]> graph2[] = new ArrayList[n + 1];
		
		for(int i = 1; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
			graph2[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			graph[from].add(new int[] {time, to});
			graph2[to].add(new int[] {time, from});
		}
		
		int dist[] = new int [n + 1];
		int dist2[] = new int [n + 1];
		
		int INF = Integer.MAX_VALUE;
		
		for(int i = 1; i < n + 1; i++) {
			dist[i] = INF;
			dist2[i] = INF;
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		// x에서 다른 곳으로 가는 길이
		dist[x] = 0;
		pq.add(new int[] {0, x});
		
		while(!pq.isEmpty()) {
			int cur[] = pq.poll();
			int cost = cur[0];
			int v = cur[1];
			
			if(dist[v] < cost) continue;
			
			for(int next[] : graph[v]) {
				int nextCost = next[0];
				int nextV = next[1];
				
				int newCost = cost + nextCost;
				if(dist[nextV] > newCost) {
					dist[nextV] = newCost;
					pq.add(new int[] {newCost, nextV});
				}
			}
		}
		
//		for(int i = 1; i < n + 1; i++) {
//			System.out.println(dist[i]);
//		}
		
		PriorityQueue<int[]> pq2 = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		// x에서 다른 곳으로 가는 길이
		dist2[x] = 0;
		pq2.add(new int[] {0, x});
		
		while(!pq2.isEmpty()) {
			int cur[] = pq2.poll();
			int cost = cur[0];
			int v = cur[1];
			
			if(dist2[v] < cost) continue;
			
			for(int next[] : graph2[v]) {
				int nextCost = next[0];
				int nextV = next[1];
				
				int newCost = cost + nextCost;
				if(dist2[nextV] > newCost) {
					dist2[nextV] = newCost;
					pq2.add(new int[] {newCost, nextV});
				}
			}
		}
		

		int max_value = -1;
		for(int i = 1; i < n + 1; i++) {
			if(dist[i] != INF && dist2[i] != INF && i != x) {
				int sum = dist[i] + dist2[i];
				if(max_value < sum) {
					max_value = sum;
				}
			}
		}
		System.out.println(max_value);
		
		
		
	}
}
