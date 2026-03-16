import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int station[] = new int[n];
        for (int i = 0; i < n; i++) {
            station[i] = Integer.parseInt(br.readLine());
        }

        int[][] list = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (list[i][j] == 0) continue;
                graph[i].add(new int[]{list[i][j], j});
            }
        }

        int dist[][] = new int[n][n];
        int INF = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = INF;
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2]) return a[2] - b[2]; // 환승 적은 거 우선
            return a[0] - b[0]; // 같으면 시간 적은 거
        });
        dist[0][0] = 0;
        pq.add(new int[]{0, 0, 0});
        int bestTurn = INF;
        int bestCost = INF;
        while (!pq.isEmpty()) {
            int cur[] = pq.poll();
            int cost = cur[0];
            int v = cur[1];
            int turn = cur[2];

            if (dist[v][turn] < cost) continue;

            if (v == end) {
                System.out.println(turn + " " + cost);
                return;
            }

            if (turn > bestTurn) continue;
            if (turn == bestTurn && cost >= bestCost) continue;

            for (int[] next : graph[v]) {
                int nextCost = next[0];
                int nextV = next[1];

                int newCost = cost + nextCost;
                int nextTurn = turn;
                if (station[v] != station[nextV]) {
                    nextTurn++;
                }
                if (nextTurn >= n) continue;
                if (dist[nextV][nextTurn] > newCost) {
                    dist[nextV][nextTurn] = newCost;
                    pq.add(new int[]{newCost, nextV, nextTurn});
                }
        
        
            }

        }
    }
}
