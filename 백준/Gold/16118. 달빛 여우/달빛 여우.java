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
		int dist_fox[] = new int[n + 1];
		int dist_wolf[][] = new int[n + 1][2];
		
		
		int INF = Integer.MAX_VALUE;
		
		for(int i = 1; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
			dist_fox[i] = INF;
			dist_wolf[i][0] = INF;
			dist_wolf[i][1] = INF;
		}
		
		for(int i = 0 ; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken()) * 2;
			
			graph[from].add(new int[] {cost, to});
			graph[to].add(new int[] {cost, from});
		}
		
		// 여우
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		
		pq.add(new int[] {0, 1});
		dist_fox[1] = 0;
		while(!pq.isEmpty()) {
			int cur[] = pq.poll();
			int cost = cur[0];
			int v = cur[1];
			
			if(dist_fox[v] < cost) continue;
			
			for(int next[] : graph[v]) {
				int nextCost = next[0];
				int nextV = next[1];
				
				int newCost = cost + nextCost;
				
				if(dist_fox[nextV] > newCost) {
					dist_fox[nextV] = newCost;
					pq.add(new int[] {newCost, nextV});
				}
			}
		}
		pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		
		pq.add(new int[] {0, 1, 0}); // cost, v, 전에 어느 속도로 뛰어왔는지, 0일경우 다음에 2배로, 1일경우 다음 1/2배로
		dist_wolf[1][0] = 0;
		while(!pq.isEmpty()) {
			int cur[] = pq.poll();
			int cost = cur[0];
			int v = cur[1];
			int status = cur[2];
			
			
			if(dist_wolf[v][status] < cost) continue;
			
			
			for(int next[] : graph[v]) {
				int nextCost = next[0];
				int nextV = next[1];
								
				if(status == 0) {
					int newCost = cost + nextCost / 2;
					if(dist_wolf[nextV][1] > newCost) {
						dist_wolf[nextV][1] = newCost;
						pq.add(new int[] {newCost, nextV, 1});
					}
				}
				else {
					int newCost = cost + nextCost * 2;
					if(dist_wolf[nextV][0] > newCost) {
						dist_wolf[nextV][0] = newCost;
						pq.add(new int[] {newCost, nextV, 0});
					
					}
				}
			}
		}

        int cnt = 0;
        for(int i = 1; i < n + 1; i++){
            int num = Math.min(dist_wolf[i][0], dist_wolf[i][1]);
            if(dist_fox[i] < num){
                cnt++;
            }
        }
        System.out.println(cnt);
	}
}
