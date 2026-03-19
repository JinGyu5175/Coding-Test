
import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] board;
    static int[][] visit; // 0: 미방문, 1: 방문중, 2: 탐색완료
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        visit = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] == 0) {
                    dfs(i, j);
                }
            }
        }
        System.out.println(count);
    }

    static void dfs(int x, int y) {
        visit[x][y] = 1; // 방문중

        int nx = x;
        int ny = y;

        if (board[x][y] == 'U') nx--;
        else if (board[x][y] == 'D') nx++;
        else if (board[x][y] == 'L') ny--;
        else if (board[x][y] == 'R') ny++;

        if (visit[nx][ny] == 0) {
            dfs(nx, ny);
        } else if (visit[nx][ny] == 1) {
            count++; // 현재 경로에서 다시 만남 => 새로운 사이클
        }

        visit[x][y] = 2; // 탐색 완료
    }
}