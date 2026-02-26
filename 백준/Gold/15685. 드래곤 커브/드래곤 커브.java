import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, -1, 0, 1};
	static List<Integer> cal(int d, int g) {
		List<Integer> arr = new ArrayList<>();
		arr.add(d);
		for(int t = 0; t < g; t++) {			
			int size = arr.size();
			for(int i = size  -1; i >= 0; i--) {
				int num = arr.get(i);
				num = (num + 1) % 4;
				arr.add(num);
			}
		}
		return arr;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int board[][] = new int [101][101];
		for(int i = 0 ; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			List<Integer> list = cal(d, g);
			board[x][y] = 1;
			for(int j = 0; j < list.size(); j++) {
				int direction = list.get(j);
				x += dx[direction];
				y += dy[direction];
				board[x][y] = 1;
			}
			
//			for(int t = 0; t < board.length; t++) {
//				for(int j = 0; j < board.length; j++) {
//					System.out.print(board[t][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		int count = 0;
		for(int i = 0; i < board.length - 1; i++) {
			for(int j = 0; j < board.length - 1; j++) {
				if(board[i][j] == 1) {
					if(board[i + 1][j] == 1 && board[i][j + 1] == 1 && board[i + 1][j + 1] == 1) {
						count++;
					}
				}
			}
		}
		System.out.println(count);

	}
}
