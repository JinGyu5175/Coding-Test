
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

	
public class Main {
	static int board[][];
	static int n;
	// 북 북동 동 동남 남 남서 서 서북
	static int dx [] = {-1, -1, 0, 1, 1, 1, 0, -1}; 
	static int dy [] = {0, 1, 1, 1, 0, -1, -1, -1};
	static int total_cnt = 0;
	
	static void DFS(int idx) {
		if(idx == n) {
			total_cnt ++;
			return;
		}
		
		for(int j = 0; j < n; j++) {
			// board[idx][j] 에 놓을 수 있는지 확인 후 DFS
			if(!check_col(idx, j)) continue; //check_col // 세로 체크
			if(!check_diag(idx, j)) continue; //check_diag // 대각선 체크
			board[idx][j] = 1;
			DFS(idx + 1);
			board[idx][j] = 0;
		}
	}

	static boolean check_col(int x, int y) {
		int nx = x;
		int ny = y;
		boolean flag = true;
		while(flag) {
			nx += dx[0];
			ny += dy[0];
			
			if(nx < 0 || nx >= n || ny < 0 || ny >= n) break;
			if(board[nx][ny] == 1) {
				flag = false;
				return flag;
			}
		}

		return flag;
	}
	
	static boolean check_diag(int x, int y) {
		int nx = x;
		int ny = y;
		
		boolean flag = true;
		while(flag) {
			nx += dx[1];
			ny += dy[1];
			
			if(nx < 0 || nx >= n || ny < 0 || ny >= n) break;
			if(board[nx][ny] == 1) {
				flag = false;
				return flag;
			}
		}
		nx = x;
		ny = y;
		
		while(flag) {
			nx += dx[7];
			ny += dy[7];
			
			if(nx < 0 || nx >= n || ny < 0 || ny >= n) break;
			if(board[nx][ny] == 1) {
				flag = false;
				return flag;
			}
		}
		return flag;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		board = new int[n][n];
		DFS(0);
		System.out.println(total_cnt);		
	}
}
