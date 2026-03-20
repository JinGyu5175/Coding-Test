import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int board[][];
	static int result = Integer.MAX_VALUE;
	static int n, m;
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	static boolean visited[][];
	public static void main(String[] args) throws IOException{
		// 지도에서 0은 빈칸, 6은 벽, 1 ~ 5 CCTV번호
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS();
		System.out.println(result);
	}
	
	// CCTV 번호 1 ~ 5
	static void DFS() {
		int x = -1;
		int y = -1;
		int tmp = -1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(board[i][j] >= 1 && board[i][j] <= 5 && visited[i][j] == false) {
					x = i;
					y = j;
					tmp = board[i][j];
				}
			}
		}
		if(tmp == -1) {
			int count = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(board[i][j] == 0) {
						count++;
					}
				}
			}
			if(count < result) {
				result = count;
			}
		}

		Deque<int[]> queue = new ArrayDeque<>();
		if(tmp == 1) {
			for(int i = 0; i < 4; i++) { // 1번 cctv
				int nx = x;
				int ny = y;
				while(true) {
					nx += dx[i];
					ny += dy[i];
					
					if(nx < 0 || nx >= n || ny < 0 || ny >= m) break;
					if(board[nx][ny] == 6) break;
					if(board[nx][ny] == 0) {
						queue.add(new int[] {nx, ny});
						board[nx][ny] = 7; // 감시하는 곳
					}
				}
//				for(int a = 0; a < n; a++) {
//					for(int b = 0; b < m; b++) {
//						System.out.print(board[a][b] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println();
				
				visited[x][y] = true;
				DFS();
				visited[x][y] = false;
				
				//복원
				while(!queue.isEmpty()) {
					int cur[] = queue.poll();
					int cx = cur[0];
					int cy = cur[1];
					board[cx][cy] = 0;
				}
			}
		}
		else if(tmp == 2) {
			for(int i = 0; i < 2; i++) { // 1번 cctv
				int nx = x;
				int ny = y;
				
				while(true) {
					nx += dx[i];
					ny += dy[i];
					
					if(nx < 0 || nx >= n || ny < 0 || ny >= m) break;
					if(board[nx][ny] == 6) break;
					if(board[nx][ny] == 0) {
						queue.add(new int[] {nx, ny});
						board[nx][ny] = 7; // 감시하는 곳
					}
				}
				
				nx = x;
				ny = y;
				while(true) {
					nx -= dx[i];
					ny -= dy[i];
					
					if(nx < 0 || nx >= n || ny < 0 || ny >= m) break;
					if(board[nx][ny] == 6) break;
					if(board[nx][ny] == 0) {
						queue.add(new int[] {nx, ny});
						board[nx][ny] = 7; // 감시하는 곳
					}
				}
				
				visited[x][y] = true;
				DFS();
				visited[x][y] = false;
				
				//복원
				while(!queue.isEmpty()) {
					int cur[] = queue.poll();
					int cx = cur[0];
					int cy = cur[1];
					board[cx][cy] = 0;
				}
			}
		}
		else if(tmp == 3) {
			for(int i = 0; i < 4; i++) { // 1번 cctv
				int nx = x;
				int ny = y;
				
				while(true) {
					nx += dx[i];
					ny += dy[i];
					
					if(nx < 0 || nx >= n || ny < 0 || ny >= m) break;
					if(board[nx][ny] == 6) break;
					if(board[nx][ny] == 0) {
						queue.add(new int[] {nx, ny});
						board[nx][ny] = 7; // 감시하는 곳
					}
				}
				
				nx = x;
				ny = y;
				while(true) {
					int dd = (i + 1) % 4;
					nx += dx[dd];
					ny += dy[dd];
					
					if(nx < 0 || nx >= n || ny < 0 || ny >= m) break;
					if(board[nx][ny] == 6) break;
					if(board[nx][ny] == 0) {
						queue.add(new int[] {nx, ny});
						board[nx][ny] = 7; // 감시하는 곳
					}
				}
				
				visited[x][y] = true;
				DFS();
				visited[x][y] = false;
				
				//복원
				while(!queue.isEmpty()) {
					int cur[] = queue.poll();
					int cx = cur[0];
					int cy = cur[1];
					board[cx][cy] = 0;
				}
			}
		}
		
		else if(tmp == 4) {
			for(int i = 0; i < 4; i++) { // 1번 cctv
				int nx = x;
				int ny = y;
				
				while(true) {
					nx += dx[i];
					ny += dy[i];
					
					if(nx < 0 || nx >= n || ny < 0 || ny >= m) break;
					if(board[nx][ny] == 6) break;
					if(board[nx][ny] == 0) {
						queue.add(new int[] {nx, ny});
						board[nx][ny] = 7; // 감시하는 곳
					}
				}
				
				nx = x;
				ny = y;
				while(true) {
					int dd = (i + 1) % 4;
					nx += dx[dd];
					ny += dy[dd];
					
					if(nx < 0 || nx >= n || ny < 0 || ny >= m) break;
					if(board[nx][ny] == 6) break;
					if(board[nx][ny] == 0) {
						queue.add(new int[] {nx, ny});
						board[nx][ny] = 7; // 감시하는 곳
					}
				}
				
				nx = x;
				ny = y;
				while(true) {
					int dd = (i + 3) % 4;
					nx += dx[dd];
					ny += dy[dd];
					
					if(nx < 0 || nx >= n || ny < 0 || ny >= m) break;
					if(board[nx][ny] == 6) break;
					if(board[nx][ny] == 0) {
						queue.add(new int[] {nx, ny});
						board[nx][ny] = 7; // 감시하는 곳
					}
				}
				
				visited[x][y] = true;
				DFS();
				visited[x][y] = false;
				
				//복원
				while(!queue.isEmpty()) {
					int cur[] = queue.poll();
					int cx = cur[0];
					int cy = cur[1];
					board[cx][cy] = 0;
				}
			}
		}
		else if(tmp == 5) {
			int nx = x;
			int ny = y;
			
			while(true) {
				nx += dx[0];
				ny += dy[0];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) break;
				if(board[nx][ny] == 6) break;
				if(board[nx][ny] == 0) {
					queue.add(new int[] {nx, ny});
					board[nx][ny] = 7; // 감시하는 곳
				}
			}
			
			nx = x;
			ny = y;
			
			while(true) {
				nx += dx[1];
				ny += dy[1];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) break;
				if(board[nx][ny] == 6) break;
				if(board[nx][ny] == 0) {
					queue.add(new int[] {nx, ny});
					board[nx][ny] = 7; // 감시하는 곳
				}
			}
			
			nx = x;
			ny = y;
			
			while(true) {
				nx += dx[2];
				ny += dy[2];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) break;
				if(board[nx][ny] == 6) break;
				if(board[nx][ny] == 0) {
					queue.add(new int[] {nx, ny});
					board[nx][ny] = 7; // 감시하는 곳
				}
			}
			nx = x;
			ny = y;
			while(true) {
				nx += dx[3];
				ny += dy[3];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) break;
				if(board[nx][ny] == 6) break;
				if(board[nx][ny] == 0) {
					queue.add(new int[] {nx, ny});
					board[nx][ny] = 7; // 감시하는 곳
				}
			}
			
			visited[x][y] = true;
			DFS();
			visited[x][y] = false;
			
			//복원
			while(!queue.isEmpty()) {
				int cur[] = queue.poll();
				int cx = cur[0];
				int cy = cur[1];
				board[cx][cy] = 0;
			}
			
		}
		
		
		return;
	}
}

