import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int board[][] = new int[12][6];
		
		for(int i = 0; i < 12; i++) {
			String num = br.readLine();
			for(int j = 0; j < 6; j++) {
				char a = num.charAt(j);
				if(a == '.') {
					board[i][j] = 0;
				}
				else if(a == 'R') {
					board[i][j] = 1;
				}
				else if(a == 'G') {
					board[i][j] = 2;
				}
				else if(a == 'B') {
					board[i][j] = 3;
				}
				else if(a == 'P') {
					board[i][j] = 4;
				}
				else if(a == 'Y') {
					board[i][j] = 5;
				}
			}
		}
//		for(int i = 0; i < 12; i++) {
//			for(int j = 0; j < 6; j++) {
//				System.out.print(board[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		int count = 0;
		int dx[] = {-1, 0, 1, 0};
		int dy[] = {0, 1, 0, -1};
		
		Deque<int[]> queue;
		boolean visited[][];
		boolean change = true;
		while(change) {
			change = false;
			List<Integer> change_list = new ArrayList<>();
			for(int i = 0; i < 12; i++) {
				for(int j = 0; j < 6; j++) {
					if(board[i][j] != 0) {
						visited = new boolean[12][6];
						visited[i][j] = true;
						
						queue = new ArrayDeque<>();
						queue.add(new int[] {i, j});
						
						List<int[]> list = new ArrayList<>();
						list.add(new int[] {i, j});
						
						int color = board[i][j];
						int cnt = 1;
						
						while(!queue.isEmpty()) {
							int num[] = queue.poll();
							int x = num[0];
							int y = num[1];
							
							for(int t = 0; t < 4; t++) {
								int nx = x + dx[t];
								int ny = y + dy[t];
								
								if(nx < 0 || nx >= 12 || ny < 0 || ny >= 6) continue;
								if(visited[nx][ny]) continue;
								if(board[nx][ny] == color) { 
									visited[nx][ny] = true;
									queue.add(new int[] {nx, ny});
									list.add(new int[] {nx, ny});
									cnt++;
								}
							}
						}
						if(cnt >= 4) {
							change = true;
							for(int t = 0; t < list.size(); t++) {
								int x = list.get(t)[0];
								int y = list.get(t)[1];
								board[x][y] = 0;
								change_list.add(y);
							}
						}
					}
				}
			}
			if(change) count++;
			
			for(int t = 0; t < change_list.size(); t++) {
				int arr[] = new int [12];
				int tmp = 0;
				int index = change_list.get(t);
				
				for(int b = 11; b >= 0; b--) {
					if(board[b][index] != 0) {
						arr[tmp] = board[b][index];
						tmp++;
						board[b][index] = 0;
					}
				}
				tmp = 0;
				
				for(int b = 11; b >= 0; b--) {
					if(arr[tmp] == 0) break;
					board[b][index] = arr[tmp];
					tmp++;
				}
			}
			
			
//			for(int i = 0; i < 12; i++) {
//				for(int j = 0; j < 6; j++) {
//					System.out.print(board[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		
		
//		for(int i = 0; i < 12; i++) {
//			for(int j = 0; j < 6; j++) {
//				System.out.print(board[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
		
		System.out.println(count);
	}
}
