
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int board[][] = new int[n][m];
        int final_board[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            String num = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = num.charAt(j) - '0';
            }
        }

        boolean visited[][] = new boolean[n][m];
        int sizeBoard[][] = new int[n][m];   // 각 0칸이 속한 영역의 크기
        int groupBoard[][] = new int[n][m];  // 각 0칸이 속한 영역 번호
        int groupId = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 && !visited[i][j]) {
                    visited[i][j] = true;

                    List<int[]> list = new ArrayList<>();
                    Deque<int[]> queue = new ArrayDeque<>();

                    queue.add(new int[] {i, j});
                    list.add(new int[] {i, j});

                    while (!queue.isEmpty()) {
                        int cur[] = queue.poll();
                        int x = cur[0];
                        int y = cur[1];

                        for (int a = 0; a < 4; a++) {
                            int nx = x + dx[a];
                            int ny = y + dy[a];

                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if (visited[nx][ny]) continue;
                            if (board[nx][ny] == 0) {
                                visited[nx][ny] = true;
                                queue.add(new int[] {nx, ny});
                                list.add(new int[] {nx, ny});
                            }
                        }
                    }

                    int count = list.size();

                    for (int cur[] : list) {
                        int x = cur[0];
                        int y = cur[1];
                        sizeBoard[x][y] = count;
                        groupBoard[x][y] = groupId;
                    }

                    groupId++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    int sum = 1;
                    Set<Integer> set = new HashSet<>();

                    for (int a = 0; a < 4; a++) {
                        int nx = i + dx[a];
                        int ny = j + dy[a];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (board[nx][ny] == 1) continue;

                        int gid = groupBoard[nx][ny];
                        if (set.contains(gid)) continue;

                        set.add(gid);
                        sum += sizeBoard[nx][ny];
                    }

                    final_board[i][j] = sum % 10;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(final_board[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}