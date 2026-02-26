import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static void DFS(boolean visited[], int start, List<Integer> []g){
        visited[start] = true;
        sb.append(start).append(" ");
        for(int nxt : g[start]){
            if(!visited[nxt]){

                DFS(visited, nxt, g);
            }
        }
    }

    static void BFS(boolean[] visited, int start, List<Integer>[]g){
        visited[start] = true;
        sb.append(start).append(" ");

        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int nxt : g[cur]) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    queue.add(nxt);
                    sb.append(nxt).append(" ");
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        List<Integer>[] g = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++)g[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);
            g[b].add(a);
        }
        for(int i = 1; i < n + 1; i++){
            Collections.sort(g[i]);
        }
        boolean visited[] = new boolean[n + 1];
        DFS(visited, start, g);
        sb.append("\n");
        boolean visited2[] = new boolean[n + 1];
        BFS(visited2, start, g);
        System.out.println(sb);
    }
}
