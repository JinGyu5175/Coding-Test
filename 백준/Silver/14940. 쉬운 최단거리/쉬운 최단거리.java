
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
		int start_x = 0;
		int start_y = 0;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 2) {
					start_x = i;
					start_y = j;
				}
			}
		}
		
		int result[][] = new int [n][m];
		
		int flag[][] = new int [n][m];
		int dx[] = {-1, 0, 1, 0};
		int dy[] = {0, 1, 0, -1};
		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {start_x, start_y});
		flag[start_x][start_y] = 1;
		
		while(!queue.isEmpty()) {
			int num[] = queue.poll();
			int x = num[0];
			int y = num[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >=0 && nx < n && ny >= 0 && ny < m) {
					if(flag[nx][ny] == 0 && board[nx][ny] == 1) {
						flag[nx][ny] = 1;
						queue.add(new int [] {nx, ny});
						result[nx][ny] = result[x][y] + 1;
					}
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(board[i][j] != 0 && board[i][j] != 2 && result[i][j] == 0)
				    result[i][j] = -1;
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(j != 0) System.out.print(" ");
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}
}
