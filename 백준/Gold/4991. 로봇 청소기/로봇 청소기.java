import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int size;
	static int board[][];
	static List<int[]> dust;
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	static int m;
	static int n;
	static boolean found;
	static int min_value;
    static List<int[]> points; // 0 = 시작점, 1~ = 먼지
    static int dist[][]; // points 사이 최단거리

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			found = false;
			min_value = Integer.MAX_VALUE;
            points = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			if(m == 0 && n == 0) {
				break;
			}
			board = new int [n][m];
			dust = new ArrayList<>();
			int start_x = 0;
			int start_y = 0;
			for(int i = 0 ; i < n; i++) {
				String tmp = br.readLine();
				for(int j = 0; j < m; j++) {
					char a = tmp.charAt(j);
					if(a == 'o') {
						start_x = i;
						start_y = j;
						board[i][j] = 0;
					}
					else if(a == '*') {
						board[i][j] = 0;
						dust.add(new int[] {i, j});
					}
					else if(a == 'x') {
						board[i][j] = 1;
					}
					else {
						board[i][j] = 0;
					}
				}
			}
			size = dust.size();
            // points 구성: 0번은 시작점, 1~size 번은 먼지
            points.add(new int[] {start_x, start_y});
            for (int[] d : dust) {
                points.add(d);
            }
            // 점들 사이 최단거리 계산
            int pSize = size + 1;
            dist = new int[pSize][pSize];
            for (int i = 0; i < pSize; i++) {
                Arrays.fill(dist[i], -1);
            }
            boolean impossible = false;
            
            for (int i = 0; i < pSize; i++) {
                int sx = points.get(i)[0];
                int sy = points.get(i)[1];

                int[][] moveMap = BFS(sx, sy);

                for (int j = 0; j < pSize; j++) {
                    int tx = points.get(j)[0];
                    int ty = points.get(j)[1];
                    dist[i][j] = moveMap[tx][ty];
                }
            }

            // 시작점에서 어떤 먼지라도 못 가면 바로 -1
            for (int i = 1; i <= size; i++) {
                if (dist[0][i] == -1) {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println(-1);
                continue;
            }
            
			boolean visited[] = new boolean[size + 1];
            DFS(0, 0, 0, visited); // 현재 위치 idx, 먹은 개수, 누적거리
            
            if (min_value == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(min_value);
            }
		}
	}
    static int[][] BFS(int sx, int sy) {
        int[][] moveMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(moveMap[i], -1);
        }

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {sx, sy});
        moveMap[sx][sy] = 0;

        while (!queue.isEmpty()) {
            int[] num = queue.poll();
            int x = num[0];
            int y = num[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] == 1) continue; // 벽
                if (moveMap[nx][ny] != -1) continue; // 이미 방문

                moveMap[nx][ny] = moveMap[x][y] + 1;
                queue.add(new int[] {nx, ny});
            }
        }

        return moveMap;
    }
    static void DFS(int cur, int level, int total, boolean[] visited) {
        if (total >= min_value) return; // 가지치기

        if (level == size) {
            min_value = Math.min(min_value, total);
            return;
        }

        // 다음 먼지 선택 (1~size)
        for (int i = 1; i <= size; i++) {
            if (visited[i]) continue;
            if (dist[cur][i] == -1) continue; // 못 가는 경우

            visited[i] = true;
            DFS(i, level + 1, total + dist[cur][i], visited);
            visited[i] = false;
        }
    }
}
