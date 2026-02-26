import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int board[][] = new int [n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {r, c, d});
		int cnt = 0;
		while(!queue.isEmpty()) {
			int info[] = queue.poll();
			int x = info[0];
			int y = info[1];
			int direction = info[2];
			
			// 현재 칸 청소
			if(board[x][y] == 0) {
				board[x][y] = 2;
				cnt++;
			}
			
			// 현재 칸 주변 4칸 중 청소되지 않은 빈칸이 있는지 탐색
			boolean find = false;
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue; // 격자 벗어날 경우
				if(board[nx][ny] == 1 || board[nx][ny] == 2) continue; // 벽이거나 청소 한 곳일 경우
				find = true;
			}
			// 현재 칸 주변 4칸 중 청소되지 않은 빈칸이 있는 경우
			if(find) {
				direction = (direction + 3) % 4;
				int nx = x + dx[direction];
				int ny = y + dy[direction];
				if(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
					queue.add(new int[] {nx, ny, direction});
				}
				else {
					queue.add(new int[] {x, y, direction});
				}
			}
			
			// 현재 칸 주변 4칸 중 청소되지 않은 빈칸이 없는 경우
			else {
				int nx = x - dx[direction];
				int ny = y - dy[direction];
				if(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] != 1) {
					queue.add(new int[] {nx, ny, direction});
				}
			}
		}
		System.out.println(cnt);
		
		
		
		
	}
}
