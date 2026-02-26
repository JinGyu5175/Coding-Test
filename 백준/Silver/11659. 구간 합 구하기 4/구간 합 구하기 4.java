import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int arr[] = new int [n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[] = new int [n+1];
		dp[0] = 0;
		dp[1] = arr[0];
		for(int i = 2; i < n+1; i++) {
			dp[i] = dp[i - 1] + arr[i - 1];
			
		}
		
		

		
		for(int t = 0; t < m; t++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			
			int sum = dp[end+1] - dp[start];
			System.out.println(sum);
		}
		
		
	}
// 2, 4 dp[3] - d[0]
}
