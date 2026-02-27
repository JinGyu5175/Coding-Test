import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char board[][] = new char[n][m];
        int r_x = 0;
        int r_y = 0;
        int b_x = 0;
        int b_y = 0;

        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < m; j++){
                board[i][j] = line.charAt(j);
                if(board[i][j] == 'R'){
                    r_x = i;
                    r_y = j;
                    board[i][j] = '.';
                }
                if(board[i][j] == 'B'){
                    b_x = i;
                    b_y = j;
                    board[i][j] = '.';
                }
            }
        }

        Deque<int[]> queue = new ArrayDeque<>();
        int cnt = 0;
        queue.add(new int[]{r_x, r_y, b_x, b_y, cnt});
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};
        boolean[][][][] visited = new boolean[n][m][n][m];
        visited[r_x][r_y][b_x][b_y] = true;

        while(!queue.isEmpty()){
            int tmp[] = queue.poll();
            int c_r_x = tmp[0];
            int c_r_y = tmp[1];
            int c_b_x = tmp[2];
            int c_b_y = tmp[3];
            int c_cnt = tmp[4];
//            System.out.println(c_r_x+" "+c_r_y);
//
//            System.out.println(c_b_x+" "+c_b_y);
            if (c_cnt >= 10) continue; // 10번까지, 더 확장 X

            for(int i = 0; i < 4; i++){
                boolean r_f = false;
                boolean b_f = false;

                int n_rx = c_r_x;
                int n_ry = c_r_y;
                int n_bx = c_b_x;
                int n_by = c_b_y;
                int r_move = 0;
                int b_move = 0;


                while(true){ // 빨강 굴리기
                    if(board[n_rx + dx[i]][n_ry + dy[i]] == '#')break;
                    n_rx += dx[i];
                    n_ry += dy[i];
                    r_move +=1;
                    if(board[n_rx][n_ry] == 'O'){
                        r_f = true;
                        break;
                    }
                }

                while(true){ // 파랑 굴리기
                    if(board[n_bx + dx[i]][n_by + dy[i]] == '#')break;

                    n_bx += dx[i];
                    n_by += dy[i];
                    b_move += 1;
                    if(board[n_bx][n_by] == 'O') {
                        b_f = true;
                        break;
                    }
                }
                if(b_f){
                    continue;
                }

                if(n_rx == n_bx && n_ry == n_by) { // 위치가 겹칠 경우
                    if (r_move < b_move) { // 파랑이 더 많이 움직였을 경우
                        n_bx -= dx[i];
                        n_by -= dy[i];
                    } else {
                        n_rx -= dx[i];
                        n_ry -= dy[i];
                    }
                }

                if(r_f){
                    System.out.println(1);
                    return;
                }

                if (c_r_x == n_rx && c_r_y == n_ry && c_b_x == n_bx && c_b_y == n_by) continue;
                if (!visited[n_rx][n_ry][n_bx][n_by]) {
                    visited[n_rx][n_ry][n_bx][n_by] = true;
                    queue.add(new int[]{n_rx, n_ry, n_bx, n_by, c_cnt + 1});
                }
            }
        }
        System.out.println(0);
    }
}
