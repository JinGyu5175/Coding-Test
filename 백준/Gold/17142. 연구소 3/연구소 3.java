import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int r, c;
        Node(int r, int c) { this.r = r; this.c = c; }
    }

    static int N, M;
    static int[][] map;
    static List<Node> viruses = new ArrayList<>();
    static boolean[] pick;
    static int emptyCnt = 0;
    static int answer = Integer.MAX_VALUE;

    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 2) viruses.add(new Node(r, c));
                else if (map[r][c] == 0) emptyCnt++;
            }
        }

        // 빈칸이 없으면 0
        if (emptyCnt == 0) {
            System.out.println(0);
            return;
        }

        pick = new boolean[viruses.size()];
        comb(0, 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void comb(int idx, int start) {
        if (idx == M) {
            bfs();
            return;
        }
        for (int i = start; i < viruses.size(); i++) {
            pick[i] = true;
            comb(idx + 1, i + 1);
            pick[i] = false;
        }
    }

    static void bfs() {
        // 가지치기: 이미 답이 0이면 더 볼 필요 없음
        if (answer == 0) return;

        int[][] dist = new int[N][N];
        for (int r = 0; r < N; r++) Arrays.fill(dist[r], -1);

        ArrayDeque<Node> q = new ArrayDeque<>();
        for (int i = 0; i < viruses.size(); i++) {
            if (pick[i]) {
                Node v = viruses.get(i);
                dist[v.r][v.c] = 0;
                q.add(v);
            }
        }

        int remain = emptyCnt;
        int maxTime = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int curD = dist[cur.r][cur.c];

            // 이미 현재 거리(curD)가 answer 이상이면 더 진행해도 의미 없음
            if (curD >= answer) return;

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (map[nr][nc] == 1) continue;      // 벽은 못 감
                if (dist[nr][nc] != -1) continue;    // 방문했으면 패스

                dist[nr][nc] = curD + 1;
                q.add(new Node(nr, nc));

                // 빈칸(0)을 감염시키는 순간만 카운트/시간 갱신
                if (map[nr][nc] == 0) {
                    remain--;
                    maxTime = dist[nr][nc];
                    if (remain == 0) {
                        answer = Math.min(answer, maxTime);
                        return;
                    }
                }
                // 바이러스 칸(2)은 그냥 통로: remain 감소 X, maxTime 갱신 X
            }
        }
    }
}