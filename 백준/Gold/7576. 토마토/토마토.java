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
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		Deque<int[]> queue = new ArrayDeque<>();
		int flag[][] = new int[n][m];
		int board[][] = new int [n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());	
			for(int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1) {
					queue.add(new int[] {i,j});
					flag[i][j] = 1;
				}
			}
		}
		
		int dx[] = {-1, 0, 1, 0};
		int dy[] = {0, 1, 0, -1};
		
		while(!queue.isEmpty()) {
			int num[] = queue.poll();
			int x = num[0];
			int y = num[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < n && ny >= 0 && ny < m && flag[nx][ny] == 0 && board[nx][ny] == 0) {
					flag[nx][ny] = 1;
					board[nx][ny] = board[x][y] + 1;
					queue.add(new int[] {nx, ny});
				}
			}
		}
		
		int max_num = -1;
		boolean f = true;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(board[i][j] == 0) {
					f = false;
				}
				if(board[i][j] >= max_num) {
					max_num = board[i][j];
				}
			}
		}
		if(f) System.out.println(max_num - 1);
		else System.out.println(-1);
		
		
		
	}
}






// 하루 지나면 익은 토마토의 인접한 곳에 토마토가 익음
// 상하 좌우 영향 줌
// 몇일이 지나면 창고에 모든 토마토들이 다 익는지
// 1은 익은 토마토 0은 익지 않은 토마토, -1은 토마토가 들어있지 않은 칸
// 모든 토마토가 익지 못하는 상황일 경우 -1