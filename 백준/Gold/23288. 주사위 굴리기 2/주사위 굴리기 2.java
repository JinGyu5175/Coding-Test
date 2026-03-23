import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int []dice = {0, 0, 0, 0, 0, 0, 0}; // 실제로 1~6만 사용
	public static void roll_dice_east(int []dice) {
		int tmp = dice[1];
		dice[1] = dice[4];
		dice[4] = dice[6];
		dice[6] = dice[3];
		dice[3] = tmp;
	}
	
	public static void roll_dice_west(int []dice) {
		int tmp = dice[1];
		dice[1] = dice[3];
		dice[3] = dice[6];
		dice[6] = dice[4];
		dice[4] = tmp;
	}
	
	public static void roll_dice_north(int []dice) {
		int tmp = dice[1];
		dice[1] = dice[5];
		dice[5] = dice[6];
		dice[6] = dice[2];
		dice[2] = tmp;
	}
	
	public static void roll_dice_south(int []dice) {
		int tmp = dice[1];
		dice[1] = dice[2];
		dice[2] = dice[6];
		dice[6] = dice[5];
		dice[5] = tmp;
	}
	
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	static int score = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken()); // 이동하는 횟수
		
		int board[][] = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i < 7; i++) {
			dice[i] = i;
		}
		
		int direction = 1;
		int x = 0;
		int y = 0;
		
		for(int i = 0; i < k; i++) {

			
			int nx = x + dx[direction];
			int ny = y + dy[direction];
			
			if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
				nx = x - dx[direction];
				ny = y - dy[direction];
				direction = (direction + 2) % 4;
			}
			
			if(direction == 0) {
				roll_dice_north(dice);
			}
			else if(direction == 1) {
				roll_dice_east(dice);
			}
			else if(direction == 2) {
				roll_dice_south(dice);
			}
			else if(direction == 3) {
				roll_dice_west(dice);
			}
			
			int num = board[nx][ny];
			
			Deque<int[]> queue = new ArrayDeque<>();
			queue.add(new int [] {nx, ny});
			boolean visited[][] = new boolean[n][m];
			visited[nx][ny] = true;
			int count = 1;
			
			while(!queue.isEmpty()) {
				int cur[] = queue.poll();
				int cx = cur[0];
				int cy = cur[1];
				
				for(int a = 0; a < 4; a++) {
					 
					int mx = cx + dx[a]; 
					int my = cy + dy[a];
					
					if(mx < 0 || mx >= n || my < 0 || my >= m) continue;
					if(visited[mx][my] == true) continue;
					if(board[mx][my] != num) continue;
					
					queue.add(new int[] {mx, my});
					visited[mx][my] = true;
					count++;
				}
			}
			
			score += num * count;
			
			// 방향 설정
			
			// 아랫면 -> dice[6] - > A
			if(dice[6] > num) {
				direction = (direction + 1) % 4;
			}
			else if(dice[6] < num) {
				direction = (direction + 3) % 4;
			}
			x = nx;
			y = ny;
		}
		
		System.out.println(score);
	}
}
