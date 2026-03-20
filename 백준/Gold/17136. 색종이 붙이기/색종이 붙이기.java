
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

public class Main {
	static int[] paper = {0, 5, 5, 5, 5, 5};
	static int n = 10;
	static int result = Integer.MAX_VALUE;
	static int board[][];
	public static void main(String[] args) throws IOException{
		board = new int[n][n];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		DFS(0);
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(result);
		}
	}
	static void DFS(int count) {
		int x = -1;
		int y = -1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(board[i][j] == 1) {
		            if (board[i][j] == 1) {
		                x = i;
		                y = j;
		                break;
		            }
		        }
			}
			if (x != -1) break;
		}
		
		if(x == -1 && y == -1) {
			if(count < result) {
				result = count;
			}
			return;
		}
		
		for(int size = 5; size >= 1; size--) {
	        if (paper[size] == 0) continue;

	        if (x + size > n || y + size > n) continue;
			boolean find = true;
			
			// size * size 사이즈 색종이 들어가는지 확인
			for(int i = x; i < x + size; i++) {
				for(int j = y; j < y + size; j++) {
					if(board[i][j] == 0) {
						find = false;
						break;
					}
				}
				if(find == false) {
					break;
				}
			}
			
			if(find == false) { //크기 안맞음
				continue;
			}
			else { // 크기 일치
				for(int i = x; i < x + size; i++) { // 색종이로 채우기
					for(int j = y; j < y + size; j++) {
						board[i][j] = 0;
					}
				}
		        paper[size]--;
				DFS(count + 1);
				
				for(int i = x; i < x + size; i++) { // 복원
					for(int j = y; j < y + size; j++) {
						board[i][j] = 1;
					}
				}
			}
	        paper[size]++;
		}
		
		return;
	}
}
