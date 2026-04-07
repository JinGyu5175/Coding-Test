
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int board[][] = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max_value = Integer.MAX_VALUE;
		for(int mask = 0; mask < (1 << n); mask++) {
			if(Integer.bitCount(mask) == n / 2) {
				int start = 0, link = 0;
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < n; j++) {
						if(i == j) continue;
						
						if((mask & (1 << i)) != 0 && (mask & (1 << j)) != 0) {
							start += board[i][j];
						}
						
						if((mask & (1 << i)) == 0 && (mask & (1 << j)) == 0) {
							link += board[i][j];
						}
					}
				}
				
				int diff = Math.abs(start - link);
				if(max_value > diff) {
					max_value = diff;
				}
			}
		}
		System.out.println(max_value);
	}
}
