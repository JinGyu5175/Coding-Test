import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static boolean[] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        count = 0;
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        if(m == 0) count --;
        System.out.println(count);
    }
    static void dfs(int idx){
        if(idx == n){
            int sum = 0;
            for(int i = 0; i < n; i++){
                if(visited[i]){
                    sum += arr[i];
                }
            }

            if(sum == m){
                count++;
            }
            return;
        }

        visited[idx] = true;
        dfs(idx + 1);

        visited[idx] = false;
        dfs(idx + 1);

    }
}
