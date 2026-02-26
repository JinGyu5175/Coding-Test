import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int s_num;
    static int d_num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            s_num = Integer.parseInt(st.nextToken());
            d_num = Integer.parseInt(st.nextToken());

            sb.append(solve(s_num, d_num)).append('\n');

        }
        System.out.print(sb);
    }

    static String solve(int start, int target){
        boolean[] visited = new boolean[10000];
        int[] prev = new int[10000];      // 이전 숫자
        char[] how = new char[10000];     // 어떤 연산으로 왔는지 (D,S,L,R)

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        prev[start] = -1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == target) break;

            int nxt;

            nxt = orderD(cur);
            if (!visited[nxt]) {
                visited[nxt] = true;
                prev[nxt] = cur;
                how[nxt] = 'D';
                queue.add(nxt);
            }

            nxt = orderS(cur);
            if (!visited[nxt]) {
                visited[nxt] = true;
                prev[nxt] = cur;
                how[nxt] = 'S';
                queue.add(nxt);
            }

            nxt = orderL(cur);
            if (!visited[nxt]) {
                visited[nxt] = true;
                prev[nxt] = cur;
                how[nxt] = 'L';
                queue.add(nxt);
            }

            nxt = orderR(cur);
            if (!visited[nxt]) {
                visited[nxt] = true;
                prev[nxt] = cur;
                how[nxt] = 'R';
                queue.add(nxt);
            }
        }
        StringBuilder path = new StringBuilder();

        int cur = target;
        while (cur != start) {
            path.append(how[cur]);
            cur = prev[cur];
        }
        return path.reverse().toString();
    }
    static int orderD(int input){
        return (input * 2) % 10000;
    }
    static int orderS(int input){
        if(input == 0) return 9999;
        else return (input - 1);
    }
    static int orderL(int input){
        return (input % 1000) * 10 + (input / 1000);

    }
    static int orderR(int input){
        return (input % 10) * 1000 + (input / 10);
    }
}
