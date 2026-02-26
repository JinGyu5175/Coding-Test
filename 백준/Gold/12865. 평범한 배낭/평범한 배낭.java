
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int k;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n + 1][k + 1];
        // dp[i][w] = i번째 물건까지 고려했을 때, 무게 w에서 최대 가치

        int[] W = new int[n + 1];
        int[] V = new int[n + 1];

		for(int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());

		}
		for(int i = 1; i <= n; i++) {
			for(int w = 0; w <= k; w++) {
				dp[i][w] = dp[i - 1][w];
				if(w >= W[i]) {
					dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - W[i]] + V[i]); // 넣기
				}
			}
		}
		System.out.println(dp[n][k]);
	}
}
