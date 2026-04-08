
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int count = 0;
		int board[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			board[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(board);
		int start = 0;
		int end = n - 1;
		
		while(start < end) {
			int sum = board[start] + board[end];
			if(sum == m) {
				end--;
				count++;
				start++;
			}
			else if(sum < m) {
				start++;
			}
			else{
				end--;
			}
		}
		System.out.println(count);
 	}
}
