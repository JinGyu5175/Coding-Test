import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {

        //x가 3으로 나누어 떨어지면 3으로 나눔
        //x가 2로 나누어 떨어지면 2로 나눔
        // -1 빼기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int []dp = new int[n + 1];
        dp[1] = 0;

        for(int i = 2; i <= n ; i++){
            dp[i] = dp[i - 1] + 1;

            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }
        System.out.println(dp[n]);
    }
}

