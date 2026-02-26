import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static void solve(int x, int y, int size, char board[][]){
        if(size == 3) {
            board[x][y] = '*';
            board[x + 1][y - 1] = '*';
            board[x + 1][y + 1] = '*';

            for (int j = y - 2; j <= y + 2; j++) board[x + 2][j] = '*';
            return;
        }

        size = size / 2;

        solve(x, y, size, board);
        solve(x + size, y - size, size, board);
        solve(x + size, y + size, size, board);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        char board[][] = new char [n][n * 2 -1];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n * 2 - 1; j++) {
                board[i][j] = ' ';
            }
        }
        solve(0, n - 1, n, board);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n * 2 - 1; j++){
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
