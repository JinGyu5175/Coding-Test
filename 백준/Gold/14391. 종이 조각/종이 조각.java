
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int nm = n * m;
		int board[][] = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			String num = br.readLine();
			for(int j = 0; j < m; j++) {
				int a = (int)num.charAt(j) - 48;
				board[i][j] = a;
			}
		}
		
		
		
		int ans = -1;
		
		for(int mask = 0; mask < (1 << nm); mask++) {
			int sum = 0;
			
			// 가로 방향 숫자 계산
			for(int i = 0; i < n; i++) {
				int num = 0;
				for(int j = 0; j < m; j++) {
					int bit = (mask >> (i * m + j)) & 1;
					if(bit == 0) {
						num = num * 10 + board[i][j];
					}
					else {
						sum += num;
						num = 0;
					}
					
				}
				sum += num;
			}
            // 세로 방향 숫자 계산 (비트가 1인 칸들)
            for (int j = 0; j < m; j++) {
                int num = 0;
                for (int i = 0; i < n; i++) {
                    int bit = (mask >> (i * m + j)) & 1;
                    if (bit == 1) {  // 세로
                        num = num * 10 + board[i][j];
                    } else {  // 가로 만나면 지금까지 숫자 더하고 리셋
                        sum += num;
                        num = 0;
                    }
                }
                sum += num;  // 열 끝나면 남은 숫자 더하기
            }

            ans = Math.max(ans, sum);
        }

        System.out.println(ans);

		
	}
}
		
		
		
		
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < m; j++) {
//				System.out.print(board[i][j] + " ");
//			}
//			System.out.println();
//		}

