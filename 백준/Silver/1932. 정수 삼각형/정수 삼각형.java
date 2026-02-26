import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[][] = new int[n][n];
        int max_value = -1;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                if (i == 0 && j == 0) dp[i][0] = Integer.parseInt(st.nextToken()); // 첫 줄
                else if (i != 0 && (j == 0 || j == i)) { // 양쪽 끝
                    if (j == 0) {
                        dp[i][j] = dp[i - 1][j] + Integer.parseInt(st.nextToken());
                    } else if (j == i) {
                        dp[i][j] = dp[i - 1][j - 1] + Integer.parseInt(st.nextToken());
                    }
                } else {
                    dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + Integer.parseInt(st.nextToken());
                }
            }
        }
        for(int i = 0; i < n; i++) {
            if (dp[n - 1][i] > max_value) {
                max_value = dp[n - 1][i];
            }
        }
            System.out.println(max_value);
    }
}

