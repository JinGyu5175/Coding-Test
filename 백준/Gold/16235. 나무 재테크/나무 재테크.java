import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] grow = new int[n][n];
        int[][] board = new int[n][n];
        ArrayDeque<Integer>[][] trees = new ArrayDeque[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grow[i][j] = Integer.parseInt(st.nextToken());
                board[i][j] = 5;
                trees[i][j] = new ArrayDeque<>();
            }
        }

        // 초기 나무: 같은 칸에 여러 개면 나이 오름차순 필요

        ArrayList<int[]> init = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int old = Integer.parseInt(st.nextToken());
            init.add(new int[]{x, y, old});
        }
        init.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });
        for (int[] t : init) trees[t[0]][t[1]].addLast(t[2]);

        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int year = 0; year < k; year++) {

            int[][] deadAdd = new int[n][n];     // 여름(죽은 나무 양분)
            int[][] breedCnt = new int[n][n];    // 가을 번식 개수(칸별)

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (trees[x][y].isEmpty()) continue;

                    ArrayDeque<Integer> next = new ArrayDeque<>();
                    int nutr = board[x][y];

                    while (!trees[x][y].isEmpty()) {
                        int age = trees[x][y].pollFirst(); // 어린 것부터
                        if (age <= nutr) {
                            nutr -= age;
                            age++;

                            next.addLast(age);
                            if (age % 5 == 0) breedCnt[x][y]++; // 번식 예약
                            
                        } else {
                            // 이 나무 + 뒤 나무들은 전부 죽음
                            deadAdd[x][y] += age / 2;
                            while (!trees[x][y].isEmpty()) {
                                deadAdd[x][y] += trees[x][y].pollFirst() / 2;
                            }
                        }
                    }

                    board[x][y] = nutr;
                    trees[x][y] = next;
                }
            }

            // 가을: 번식(나이 1 나무) → 항상 가장 어린 나무라 addFirst(1)
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    int cnt = breedCnt[x][y];
                    if (cnt == 0) continue;

                    for (int dir = 0; dir < 8; dir++) {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                        for (int c = 0; c < cnt; c++) {
                            trees[nx][ny].addFirst(1);
                        }
                    }
                }
            }

            // 겨울(+ 여름 반영 포함)
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] += deadAdd[i][j];
                    board[i][j] += grow[i][j];
                }
            }
        }

        // 정답: 남은 나무 수
        int ans = 0;
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) ans += trees[i][j].size();
        System.out.println(ans);
    }
}
