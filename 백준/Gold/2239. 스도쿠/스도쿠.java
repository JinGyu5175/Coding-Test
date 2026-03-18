import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int board[][];
	static List<int[]> list;
	static int n = 9;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[n][n];
		list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			String num = br.readLine();
			for(int j = 0; j < n; j++) {
				if(num.charAt(j) == '0') {
					list.add(new int[] {i, j});
				}
				else {
					board[i][j] = num.charAt(j) - 48;
				}
			}
		}
		
//		for(int i = 0; i < 9; i++) {
//			for(int j = 0; j < 9; j++) {
//				System.out.print(board[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		DFS(0);
	}
	
    static void printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
    
    static void DFS(int index) {
        // 모든 빈칸을 다 채운 경우
        if (index == list.size()) {
            printBoard();
            System.exit(0);
        }

        int x = list.get(index)[0];
        int y = list.get(index)[1];

        for (int num = 1; num <= 9; num++) {
            if (canPlace(x, y, num)) {
                board[x][y] = num;
                DFS(index + 1);
                board[x][y] = 0; // 백트래킹
            }
        }
    }
    static boolean canPlace(int x, int y, int num) {
        // 같은 행
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == num) return false;
        }

        // 같은 열
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == num) return false;
        }

        // 3x3 박스
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;

        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }
}
