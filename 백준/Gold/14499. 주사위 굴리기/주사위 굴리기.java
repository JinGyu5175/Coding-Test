import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
//		int order[] = new int [k];
		
		int board[][] = new int [n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		// 동 1, 서 2, 북 3, 남 4
		
		int dx[] = {0, 0, -1, 1};
		int dy[] = {1, -1, 0, 0};
		
		for(int i = 0; i < k; i++) {
			int order = Integer.parseInt(st.nextToken());
						
			// 위치 이동
			int nx = x + dx[order - 1];
			int ny = y + dy[order - 1];
			
			if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
			
			// 주사위 굴리기
			if(order == 1) {
				roll_dice_east(dice);
			}
			else if(order == 2) {
				roll_dice_west(dice);
			}
			else if(order == 3) {
				roll_dice_north(dice);
			}
			else {
				roll_dice_south(dice);
			}
			
			if(board[nx][ny] == 0) board[nx][ny] = dice[6]; // 바닥이 0이면 주사위의 아랫면 숫자를 바닥에 넣기
			else { 
				dice[6] = board[nx][ny];
				board[nx][ny] = 0;
			}		
			System.out.println(dice[1]);
			x = nx;
			y = ny;
		}
	}
}
