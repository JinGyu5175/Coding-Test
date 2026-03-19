import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            char[][] board = new char[h + 2][w + 2];

            // 바깥 패딩
            for (int i = 0; i < h + 2; i++) {
                for (int j = 0; j < w + 2; j++) {
                    board[i][j] = '.';
                }
            }

            // 원본 맵 입력
            for (int i = 1; i <= h; i++) {
                String line = br.readLine();
                for (int j = 1; j <= w; j++) {
                    board[i][j] = line.charAt(j - 1);
                }
            }

            boolean[] key = new boolean[26];
            String keys = br.readLine();

            if (!keys.equals("0")) {
                for (int i = 0; i < keys.length(); i++) {
                    key[keys.charAt(i) - 'a'] = true;
                }
            }

            List<int[]>[] wait = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                wait[i] = new ArrayList<>();
            }

            boolean[][] visited = new boolean[h + 2][w + 2];
            Deque<int[]> queue = new ArrayDeque<>();

            queue.offer(new int[]{0, 0});
            visited[0][0] = true;

            int count = 0;

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

                if (board[x][y] == '$') {
                    count++;
                    board[x][y] = '.';
                }

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || nx >= h + 2 || ny < 0 || ny >= w + 2) continue;
                    if (visited[nx][ny]) continue;
                    if (board[nx][ny] == '*') continue;

                    char c = board[nx][ny];

                    // 문
                    if ('A' <= c && c <= 'Z') {
                        int idx = c - 'A';

                        if (key[idx]) {
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                        } else {
                            visited[nx][ny] = true;
                            wait[idx].add(new int[]{nx, ny});
                        }
                    }
                    // 열쇠
                    else if ('a' <= c && c <= 'z') {
                        int idx = c - 'a';

                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});

                        if (!key[idx]) {
                            key[idx] = true;

                            for (int[] pos : wait[idx]) {
                                queue.offer(pos);
                            }
                            wait[idx].clear();
                        }
                    }
                    // 빈칸 or 문서
                    else {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }

            sb.append(count).append('\n');
        }

        System.out.print(sb);
    }
}