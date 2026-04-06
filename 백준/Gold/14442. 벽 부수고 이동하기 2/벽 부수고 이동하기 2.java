import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};
        int board[][] = new int[n][m];

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                board[i][j] = s.charAt(j) - 48;
            }
        }

//        for(int i = 0 ; i < n; i++){
//            for(int j = 0; j< m; j++){
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
        int dist[][][] = new int[n][m][k + 1];

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0});
        dist[0][0][0] = 1;
        boolean visited[][][] = new boolean[n][m][k + 1];
        visited[0][0][0] = true;
        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int b = cur[2];
//            System.out.println(x + " " + y + " " + b);
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(board[nx][ny] == 1){ // 벽일때
                    if(b + 1 <= k) { // 벽 더 부실 수 있을떄
                        if(visited[nx][ny][b + 1]) continue;
                        dist[nx][ny][b + 1] = dist[x][y][b] + 1;
//                        System.out.println(nx + " " + ny);
                        queue.add(new int[]{nx, ny, b + 1});
                        visited[nx][ny][b + 1] = true;
                    }
                }
                else{ // 아닐때
                    if(visited[nx][ny][b]) continue;
                    dist[nx][ny][b] = dist[x][y][b] + 1;
                    queue.add(new int[]{nx, ny, b});
                    visited[nx][ny][b] = true;
                }
            }
        }
        int min_value = Integer.MAX_VALUE;

//        for(int a = 0 ; a < k + 1; a++){
//            for(int i = 0; i < n; i++){
//                for(int j = 0; j < m; j++){
//                    System.out.print(dist[i][j][a] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }

        for(int i = 0; i < k + 1; i++){
            if(dist[n - 1][m - 1][i] < min_value && dist[n - 1][m - 1][i] != 0){
                min_value = dist[n - 1][m - 1][i];
            }
        }
        if(min_value == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else {
            System.out.println(min_value);
        }



    }
}
