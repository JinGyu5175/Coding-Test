import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int board[][] = new int[n][m];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			for(int j = n - 1; j >= n - num; j--) {
				board[j][i] = 1;
			}
		}
		int rain = 0;
		
		Deque<int[]> queue = new ArrayDeque<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(j + 1 < m) {
					if(board[i][j] == 1 && board[i][j + 1] == 0) {
						queue.add(new int[] {i, j + 1});
					}
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			int x = cur[0];
			int y = cur[1];
			int cur_rain = 1;
			while(y < m) {
				y++;
				if(y >= m) break;
				if(board[x][y] == 0) {
					cur_rain++;
				}
				
				if(board[x][y] == 1) {
					rain += cur_rain;
					break;
				}
			}
		}
		System.out.println(rain);
	}
}
