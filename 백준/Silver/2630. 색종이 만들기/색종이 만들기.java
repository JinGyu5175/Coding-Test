import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int white = 0;
    static int blue = 0;

    static void solve(int x, int y, int n, int board[][]) {
        boolean flag = true;
        int first = board[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (first != board[i][j]) {
                    flag = false;
                    break;
                }
            }
        }
        if(flag){
            if(first == 1) blue++;
            else white++;
            return;
        }

        n = n / 2;
        solve(x, y, n, board);
        solve(x +n, y, n, board);
        solve(x, y + n, n, board);
        solve(x + n, y + n, n, board);

    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int board[][] = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0, 0, n, board);
        System.out.println(white);
        System.out.println(blue);

    }
}
