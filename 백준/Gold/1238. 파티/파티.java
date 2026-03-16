
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int INF = Integer.MAX_VALUE;
		List<int[]>graph[] = new ArrayList[n + 1];
		List<int[]>graph2[] = new ArrayList[n + 1];
		
		int dist[] = new int[n + 1];
		int dist2[] = new int[n + 1];
		for(int i = 1; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = INF;
			graph2[i] = new ArrayList<>();
			dist2[i] = INF;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[to].add(new int[] {cost, from});
			graph2[from].add(new int[] {cost, to});
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		pq.add(new int[] {0, x});
		dist[x] = 0;
		while(!pq.isEmpty()) {
			int num[] = pq.poll();
			int cost = num[0];
			int v = num[1];
			
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

		PriorityQueue<int[]> pq2 = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		pq2.add(new int[] {0, x});
		dist2[x] = 0;
		while(!pq2.isEmpty()) {
			int num[] = pq2.poll();
			int cost = num[0];
			int v = num[1];
			
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
		int result = -1;
		for(int i = 1; i < n + 1; i++) {
			if(result < dist[i] +  dist2[i]) {
				result = dist[i] + dist2[i];
			}
		}
		System.out.println(result);
		
		
		
		
				
	}
}