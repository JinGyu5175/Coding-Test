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
		int m = Integer.parseInt(st.nextToken()); 
		int T = Integer.parseInt(st.nextToken());
		
		int board[][] = new int[n][m];
		int air[][] = new int[2][2];
		int tmp = 0;
		Deque<int[]> queue = new ArrayDeque<>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				
				if(board[i][j] == -1) {
					air[tmp][0] = i;
					air[tmp][1] = j;
					tmp++;
				}
				
				else if(board[i][j] >= 1) {
					queue.add(new int[] {i, j});
				}
			}
		}
		int dx[] = {0, -1, 0, 1};
		int dy[] = {1, 0, -1, 0};
		
		//t번 반복
		for(int t = 0; t < T; t++) {
			//미세먼지 확산
			List<int[]> add_list = new ArrayList<>();
			while(!queue.isEmpty()) {
				int num[] = queue.poll();
				int x = num[0];
				int y = num[1];
				int dust = board[x][y];

				int move_dust = board[x][y] / 5;
				if(move_dust == 0) continue;
				
				int count = 0;
				for(int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
					if(board[nx][ny] == -1) continue;
					add_list.add(new int[] {nx, ny, move_dust});

					count++;
				}
				add_list.add(new int[] {x, y, -(move_dust * count)});
			}
			
			if(add_list.size() > 0) {
				for(int[] list : add_list) {
					int x = list[0];
					int y = list[1];
					int dust = list[2];
					board[x][y] += dust;
				}
			}
			
//			for(int i = 0; i < n; i++) {
//				for(int j = 0; j < m; j++) {
//					System.out.print(board[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			//upper air
			int direction = 0;
			int before_dust = 0;
			int x = air[0][0];
			int y = air[0][1];
			while(true) {
				int nx = x + dx[direction];
				int ny = y + dy[direction];
				int ot = before_dust;
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
					direction = (direction + 1) % 4;
				}
				x += dx[direction];
				y += dy[direction];
				if(board[x][y] == -1) {
					break;
				}
				before_dust = board[x][y];
				board[x][y] = ot;
			}
			
			//lower air
			direction = 0;
			before_dust = 0;
			x = air[1][0];
			y = air[1][1];
			while(true) {
				int nx = x + dx[direction];
				int ny = y + dy[direction];
				int ot = before_dust;
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
					direction = (direction + 3) % 4;
				}
				x += dx[direction];
				y += dy[direction];
				
				if(board[x][y] == -1) {
					break;
				}
				
				before_dust = board[x][y];
				board[x][y] = ot;

			}
			queue = new ArrayDeque<>();
			for (int i = 0; i < n; i++) {
			    for (int j = 0; j < m; j++) {
			        if (board[i][j] > 0) {
			            queue.add(new int[] {i, j});
			        }
			    }
			}
		}
		
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < m; j++) {
//				System.out.print(board[i][j] + " ");
//			}
//			System.out.println();
//		}
		int result = 0;
	
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(board[i][j] >= 1) {
					result += board[i][j];
				}
			}
		}
		System.out.println(result);
	}
}
