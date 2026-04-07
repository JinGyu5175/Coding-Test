
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	static int r;
	static int c;
	static int board[][];
	static int ans = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		board = new int[r][c];
		for(int i = 0; i < r; i++) {
			String num = br.readLine();
			for(int j = 0; j < c; j++) { // A는 65
				char a = num.charAt(j); 
				board[i][j] = a - 65;
			}
		}
		
		dfs(0, 0, (1 << board[0][0]), 1);
		System.out.println(ans);
	}
	
	static void dfs(int x, int y, int mask, int count) {
		ans = Math.max(ans, count);
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= r || ny < 0 || ny >= c)continue;

			if((mask & (1 << board[nx][ny])) != 0) continue;

			dfs(nx, ny, mask | (1 << board[nx][ny]), count + 1);
			
		
		}
	}
}
