import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int board[] = new int [n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			board[i] = Integer.parseInt(st.nextToken());
		}
		int first = 0;
		int last = n - 1;
		int min_count  = Integer.MAX_VALUE;
		int left = -1;
		int right = -1;
		while(first != last) {
			int sum = board[first] + board[last];
			if(Math.abs(sum) < min_count) {
				min_count = Math.abs(sum);
				left = board[first];
				right = board[last];
			}
			if(sum < 0) {
				first++;
			}
			else {
				last--;
			}
			

		}
		System.out.println(left + " " + right);
	}
}
