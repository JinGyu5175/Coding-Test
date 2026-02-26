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
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		Deque<int[]> water_queue = new ArrayDeque<>();
		int board[][] = new int[R][C];
		List<int[]> animal = new ArrayList<>();
		for(int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < C; j++) {
				char a = tmp.charAt(j);
				if(a == '.') {
					board[i][j] = 0; // 물
					water_queue.add(new int[] {i, j});
				}
				else if(a == 'L') {
					board[i][j] = 5; // 백조
					animal.add(new int[] {i, j});
					water_queue.add(new int[] {i, j});
				}
				else if(a == 'X') {
					board[i][j] = 1; // 얼음
				}
			}
		}
		
		int dx[] = {0, 1, 0, -1};
		int dy[] = {1, 0, -1, 0};
		int count = 0;
		Deque<int[]> queue = new ArrayDeque<>();
		int a_x = animal.get(0)[0];
		int a_y = animal.get(0)[1];
		boolean visited[][] = new boolean[R][C];
		
		visited[a_x][a_y] = true;		
		queue.add(new int[] {a_x, a_y});
		
		while(true) {
			Deque<int[]> next_water_queue = new ArrayDeque<>();
			Deque<int[]> next_animal_queue = new ArrayDeque<>();
			boolean find = false;
			
			while(!queue.isEmpty()) {
				int num[] = queue.poll();
				int x = num[0];
				int y = num[1];
				
				for(int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
					if(visited[nx][ny]) continue;
					if(board[nx][ny] == 1) {
						next_animal_queue.add(new int[] {nx, ny});
						visited[nx][ny] = true;
						continue;
					}
					
					queue.add(new int[] {nx, ny});
					visited[nx][ny] = true;
					if(board[nx][ny] == 5) {
						find = true;
						break;
					}
				}
				if(find)break;
			}
			queue = next_animal_queue;
			if(find) {
				System.out.println(count);
				break;
			}
			
//			for(int i = 0; i < R; i++) {
//				for(int j = 0; j < C; j++) {
//					System.out.print(board[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			
			while(!water_queue.isEmpty()) {
				int num[] = water_queue.poll();
				int x = num[0];
				int y = num[1];
				
				for(int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
					if(board[nx][ny] == 1) {
						next_water_queue.add(new int[] {nx, ny});
						board[nx][ny] = 0;
					}
				}
			}
			water_queue = next_water_queue;
			count++;
		}
	}
}
