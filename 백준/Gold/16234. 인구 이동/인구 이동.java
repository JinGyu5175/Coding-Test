
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int board[][] = new int [n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int dx[] = {-1, 0, 1, 0};
		int dy[] = {0, 1, 0, -1};
		Deque<int[]> queue;
		List<int[]> list = null;
		int cnt = 0;
		while(true) {
			int[][] copy_board = new int[n][n];
			for (int i = 0; i < n; i++) copy_board[i] = board[i].clone();
			boolean visited[][] = new boolean[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(visited[i][j] == false) {
						queue = new ArrayDeque<>();
						list = new ArrayList<>();
						list.add(new int[] {i, j});
						
						visited[i][j] = true;
						queue.add(new int[] {i, j});
						
						while(!queue.isEmpty()) {
							int num[] = queue.poll();
							int x = num[0];
							int y = num[1];
							
							for(int k = 0; k < 4; k++) {
								int nx = x + dx[k];
								int ny = y + dy[k];
								
								if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
								if(visited[nx][ny]) continue;
								
								int diff = Math.abs(board[nx][ny] - board[x][y]);
								
								if(diff >= l && diff <= r) {
									visited[nx][ny] = true;
									queue.add(new int[] {nx, ny});
									list.add(new int[] {nx, ny});
								}
							}
						}
					}
					if(list.size() > 1) {
						int sum = 0;
						for(int m = 0; m < list.size(); m++) {
							sum += board[list.get(m)[0]][list.get(m)[1]];
						}
						sum = sum / list.size();
						for(int m = 0; m < list.size(); m++) {
							board[list.get(m)[0]][list.get(m)[1]] = sum;
						}
					}
				}
			}
			boolean flag = true;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(board[i][j] != copy_board[i][j]) {
						flag = false;
					}
				}
			}
			if(flag == true) break;
			cnt ++;
		}
		System.out.println(cnt);
	}
}
