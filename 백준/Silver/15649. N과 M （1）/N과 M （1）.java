import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] pick;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(pick[i]);
                if (i + 1 < M) sb.append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = 1; i < N + 1; i++) {
        	if(visited[i]) continue;
        	visited[i] = true;
        	pick[depth] = i;
        	dfs(depth + 1);
        	visited[i] = false;
        }
    }

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N + 1];
		pick = new int[M];
		
		dfs(0);
		System.out.print(sb.toString());
	}
}
