import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static boolean[] visited;
    static int[] result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        visited = new boolean[n];
        result = new int[m];
        DFS(0);
    }
    static void DFS(int depth){
        if(depth == m){
            for(int i = 0; i < m; i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < n; i++){
            if(visited[i])continue;
            visited[i] = true;
            result[depth] = arr[i];
            DFS(depth + 1);
            visited[i] = false;
        }
    }
}
