import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] cost = new int[N];
        int[] person = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            person[i] = Integer.parseInt(st.nextToken());
        }

        int MAX = C + 100;
        int INF = 1_000_000_000;

        int[] dp = new int[MAX + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = person[i]; j <= MAX; j++) {
                dp[j] = Math.min(dp[j], dp[j - person[i]] + cost[i]);
            }
        }

        int answer = INF;
        for (int i = C; i <= MAX; i++) {
            answer = Math.min(answer, dp[i]);
        }

        System.out.println(answer);
    }
}