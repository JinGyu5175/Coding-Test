
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		int n = word.length();
		
        boolean dist[][] = new boolean[n][n];
        
	    // 길이가 1
        for(int i = 0; i < n; i++){
            dist[i][i] = true;
        }

        // 길이가 2
        for(int i = 0 ; i < n - 1; i++){
            if(word.charAt(i) == word.charAt(i + 1)){
                dist[i][i + 1] = true;
            }
        }

        // 길이가 3
        for(int len = 3; len < n + 1; len++){
            for(int start = 0; start < n - len + 1; start++){
                int end = start + len - 1;

                if(word.charAt(start) == word.charAt(end) && dist[start + 1][end - 1]){
                    dist[start][end] = true;
                }
            }
        }
        
        int dp[] = new int[n];
        dp[0] = 1;
        
        for(int i = 1; i < n; i++) {
        	dp[i] = Integer.MAX_VALUE;
        	
        	for(int j = 0; j < n; j++) {
        		if(dist[j][i]) {
        			if(j == 0) dp[i] = 1;
        			else {
        				dp[i] = Math.min(dp[i], dp[j-1] + 1);
        			}
        		}
        	}
        }
        System.out.println(dp[n - 1]);
        
        
		
	}
}
