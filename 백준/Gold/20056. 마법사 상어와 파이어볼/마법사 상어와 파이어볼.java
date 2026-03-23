
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Fireball{
		int r, c, m, s, d;

		public Fireball(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	static List<Fireball> fireballs = new ArrayList<>();
	static int n, m, k;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 격자 크기
		m = Integer.parseInt(st.nextToken()); // 파이어볼 갯수
		k = Integer.parseInt(st.nextToken()); // k번 이동
		
		//x ,y, m 질량, s 스피드, d 방향
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int mm = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			fireballs.add(new Fireball(r, c, mm, s, d));
		}
		
        for (int turn = 0; turn < k; turn++) {
            move();
        }
        
        int answer = 0;
        for (Fireball fb : fireballs) {
            answer += fb.m;
        }
        System.out.println(answer);
	}
	
	static void move() {
        List<Fireball>[][] board = new ArrayList[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = new ArrayList<>();
            }
        }
        
        for(Fireball fb : fireballs) {
        	int nx = (fb.r + dx[fb.d] * fb.s) % n;
        	int ny = (fb.c + dy[fb.d] * fb.s) % n;

        	if (nx < 0) nx += n;
        	if (ny < 0) ny += n;
        	
        	board[nx][ny].add(new Fireball(nx, ny, fb.m, fb.s, fb.d));
        }
        
        List<Fireball> next = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		if(board[i][j].size() == 0) continue;
        		if(board[i][j].size() == 1) next.add(board[i][j].get(0));
        		else {
        			int count = board[i][j].size();
        			int mount = 0;
        			int speed = 0;
                    boolean allEven = true;
                    boolean allOdd = true;

        			for(Fireball f : board[i][j]) {
        				mount += f.m;
        				speed += f.s;
        				
                        if (f.d % 2 == 0) {
                            allOdd = false;
                        } else {
                            allEven = false;
                        }
        			}
                    int newM = mount / 5;
                    if (newM == 0) continue;
                    
                    int newS = speed / count;
                    int[] dirs;
                    
                    if (allEven || allOdd) {
                        dirs = new int[] {0, 2, 4, 6};
                    } else {
                        dirs = new int[] {1, 3, 5, 7};
                    }

                    for (int d : dirs) {
                        next.add(new Fireball(i, j, newM, newS, d));
                    }
        		}
        	}
        }

        fireballs = next;
	}
}
