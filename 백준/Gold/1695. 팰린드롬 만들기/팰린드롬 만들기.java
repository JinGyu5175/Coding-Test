
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int nums[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[][] = new int[n][n];
		
		for(int len = 2; len < n + 1; len++) {
			for(int start = 0; start < n - len + 1; start++) {
				int end = start + len - 1;
				
				if(nums[start] == nums[end]) {
					if(len == 2) dp[start][end] = 0;
					else {
						dp[start][end] = dp[start + 1][end - 1];
					}
				}
				else {
					dp[start][end] = Math.min(dp[start + 1][end], dp[start][end- 1]) + 1;
				}
			}
		}
		System.out.println(dp[0][n - 1]);
	}
}
