import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Main {
    static int n;
    static int m;
    static int [][]board;
    static int dist[][][];
    static Deque<int[]> queue;
    static boolean visited[][][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                board[i][j] = s.charAt(j) -'0';
            }
        }

        cal();
        if(dist[n-1][m-1][1] == 0 && dist[n-1][m-1][0] == 0){
            System.out.println(-1);
        }
        else if(dist[n-1][m-1][1] == 0 || dist[n-1][m-1][0] == 0){
            System.out.println(max(dist[n-1][m-1][1],dist[n-1][m-1][0]));
        }
        else{
            System.out.println(min(dist[n-1][m-1][1],dist[n-1][m-1][0]));
        }

//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < m; j++){
//                System.out.print(dist[i][j][0] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < m; j++){
//                System.out.print(dist[i][j][1] + " ");
//            }
//            System.out.println();
//        }
    }
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static void cal(){
        queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0});

        dist = new int[n][m][2];
        dist[0][0][0] = 1;
        visited = new boolean[n][m][2];
        visited[0][0][0] = true;

        while(!queue.isEmpty()){
            int info[] = queue.poll();
            int x = info[0];
            int y = info[1];
            int flag = info[2];

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                int nnx = nx + dx[i];
                int nny = ny + dy[i];

                // 1) 다음 칸이 빈칸(0) -> 그대로 이동
                if (board[nx][ny] == 0 && !visited[nx][ny][flag]) {
                    visited[nx][ny][flag] = true;
                    dist[nx][ny][flag] = dist[x][y][flag] + 1;
                    queue.add(new int[]{nx, ny, flag});
                }
                // 2) 다음 칸이 벽(1)이고 아직 안 부쉈으면 -> 부수고 그 칸으로 이동
                else if (board[nx][ny] == 1 && flag == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    dist[nx][ny][1] = dist[x][y][0] + 1;
                    queue.add(new int[]{nx, ny, 1});
                }
            }
        }
    }
}
