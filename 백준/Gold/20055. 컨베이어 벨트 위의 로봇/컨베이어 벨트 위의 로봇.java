
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int k;
	static int board[];
	static int robot[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		board = new int [n * 2];
		robot = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n * 2; i++) {
			board[i] = Integer.parseInt(st.nextToken());
		}
		
		
		solve();
	}
	
	static void solve() {
		int result = 1;
		while(true) {
			// 벨트가 로봇과 함께 1칸 이동

//			System.out.println();
			board = move_belt();
			robot = move_robot_with_belt();

			
//			for(int i = 0; i < n; i++) {
//				System.out.print(robot[i]+ " ");
//			}

			// 로봇이 이동 가능시 이동, 이동 안되면 가만히 (앞에 로봇 x, 그칸의 내구도 1이상)
			move_robot();

			// 로봇 올림(올리는 곳에 내구도 0이 아닌 경우)
			make_robot();
			
			// 내구도가 0인 칸의 개수가 k개 이상이면 종료
			boolean check = check_board();
			
			if(check) {
				break;
			}
			
			result++;
//			System.out.println("============");
		}
		System.out.println(result);
	}
	
	static void move_robot() {
		// 로봇이 이동 가능시 이동, 이동 안되면 가만히 (앞에 로봇 x, 그칸의 내구도 1이상)
		
		// 마지막 칸 -1 칸 확인 -> 그 다음 칸 내구도 0 이상이면 삭제하고, 다음 칸 내구도 0
		for(int i = n - 2; i >= 0; i--) {
			if(i == n - 2) {
				if(robot[n - 2] == 1) {
					if(board[n - 1] >= 1) {
						board[n - 1] -=1;
						robot[n - 2] = 0;
					}
				}
			}
			else {
				if(robot[i] == 1) { // 로봇이 있는 자리 체크
					if(board[i + 1] >= 1 && robot[i + 1] == 0) {
						board[i + 1] -= 1;
						robot[i + 1] = 1;
						robot[i] = 0;
					}
				}
			}

		}
	}
	
	static boolean check_board() {
		int cnt = 0;
		for(int i = 0; i < 2 * n; i++) {
			if(board[i] == 0) {
				cnt++;
			}
		}
		if(cnt >= k) {
			return true;
		}
		else {
			return false;
		}
	}
	
	static int[] move_robot_with_belt() {
		int new_robot[] = new int[n];
		for(int i = 0; i < n - 1; i++) {
			new_robot[i + 1] = robot[i];
		}
		return new_robot;
	}
	
	static void make_robot() {
		if(board[0] != 0) {
			robot[0] = 1;
			board[0] -= 1;
		}
		
	}
	
	static int[] move_belt() {
		int prev = 0;
		int new_board[] = new int[2 * n];
		
		for(int i = 0; i < n * 2; i++) {
			if(i != n * 2 -1) {
				new_board[i + 1] = board[i];
			}
			else {
				new_board[0] = board[2 * n - 1];
			}
		}
		
		return new_board;
	}
}
