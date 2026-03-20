
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {-1, 0, 1, 0};
	static int board[][];
	static int n;
	static int dust_out = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve();
		
	}
	
	static Deque<int[]> make_root(Deque<int[]> queue){
		int x = n / 2;
		int y = n / 2;
		int direction = 0;
		int length = 1;
		queue.add(new int[] {x, y, direction});
//		System.out.println(x + " " + y + " " + direction);
		boolean end = false;
		
		while(true) {
			for(int i = 0; i < length; i++) {
				x = x + dx[direction];
				y = y + dy[direction];
				if(x == 0 && y == 0) {
					end = true;
					break;
				}
				if(i == length - 1) {
					queue.add(new int[] {x, y, (direction + 1) % 4});
				}
				else {
					queue.add(new int[] {x, y, direction});
				}
			}
			
			if(end) {
				break;
			}
			
			direction = (direction + 1) % 4;

			
			for(int i = 0; i < length; i++) {
				x = x + dx[direction];
				y = y + dy[direction];
				if(i == length - 1) {
					queue.add(new int[] {x, y, (direction + 1) % 4});
				}
				else {
					queue.add(new int[] {x, y, direction});
				}
			}
			direction = (direction + 1) % 4;
			length++;		
		}
		
//		while(!queue.isEmpty()) {
//			int cur[] = queue.poll();
//			System.out.println(cur[0] + " " + cur[1] + " " + cur[2]);
//		}
		return queue;
	}
	
	static void solve() {
		Deque<int[]> queue = new ArrayDeque<>();
		queue = make_root(queue);
		int curx = -1;
		int cury = -1;
		int cdust = -1;
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			
			// 현재 칸의 정보
			int x = cur[0];
			int y = cur[1];
			int direction = cur[2];
			
			// 다음 칸의 위치 및 먼지 양
			int nx = x + dx[direction];
			int ny = y + dy[direction];
			int dust = board[nx][ny];	
			board[nx][ny] = 0;
			int cur_dust_out = 0;
			int total = 0;
			
			// 날라가는 비율따라 계산
			int ud = (direction + 3) % 4;
			int dd = (direction + 1) % 4;
			
			List<int[]> list = new ArrayList<>();
			
			// 위 아래
			// 위
			curx = x + dx[ud];
			cury = y + dy[ud];
			
			cdust = ((dust / 100) * 1);
			list.add(new int[] {curx, cury, cdust});
			
			//아래
			curx = x + dx[dd];
			cury = y + dy[dd];
			cdust = (dust / 100 );
			list.add(new int[] {curx, cury, cdust});
			
			// 앞 위
			curx = x + dx[ud] + dx[direction];
			cury = y + dy[ud] + dy[direction];
			cdust = (dust * 7 / 100 );
			list.add(new int[] {curx, cury, cdust});
			// 앞 위위
			curx = x + dx[ud] + dx[ud] + dx[direction];
			cury = y + dy[ud] + dy[ud] + dy[direction];
			cdust = (dust * 2 / 100);
			list.add(new int[] {curx, cury, cdust});
			
			// 앞 아래
			curx = x + dx[dd] + dx[direction];
			cury = y + dy[dd] + dy[direction];
			cdust = (dust * 7 / 100);
			list.add(new int[] {curx, cury, cdust});
			// 앞 아래아래
			curx = x + dx[dd] + dx[dd] + dx[direction];
			cury = y + dy[dd] + dy[dd] + dy[direction];
			cdust = (dust * 2 / 100);
			list.add(new int[] {curx, cury, cdust});
			
			// 앞 앞 위
			curx = x + dx[ud] + dx[direction] + dx[direction];
			cury = y + dy[ud] + dy[direction] + dy[direction];
			cdust = (dust * 10 / 100);
			list.add(new int[] {curx, cury, cdust});
			// 앞 앞 아래
			
			
			curx = x + dx[dd] + dx[direction] + dx[direction];
			cury = y + dy[dd] + dy[direction] + dy[direction];
			
			cdust = (dust * 10 / 100);
			list.add(new int[] {curx, cury, cdust});
			
			// 앞앞앞
			// 앞 앞 아래
			curx = x + dx[direction] + dx[direction] + dx[direction];
			cury = y + dy[direction] + dy[direction] + dy[direction];
			cdust = (dust * 5 / 100);
			list.add(new int[] {curx, cury, cdust});
			
			for(int c[] : list) {
				int cx = c[0];
				int cy = c[1];
				int cd = c[2];
				
				if(cx >= 0 && cx < n && cy >= 0 && cy < n) {
					board[cx][cy] += cd;
					total += cd;
				}
				else {
					cur_dust_out += cd;
					total += cd;
				}

			}
//			for(int i = 0 ; i < n; i++) {
//				for(int j = 0; j < n; j++) {
//					System.out.print(board[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			if(nx + dx[direction] >= 0 && nx + dx[direction] < n && ny + dy[direction] >= 0 && ny + dy[direction] < n) {
				
				board[nx + dx[direction]][ny + dy[direction]] += dust - total;
			}
			else {
				dust_out += dust - total;
			}
			dust_out += cur_dust_out;
			
			
//			for(int i = 0 ; i < n; i++) {
//				for(int j = 0; j < n; j++) {
//					System.out.print(board[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.exit(0);

		}

		System.out.println(dust_out);
	}
}
