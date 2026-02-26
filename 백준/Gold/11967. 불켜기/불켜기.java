import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int board[][] = new int [n][n];
		board[0][0] = 1;
        @SuppressWarnings("unchecked")
        ArrayList<int[]>[][] sw = new ArrayList[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            if (sw[x][y] == null) sw[x][y] = new ArrayList<>();
            sw[x][y].add(new int[]{a, b});
        }
        
		int dx[] = {0, 1, 0, -1};
		int dy[] = {-1, 0, 1, 0};
		int ex_count = -1;
		while(true) {
			Deque<int[]> queue = new ArrayDeque<>();
			queue.add(new int[] {0, 0});
			
			boolean visited[][] = new boolean[n][n];
			visited[0][0] = true;
			
			int count = 1;
			
			//첫번째 방에서 불키기
			if(board[0][0] == 1) {
				if(sw[0][0] != null) {
					for(int i = 0; i < sw[0][0].size(); i++) {
						int x = sw[0][0].get(i)[0];
						int y = sw[0][0].get(i)[1];
						board[x][y] = 1; // 불만 켜져있음
					}
				}
				board[0][0] = 2; // 불도 켜져있고 스위치도 누름
			}
 			while(!queue.isEmpty()) {
				int num[] = queue.poll();
				int x = num[0];
				int y = num[1];
//				System.out.print(x + " " + y + "||||");
				// 현재 방에서 불키기
				if(board[x][y] == 1) {
					if(sw[x][y] != null) {
						for(int i = 0; i < sw[x][y].size(); i++) {
							int tx = sw[x][y].get(i)[0];
							int ty = sw[x][y].get(i)[1];
							board[tx][ty] = 1; // 불만 켜져있음
						}
					}
					board[x][y] = 2;
				}				
				
				for(int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
					if(visited[nx][ny]) continue;
					if(board[nx][ny] == 0) continue;
					queue.add(new int[] {nx, ny});
					visited[nx][ny] = true;
					if(board[nx][ny] == 0) board[nx][ny] = 1;
					
					count += 1;
				}
			}
// 			System.out.println();
 			if(count == ex_count) {
 				break;
 			}
 			ex_count = count;
		}
		int total = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(board[i][j] != 0) total++;
			}
		}
		System.out.println(total);
	}
}
