
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
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int board[][] = new int [n][m];
		List<int[]> empty = new ArrayList<>();
		List<int[]> virus = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 2) {
					virus.add(new int[] {i,j});
				}
				else if(board[i][j] == 0) {
					empty.add(new int[] {i, j});
				}
			}
		}
		
		int dx[] = {-1, 0, 1, 0};
		int dy[] = {0, 1, 0, -1};
		int k = empty.size();
		int max_count = -1;
		for(int a = 0; a < k; a++) {
			for(int b = a + 1; b < k; b++) {
				for(int c = b + 1; c < k; c++) {
					int [][] tmp = copy(board);
					
					int [] A = empty.get(a);
					int [] B = empty.get(b);
					int [] C = empty.get(c);
					
					tmp[A[0]][A[1]] = 1;
					tmp[B[0]][B[1]] = 1;
					tmp[C[0]][C[1]] = 1;
					
					Deque<int[]> queue = new ArrayDeque<>();
					for(int[] vir : virus) {
						queue.add(new int[] {vir[0], vir[1]});
					}
					
					while(!queue.isEmpty()) {
						int num[] = queue.poll();
						int x = num[0];
						int y = num[1];
						
						for(int i = 0; i < 4; i++) {
							int nx = x + dx[i];
							int ny = y + dy[i];
							
							if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
							if(tmp[nx][ny] != 0) continue;
							tmp[nx][ny] = 2;
							queue.add(new int[] {nx, ny});
						}
					}
					int count = 0;
					for(int i = 0; i < n; i++) {
						for(int j = 0; j < m; j++) {
							if(tmp[i][j] == 0) {
								count++;
							}
						}
					}
					
					if(count > max_count) {
						max_count = count;
					}
 				}
			}
		}
		System.out.println(max_count);
		
	}
	static int[][] copy(int[][] src){
		  int[][] dst = new int[src.length][src[0].length];
		  for(int i=0;i<src.length;i++) 
			  dst[i]=src[i].clone();
		  return dst;
		}
}
