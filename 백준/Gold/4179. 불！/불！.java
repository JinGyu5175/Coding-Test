import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int board[][] = new int [R][C];
		Deque<int[]> fire = new ArrayDeque<>();
		Deque<int[]> human = new ArrayDeque<>();

		for(int i = 0; i < R; i++) {
			String num = br.readLine(); 
			for(int j = 0; j < C; j++) {
				char a = num.charAt(j);
				if(a == '#') {
					board[i][j] = 1; // 벽
				}
				else if(a == 'J'){
					board[i][j] = 2; // 현재 위치
					human.add(new int[] {i, j});
				}
				else if(a == 'F') {
					board[i][j] = 3; // 불
					fire.add(new int[] {i, j});
				}
				else {
					board[i][j] = 0; // 이동 가능 공간
				}
			}
		}
		int []dx = {-1, 0, 1, 0};
		int []dy = {0, 1, 0, -1};
		// 벽 1,  사람 2, 불 3, 이동 가능 공간 0
		int count = 0;
		boolean break_can = false;
		while(!human.isEmpty()) {
			int human_size = human.size();
			int fire_size = fire.size();
			
			for(int i = 0; i < fire_size; i++) {
				int fire_info[] = fire.poll();
				int x = fire_info[0];
				int y = fire_info[1];
				
				for(int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
					if(board[nx][ny] != 0) continue;
					fire.add(new int[] {nx, ny});
					board[nx][ny] = 3;
				}
			}
			break_can = false;
			for(int i = 0; i < human_size; i++) {
				int human_info[] = human.poll();
				int x = human_info[0];
				int y = human_info[1];
				
				// 탈출 조건 확인
				if(x == R - 1 || y == C - 1 || x == 0 || y == 0) {
					System.out.println(count + 1);
					break_can = true;
					break;
				}
				
				for(int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
					if(board[nx][ny] != 0) continue;
					human.add(new int[] {nx, ny});
					board[nx][ny] = 2;
				}
			}
			
			count += 1;
			if(break_can) {
				break;
			}
		}
		
		if(!break_can) {
			System.out.println("IMPOSSIBLE");
		}
	}
}
