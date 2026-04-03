
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
		
		List<long[]> graph[] = new ArrayList[n + 1];
		long dist[] = new long[n + 1];
		long INF = Long.MAX_VALUE / 4;
		
		for(int i = 1; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = -1;
		}
		
		for(int i = 0 ; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long cost = Integer.parseInt(st.nextToken());
			graph[from].add(new long[] {cost, to});
			graph[to].add(new long[] {cost, from});
		}
		
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));
		
		pq.add(new long[] {INF, start});
		dist[start] = INF;
		
		while(!pq.isEmpty()) {
			long cur[] = pq.poll();
			long cost = cur[0];
			int v = (int)cur[1];
			
			if(dist[v] > cost) continue; // 현재 다리까지의 무게보다 작으면 의미 없음(변화 없음)
			
			for(long next[] : graph[v]) {
				long nextCost = next[0];
				int nextV = (int)next[1];
				
				long newCost = Math.min(nextCost, cost);
				
				if(dist[nextV] < newCost) {
					dist[nextV] = newCost;
					pq.add(new long[] {newCost, nextV});
				}
			}
		}
		System.out.println(dist[end]);
		
	}
}
