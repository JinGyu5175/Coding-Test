
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int board[] = new int[n];
		st = new StringTokenizer(br.readLine());
 		for(int i = 0; i < n; i++) {
			board[i] = Integer.parseInt(st.nextToken());
		}
 		
 		int count = 0;
 		for(int mask = 1; mask < (1 << n); mask++) {
 			int total = 0;
 			for(int i = 0 ; i < n; i++) {
 				if((mask &(1 << i)) != 0) {
 					total += board[i];
 				}
 			}
 			if(total == s) {
 				count++;
 			}
 				
 		}
 		System.out.println(count);
	}
}
