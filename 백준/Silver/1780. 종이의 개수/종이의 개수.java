import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int minus = 0;
    static int plus = 0;
    static int zero = 0;
    static void solve(int x, int y, int size, int [][]board){
        boolean f = true;
        int first = board[x][y];
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(first != board[i][j]) {
                    f = false;
                    break;
                }
            }
        }

        if(f){
            if(first == -1) minus++;
            else if(first == 0) zero++;
            else if(first == 1) plus++;
            return;
        }

        size = size / 3;

        solve(x, y, size, board);
        solve(x, y+size, size, board);
        solve(x, y+size*2, size, board);
        solve(x+size, y, size, board);
        solve(x+size*2, y, size, board);
        solve(x+size, y+size, size, board);
        solve(x+size*2, y+size, size, board);
        solve(x+size, y+size*2, size, board);
        solve(x+size*2, y+size*2, size, board);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int board[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0, 0, n, board);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }
}
