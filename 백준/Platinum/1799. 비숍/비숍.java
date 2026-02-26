import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int board[][];
    static int tmp[][];
    static int max_count;
    // 북 북동 동 동남 남 남서 서 서북
    static int dx [] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dy [] = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int [n][n];
        max_count = -1;
        tmp = new int [2 * n - 1][2];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()); // 놓을 수 있는 곳 1, 없는 곳 0
            }
        }
        find_tmp();

        dfs(0, 0);
        System.out.println(max_count);
    }
    static void find_tmp() {

        for(int i = 0; i < n; i++) {
            tmp[i][0] = 0;
            tmp[i][1] = i;
        }

        for(int i = n; i < n * 2-1; i++) {

            tmp[i][0] = i - n + 1;
            tmp[i][1] = n - 1;
        }
    }

    static void dfs(int idx, int cnt) {
        if (cnt + (tmp.length - idx) <= max_count) return;
        if(idx == 2 * n - 1) {
//            for(int i = 0 ; i < n; i++) {
//                for(int j = 0; j < n; j++) {
//                    System.out.print(board[i][j] +" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
            if(cnt > max_count) {
                max_count = cnt;

            }
            return;
        }

        int x = tmp[idx][0];
        int y = tmp[idx][1];
        while(true) {
            if(board[x][y] == 1 && check_diag(x, y)) { // 놓을 수 있는 위치 && 대각선에 퀸 없음

                board[x][y] = 4;
                dfs(idx + 1, cnt + 1);
                board[x][y] = 1;
            }

            x = x + dx[5];
            y = y + dy[5];
            if(x < 0 || x >= n || y < 0 || y >= n) break;
        }
        dfs(idx + 1, cnt);


    }

    static boolean check_diag(int x, int y) {
        int nx = x;
        int ny = y;

        boolean flag = true;
//        while(flag) {
//            nx += dx[3];
//            ny += dy[3];
//
//            if(nx < 0 || nx >= n || ny < 0 || ny >= n) break;
//            if(board[nx][ny] == 4) {
//                flag = false;
//                return flag;
//            }
//        }
//        nx = x;
//        ny = y;

        while(flag) {
            nx += dx[5];
            ny += dy[5];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n) break;
            if(board[nx][ny] == 4) {
                flag = false;
                return flag;
            }
        }

//        nx = x;
//        ny = y;
//
//        while(flag) {
//            nx += dx[1];
//            ny += dy[1];
//
//            if(nx < 0 || nx >= n || ny < 0 || ny >= n) break;
//            if(board[nx][ny] == 4) {
//                flag = false;
//                return flag;
//            }
//        }

        nx = x;
        ny = y;

        while(flag) {
            nx += dx[7];
            ny += dy[7];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n) break;
            if(board[nx][ny] == 4) {
                flag = false;
                return flag;
            }
        }
        return flag;
    }
}