import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int tmp[] = new int [n];
        for(int i = 0; i < n; i++){
            tmp[i] = Integer.parseInt(br.readLine());
        }

        int dp[] = new int[n];
        if(n == 1) {
            System.out.println(tmp[0]);
            return;
        }

        if(n == 2) {
            System.out.println(tmp[0] + tmp[1]);
            return;
        }

        dp[0] = tmp[0];
        dp[1] = dp[0] + tmp[1];
        dp[2] = max(dp[0] + tmp[2], tmp[1] + tmp[2]);
        for(int i = 3; i < n; i++){
            dp[i] = max(dp[i - 2] + tmp[i], dp[i - 3] + tmp[i - 1]+ tmp[i]);
        }
        System.out.println(dp[n - 1]);

    }
}
