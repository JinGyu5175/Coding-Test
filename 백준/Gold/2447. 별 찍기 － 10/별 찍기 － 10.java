import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static void solve(int x, int y, int size, char [][]board){
        if(size == 1) return;
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                board[i][j] = '*';
            }
        }

        for(int i = x + (size / 3); i < x + (size / 3) * 2; i++){
            for(int j = y + (size / 3); j < y + (size / 3) * 2; j++){
                board[i][j] = ' ';
            }
        }

        size = size / 3;

        solve(x, y, size, board);
        solve(x, y + size, size, board);
        solve(x, y + size * 2, size, board);
        solve(x + size, y, size, board);
        solve(x + size, y + size * 2, size, board);
        solve(x + size * 2, y, size, board);
        solve(x + size * 2, y + size, size, board);
        solve(x + size * 2, y + size * 2, size, board);


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        char board[][] = new char[n][n];

        solve(0, 0, n, board);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
