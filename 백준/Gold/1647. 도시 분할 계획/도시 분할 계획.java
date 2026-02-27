import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());


        List<int[]> edges = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            sum += cost;
            edges.add(new int[]{cost, x, y});
        }

        Collections.sort(edges, (a, b) -> a[0] - b[0]);

        parent = new int[m + 1];
        for (int i = 1; i < m + 1; i++) {
            parent[i] = i;
        }

        int total = 0;
        int last = 0;
        for (int[] e : edges) {
            int cost = e[0];
            int from = e[1];
            int to = e[2];

            if (union(from, to)) {
                total += cost;
                last = cost;
            }
        }

        sb.append(total - last).append("\n");
        

        System.out.print(sb);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) return false;

        parent[pb] = pa;
        return true;
    }
}