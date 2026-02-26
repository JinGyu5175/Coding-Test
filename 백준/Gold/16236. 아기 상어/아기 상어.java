import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int shark_x = 0;
        int shark_y = 0;
        int board[][] = new int [n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 9 ){
                    shark_x = i;
                    shark_y = j;
                    board[i][j] = 0;
                }
            }
        }

        int size = 2; // 상어 크기
        int current_cnt = 0; // 현재 크기에서 먹은 물고기 갯수

        Deque<int[]> queue;
        List<int[]> arr;
        int dx[] = {-1, 0, 0, 1};
        int dy[] = {0, -1, 1, 0};
        int cnt = 0;

        while(true) {
            arr = new ArrayList<>();
            queue = new ArrayDeque<>();
            queue.add(new int[]{0, shark_x, shark_y});
            boolean flag[][] = new boolean[n][n];
            flag[shark_x][shark_y] = true;

            while (!queue.isEmpty()) {
                int num[] = queue.poll();
                int move_distance = num[0];
                int c_x = num[1];
                int c_y = num[2];

                for (int i = 0; i < 4; i++) {
                    int nx = c_x + dx[i];
                    int ny = c_y + dy[i];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue; // 격자점 벗어남
                    if (board[nx][ny] > size) continue; // 상어보다 큰 물고기
                    if (flag[nx][ny] == true) continue; // 방문한 곳

                    if (board[nx][ny] != 0 && board[nx][ny] < size) { // 물고기가 있는데, 사이즈가 나보다 작을 경우
                        arr.add(new int[]{move_distance + 1, nx, ny}); // arr에 담음
                        flag[nx][ny] = true;
                    } else if (board[nx][ny] != 0 && board[nx][ny] == size) { // 물고기가 있는데, 사이즈가 나와 동일한 경우
                        queue.add(new int[]{move_distance + 1, nx, ny});
                        flag[nx][ny] = true;
                    } else if (board[nx][ny] == 0) { //물고기가 없는 곳
                        queue.add(new int[]{move_distance + 1, nx, ny});
                        flag[nx][ny] = true;
                    }
                }
            }

            if(arr.size() == 0){
                break;
            }

            arr.sort((a, b) -> {
                if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
                return Integer.compare(a[2], b[2]);
            });

            cnt += arr.get(0)[0];
            shark_x = arr.get(0)[1];
            shark_y = arr.get(0)[2];
            board[shark_x][shark_y] = 0;
            current_cnt += 1;

            if (current_cnt == size){
                size++;
                current_cnt = 0;
            }
        }
        System.out.println(cnt);

//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                System.out.print(flag[i][j]);
//            }
//            System.out.println();
//        }
    }
}
