
import java.io.*;
import java.util.*;

public class Main {
    static int N, R, Q;
    static ArrayList<Integer>[] tree;
    static int[] subtreeSize;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        subtreeSize = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            tree[U].add(V);
            tree[V].add(U);
        }

        dfs(R, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int u = Integer.parseInt(br.readLine());
            sb.append(subtreeSize[u]).append('\n');
        }

        System.out.print(sb);
    }

    static void dfs(int now, int parent) {
        subtreeSize[now] = 1; // 자기 자신

        for (int next : tree[now]) {
            if (next == parent) continue; // 부모로 되돌아가는 것 방지
            dfs(next, now);
            subtreeSize[now] += subtreeSize[next];
        }
    }
}