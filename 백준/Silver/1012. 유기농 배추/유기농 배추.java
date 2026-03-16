import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Test_case = Integer.parseInt(br.readLine());
			
		for(int p = 0; p < Test_case; p++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			int board[][] = new int[n][m];
			
			for(int i = 0; i < t; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				
				board[x][y] = 1;
			}
			
//			for(int i = 0; i < n; i++) {
//				for(int j = 0 ; j < m; j++) {
//					System.out.print(board[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			int count = 0;
			int dx[] = {-1, 0, 1, 0};
			int dy[] = {0, 1, 0, -1};
			
			boolean visited[][] = new boolean[n][m];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0 ; j < m; j++) {
					if(visited[i][j] == true) continue;
					if(board[i][j] == 0) continue;
					
					visited[i][j] = true;
					Deque<int[]> queue = new ArrayDeque<>();
					queue.add(new int[] {i, j});
					count++;
					while(!queue.isEmpty()) {
						int num[] = queue.poll();
						int x = num[0];
						int y = num[1];
						
						for(int a = 0 ; a < 4; a++) {
							int nx = x + dx[a];
							int ny = y + dy[a];
							if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
							if(board[nx][ny] == 0) continue;
							if(visited[nx][ny] == true) continue;
							
							queue.add(new int[] {nx, ny});
							visited[nx][ny] = true;
						}
					}
				}
			}
			System.out.println(count);
		}
	}
}