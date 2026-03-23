
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static int board[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 세로
		m = Integer.parseInt(st.nextToken()); // 가로
		k = Integer.parseInt(st.nextToken()); // 스티커 갯수
		board = new int[n][m];
		
		for(int t = 0 ; t < k; t++) {
			st = new StringTokenizer(br.readLine());
			int cn = Integer.parseInt(st.nextToken());
			int cm = Integer.parseInt(st.nextToken());
			int [][]sticker = new int[cn][cm];
			
			for(int i = 0; i < cn; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < cm; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i < 4; i++) {
				if(attach(sticker))break;
				else {
					sticker = rotate(sticker);
				}
			}
		}
		int count = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(board[i][j] == 1) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
	static boolean attach(int[][] sticker) {
		// 스티커가 들어가는지 확인
		int cn = sticker.length;
		int cm = sticker[0].length;
		
		boolean find_location = false;
		
		// board에서 x, y가 작은 곳부터 탐색
		for(int i = 0; i <= n - cn; i++) {
		    if (find_location) break;

		    for(int j = 0; j <= m - cm; j++) {
		        boolean cur_location = true;

		        for(int a = 0; a < cn; a++) {
		            for(int b = 0; b < cm; b++) {
		                if(sticker[a][b] == 1 && board[i + a][j + b] == 1) {
		                    cur_location = false;
		                    break;
		                }
		            }
		            if(!cur_location) break;
		        }

		        if(cur_location) {
		            find_location = true;

		            for(int a = 0; a < cn; a++) {
		                for(int b = 0; b < cm; b++) {
		                    if(sticker[a][b] == 1) {
		                        board[i + a][j + b] = 1;
		                    }
		                }
		            }
		            break;
		        }
		    }
		}
		if(find_location) {
			return true;
		}
		else {
			return false;
		}
	}
	static int[][] rotate(int[][] sticker) {
	    int r = sticker.length;
	    int c = sticker[0].length;

	    int[][] temp = new int[c][r];

	    for (int i = 0; i < r; i++) {
	        for (int j = 0; j < c; j++) {
	            temp[j][r - 1 - i] = sticker[i][j];
	        }
	    }
	    return temp;
	}
}
