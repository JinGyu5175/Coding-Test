
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, d;
	static List<int[]> people;
	static int[] archer = new int[3];
	static int people_num = 0;
	static int kill_result = -1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		people = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					people.add(new int[] {i, j});
					people_num++;
				}
			}
		}
		
		solve();
		System.out.println(kill_result);
	}
	
	static void solve() {
		// 궁수의 위치 정하기
		DFS(0, 0);
	}
	
	static void DFS(int start, int depth) {
		if(depth == 3) {
			calcu();
			return;
		}
		
		for(int i = start; i < m; i++) {
			archer[depth] = i;
			DFS(i + 1, depth + 1);
		}
	}
	// 모두 죽었을때 미리끝내야함
	
	static void calcu() {
		List<int[]> ot_people = new ArrayList<>();
		for (int[] p : people) {
		    ot_people.add(new int[] {p[0], p[1]});
		}
		int kill_count = 0;
		while(true) {
			// 활쏘기
			int ot[][] = new int[ot_people.size()][2]; // 적 후보
			
			for(int i = 0; i < ot_people.size(); i++) {
				ot[i][0] = ot_people.get(i)[0];
				ot[i][1] = ot_people.get(i)[1];
			}
			
			int kill[][] = new int[3][2];
			
			for(int i = 0; i < 3; i++) {
				int a_x = n;
				int a_y = archer[i];
				int distance = Integer.MAX_VALUE;
				int c_x = -1;
				int c_y = -1;
//				System.out.println(a_x + " " + a_y);
				for(int j = 0; j < ot.length; j++) {
					int tmp = Math.abs(a_x - ot[j][0]) + Math.abs(a_y - ot[j][1]);
					if(tmp > d) continue;
					if(tmp < distance || (tmp == distance && ot[j][1] < c_y)) {
						distance = tmp;
						c_x = ot[j][0];
						c_y = ot[j][1];
					}
				}
				
				kill[i][0] = c_x;
				kill[i][1] = c_y;
//				System.out.println(c_x + " " + c_y);
			}
			
			for(int i = 0; i < 3; i++) {
				int x = kill[i][0];
				int y = kill[i][1];
				for(int j = 0; j < ot_people.size(); j++) {
					int px = ot_people.get(j)[0];
					int py = ot_people.get(j)[1];
					
					if(x == px && y == py) {
						ot_people.remove(j);
						kill_count++;
						break;
					}
				}
			}
			
			// 이동
			
			List<int[]> new_people = new ArrayList<>();
			
			for(int cur[] : ot_people) {
				int x = cur[0] + 1;
				int y = cur[1];
				
				if(x == n) {
					continue;
				}
				else {
					new_people.add(new int[] {x, y});
				}
			}
			if(new_people.size() == 0) {
				break;
			}
			ot_people = new_people;
		}
		if(kill_result < kill_count) {
			kill_result = kill_count;
		}
		
//		for(int cur[]: people) {
//			System.out.println(cur[0] + " " + cur[1]);
//		}
//		System.exit(0);
		
 	}
}
