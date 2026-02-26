import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dy[] = {0, -1, -1, -1, 0, 1, 1, 1};
    static int n = 4;
    static int max_score = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int board[][][] = new int [n][n][2];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++){
                board[i][j][0] = Integer.parseInt(st.nextToken()); // 물고기 번호
                board[i][j][1] = Integer.parseInt(st.nextToken()) - 1; // 방향
            }
        }
        int shark_x = 0;
        int shark_y = 0;
        int shark_d = board[0][0][1];
        int score = board[0][0][0];
        board[0][0][0] = 0;
        board[0][0][1] = 0;
        board = fish_move(board, shark_x, shark_y);

//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                System.out.print(board[i][j][0] + " " + board[i][j][1] + " ");
//            }
//            System.out.println();
//        }
        DFS(shark_x, shark_y, shark_d, board, score);
        System.out.println(max_score);
    }
    static int[][][] copyBoard(int[][][] board) {
        int[][][] newBoard = new int[4][4][2];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                newBoard[i][j][0] = board[i][j][0];
                newBoard[i][j][1] = board[i][j][1];
            }
        }

        return newBoard;
    }

    static void DFS(int shark_x, int shark_y, int shark_d, int [][][]board, int score){

        while(true) {
            int new_board[][][] = copyBoard(board);
            shark_x = shark_x + dx[shark_d];
            shark_y = shark_y + dy[shark_d];

            int tmp_d = shark_d;
            int tmp_s = score;
            if(shark_x < 0 || shark_x >= n || shark_y < 0 || shark_y >= n) break;
            if(board[shark_x][shark_y][0] == 0) continue;
            shark_d = board[shark_x][shark_y][1];
            score += board[shark_x][shark_y][0];
            board[shark_x][shark_y][0] = 0;
            board[shark_x][shark_y][1] = 0;

            board = fish_move(board, shark_x, shark_y);

            DFS(shark_x, shark_y, shark_d, board, score);
            shark_d = tmp_d;
            score = tmp_s;
            board = new_board;

        }

        if(score > max_score){
            max_score = score;
        }
        return;
    }
    static int[][][] fish_move(int [][][]board, int shark_x, int shark_y) {
        for (int f = 1; f <= 16; f++) {
            boolean found = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j][0] == f) {
                        int x = i;
                        int y = j;
                        int direction = board[i][j][1];
                        found = true;
                        for (int t = 0; t < 8; t++) {
                            int n_direction = (direction + t) % 8;
                            int nx = x + dx[n_direction];
                            int ny = y + dy[n_direction];

                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                            if (nx == shark_x && ny == shark_y) continue;

                            if (board[nx][ny][0] == 0) { // 물고기가 없는 곳
                                board[nx][ny][0] = f;
                                board[nx][ny][1] = n_direction;
                                board[x][y][0] = 0;
                                board[x][y][1] = 0;
                                break;
                            } else { // 물고기가 있는 곳 자리 변경
                                int t_num = board[nx][ny][0];
                                int t_d = board[nx][ny][1];

                                board[nx][ny][0] = f;
                                board[nx][ny][1] = n_direction;

                                board[x][y][0] = t_num;
                                board[x][y][1] = t_d;
                                break;
                            }
                        }

                    }
                    if (found) break;
                }
                if (found) break;
            }
        }
        return board;

    }
}
