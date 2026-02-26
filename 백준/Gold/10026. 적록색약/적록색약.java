import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int board[][] = new int [n][n];
		
		for(int i = 0 ; i < n; i++) {
			String st = br.readLine();
			for(int j = 0; j < n; j++) {
				if(st.charAt(j) == 'R') { // 0
					board[i][j] = 0;
				}
				else if (st.charAt(j) == 'G') { // 1
					board[i][j] = 1;
				}
				else if (st.charAt(j) == 'B') { // 2
					board[i][j] = 2;
				}
			}
		}
		int dx[] = {-1, 0, 1, 0};
		int dy[] = {0, 1, 0, -1};
		
		int flag[][] = new int[n][n];
		int cnt = 0;
		
		// 일반인 
		for(int i = 0; i < n; i++) { // 전체 칸 탐색
			for(int j = 0; j < n; j++) {
				if(flag[i][j] == 0) { // 대신 방문한 적 없는 곳만 방문!
					Deque<int[]> queue = new ArrayDeque<>();
					queue.add(new int[] {i,j});
					flag[i][j] = 1;
					cnt += 1;
					
					while(!queue.isEmpty()) {
						int []num = queue.poll();
						int x = num[0];
						int y = num[1];
						
						for(int k = 0; k < 4; k++){
							int nx = x + dx[k];
							int ny = y + dy[k];
							
							if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
								if(flag[nx][ny] == 0 && board[x][y] == board[nx][ny]) {
									queue.add(new int[] {nx, ny});
									flag[nx][ny] = 1;
								}
							} 
						}
					}
				}
			}
		}
		System.out.print(cnt + " ");
		
		// 적록색맹
		for(int i = 0 ; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(board[i][j] == 1) {
					board[i][j] = 0;
				}
			}
		}
		
		int flag2[][] = new int[n][n];
		int cnt2 = 0;
		
		
		for(int i = 0; i < n; i++) { // 전체 칸 탐색
			for(int j = 0; j < n; j++) {
				if(flag2[i][j] == 0) { // 대신 방문한 적 없는 곳만 방문!
					Deque<int[]> queue = new ArrayDeque<>();
					queue.add(new int[] {i, j});
					flag2[i][j] = 1;
					cnt2 += 1;
					
					while(!queue.isEmpty()) {
						int []num = queue.poll();
						int x = num[0];
						int y = num[1];
						
						for(int k = 0; k < 4; k++){
							int nx = x + dx[k];
							int ny = y + dy[k];
							
							if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
								if(flag2[nx][ny] == 0 && board[x][y] == board[nx][ny]) {
									queue.add(new int[] {nx, ny});
									flag2[nx][ny] = 1;
								}
							} 
						}
					}
				}
			}
		}
		System.out.print(cnt2);
	}		
}


// 정상인 -> 빨 파 초
// 적록색약 -> 빨 & 초 파 