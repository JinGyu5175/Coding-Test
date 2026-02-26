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
		
		for(int i = 0; i < n; i++) {
			String sb = br.readLine();
			for(int j = 0; j < m; j++) {
				board[i][j] = sb.charAt(j) - '0';
			}
		}
		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[]{0, 0, 1});
		
		int dx[] = {-1, 0, 1, 0};
		int dy[] = {0, 1, 0, -1};
		int flag[][] = new int[n][m];
		flag[0][0] = 1;
		while(!queue.isEmpty()) {
			int num[] = queue.poll();
			int x = num[0];
			int y = num[1];
			int count = num[2];
			if(x == n - 1 && y == m - 1) {
				System.out.println(count);
				break;
			}
				
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if(flag[nx][ny] == 0 && board[nx][ny] == 1) {
						queue.add(new int[] {nx, ny, count + 1});
						flag[nx][ny] = 1;
					}
				}
			}
		}
		
	}
}
