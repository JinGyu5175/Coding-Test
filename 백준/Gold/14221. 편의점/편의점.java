
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
		
		for(int i = 1; i < n + 1; i++) {
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
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int home[] = new int[a];
		int shop[] = new int[b];
		
		st = new StringTokenizer(br.readLine());
 		for(int i = 0; i < a; i++) {
 			int ot = Integer.parseInt(st.nextToken());
 			home[i] = ot;
 		}
 		
		st = new StringTokenizer(br.readLine());
 		for(int i = 0; i < b; i++) {
 			int ot = Integer.parseInt(st.nextToken());
 			shop[i] = ot;
 		}
 		
 		int dist[] = new int[n + 1];
 		int INF = Integer.MAX_VALUE;
 		
 		for(int i = 1; i < n + 1; i++) {
 			dist[i] = INF;
 		}
 		
 		PriorityQueue<int[]> pq = new PriorityQueue<>((c, d) -> c[0] - d[0]);
 		for(int i = 0; i < b; i++) {
 			dist[shop[i]] = 0;
 			pq.add(new int[] {0, shop[i]});
 		}
 
 		while(!pq.isEmpty()) {
 			int cur[] = pq.poll();
 			int cost = cur[0];
 			int v = cur[1];
 			
 			if(dist[v] < cost) continue;
 			
 			for(int next[] : graph[v]) {
 				int nextCost = next[0];
 				int nextV = next[1];
 				
 				int newCost = nextCost + cost;
 				if(dist[nextV] > newCost) {
 					dist[nextV] = newCost;
 					pq.add(new int[] {newCost, nextV});
 				}
 			}
 		}
 		
 		int min_value = INF;
 		int target = Integer.MAX_VALUE;

 		for (int i = 0; i < a; i++) {
 		    int h = home[i];

 		    if (dist[h] < min_value) {
 		        min_value = dist[h];
 		        target = h;
 		    } else if (dist[h] == min_value && h < target) {
 		        target = h;
 		    }
 		}

 		System.out.println(target);
	}
}
