
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
		
		int m = Integer.parseInt(br.readLine());
		
		int order[][] = new int[m][2];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			order[i][0] = Integer.parseInt(st.nextToken());
			order[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int dp[][] = new int[n][n];

		// 길이 1
		for(int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}
		
		// 길이 2
		
		for(int i = 0; i < n - 1; i++) {
			if(nums[i] == nums[i + 1]) {
				dp[i][i + 1] = 1;
			}
		}
		
		// 길이 3
		
		for(int len = 3; len < n + 1; len++) {
			
			for(int start = 0; start < n - len + 1; start++) {
				int end = start + len - 1;
				
				if(nums[start] == nums[end] && dp[start + 1][end - 1] == 1) {
					dp[start][end] = 1;
				}
			}
		}
		
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0 ; i < m; i++){
	        if(dp[order[i][0] - 1][order[i][1] - 1] == 1){
	            sb.append(1);
	            sb.append("\n");
	        }
	        else{
	            sb.append(0);
	            sb.append("\n");
	        }

	    }
	        System.out.println(sb);
	    }
}
