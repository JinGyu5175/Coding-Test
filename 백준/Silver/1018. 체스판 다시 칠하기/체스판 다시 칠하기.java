

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
			
		char board[][] = new char[x][y];
		
		for(int i = 0 ; i < x; i++) {
			String bb = br.readLine();
			for(int j = 0; j < y; j++) {
				
				board[i][j] = bb.charAt(j);
			}
		}
		
		char correct_board1[][] = {{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
								  {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
								  {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
								  {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
								  {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
								  {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
								  {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
								  {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}};
		
		char correct_board2[][] = {{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
				  				   {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
				  				   {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
				  				   {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
				  				   {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
				  				   {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
				  				   {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
				  				   {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}};
		Deque<int[]> queue = new ArrayDeque<>();
		
		for(int i = 0; i < x - 8 + 1; i++) {
			for(int j = 0; j < y - 8 + 1; j++) {
				int start_x = i;
				int start_y = j;
				queue.add(new int[] {i,j});
			}
		}
		int min_value = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			int diff1 = 0;
			int diff2 = 0;
			int num[] = queue.poll();
			int tx = num[0];
			int ty = num[1];
			
			for(int i = tx; i < tx + 8; i++) {
				for(int j = ty; j < ty + 8; j++)
				{
					if(board[i][j] != correct_board1[i - tx][j- ty]) {
						diff1 += 1;
					}
				}
			}
			diff2 = 64 - diff1;
			diff1 = Integer.min(diff1, diff2);
			
			if (diff1 < min_value) {
				min_value = diff1;
			}
		}
		System.out.println(min_value);
		
		
	}
}
