import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 우주의 갯수
        int n = Integer.parseInt(st.nextToken()); // 우주에 있는 행성 갯수

        int board[][] = new int [m][n];
        int sorted[][] = new int [m][n];
        int unique_board[][] = new int [m][n];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                sorted[i][j] = board[i][j];
            }
        }
        for(int i = 0; i < m; i++)
            Arrays.sort(sorted[i]);

        for(int i = 0; i < m; i++){
            unique_board[i][0] = sorted[i][0];
        }
        int c[] = new int [m];
        for(int i = 0; i < m; i++){
            c[i] = 1;
        }

        for(int i = 0; i < m; i++){
            for (int j = 1; j < n; j++) {
                if(sorted[i][j] != sorted[i][j - 1]) unique_board[i][c[i]++] = sorted[i][j];
            }
        }
        int final_board[][] = new int [m][n];
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                final_board[i][j] = Arrays.binarySearch(unique_board[i],0, c[i], board[i][j]);
            }
        }

        long ans = 0;
        for (int i = 0; i < m; i++) {
            for (int k = i + 1; k < m; k++) {
                boolean same = true;
                for (int j = 0; j < n; j++) {
                    if (final_board[i][j] != final_board[k][j]) {
                        same = false;
                        break;
                    }
                }
                if (same) ans++;
            }
        }
        System.out.println(ans);


//        for(int i = 0; i < m; i++){
//            for(int j = 0; j< n; j++){
//                System.out.print(final_board[i][j] + " ");
//            }
//            System.out.println();
//        }




    }
}
