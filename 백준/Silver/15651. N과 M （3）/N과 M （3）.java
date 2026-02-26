import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static boolean []visited;
    static int []result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        result = new int[m];
        DFS(0, 1);
        System.out.println(sb);
    }

    static void DFS(int depth, int start){
        if(depth == m){
            for(int i = 0; i < m; i++){
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i < n + 1; i++){

            result[depth] = i;
            DFS(depth + 1, start);

        }
    }

}
