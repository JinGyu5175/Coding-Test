import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int dp[] = new int [11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i = 4; i < 11; i++) {
			dp[i] = dp[i-1] + dp[i - 2]  + dp[i - 3];
		}
		
		
		for(int i = 0; i < n; i++) {
			int k = Integer.parseInt(br.readLine());
			System.out.println(dp[k]);
		}
				
	}
}


// dp[1] 1 -> 1

// dp[2] 1,1 	2

// dp[3] 1,1,1	 2, 1	   1, 2    3

// dp[4] 1,1,1,1	2,1,1	1,2,1   3,1    1,1,2     2,2	  1, 3

//
//dp[4] = d[3] + d[2] + d[1]