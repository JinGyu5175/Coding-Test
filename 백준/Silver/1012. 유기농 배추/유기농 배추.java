import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int z = 0; z < T; z++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int board[][] = new int[n][m];
			for(int j = 0; j < k; j++) {
				StringTokenizer sb = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(sb.nextToken());
				int x = Integer.parseInt(sb.nextToken());
				board[x][y] = 1;		
			}
//			for(int i = 0; i < n; i++) {
//				for(int j = 0; j < m; j++) {
//					System.out.print(board[i][j] + " ");
//				}
//				System.out.println();
//				
//			}
			
			
			int flag[][] = new int[n][m];
			int dx[] = {-1, 0, 1, 0};
			int dy[] = {0, 1, 0, -1};
			
			Deque<int[]> queue = new ArrayDeque<>();
			int count = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(board[i][j] == 1 && flag[i][j] == 0) {
						queue.add(new int[] {i, j});
						flag[i][j] = 1;
						count += 1;
						
						while(!queue.isEmpty()) {
							int num[] = queue.poll();
							int x = num[0];
							int y = num[1];
							
							for(int t = 0; t < 4; t++) {
								int nx = x + dx[t];
								int ny = y + dy[t];
								
								if(nx >= 0 && nx < n && ny >= 0  && ny < m) {
									if(flag[nx][ny] == 0 && board[nx][ny] == 1) {
										flag[nx][ny] = 1;
										queue.add(new int[] {nx, ny});
									}
								}
							}
						}
					}
				}
				
			}
			System.out.println(count);
			
			
		}
		
	}
}
