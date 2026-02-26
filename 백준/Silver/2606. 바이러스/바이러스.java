import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n = 0;
    static int m = 0;
    static int infect = 0;
    static void find_route(int start, List<Integer>[] g, boolean flag[]){
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        flag[start] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int nxt : g[cur]){
                if(flag[nxt] == false) {
                    flag[nxt] = true;
                    queue.add(nxt);
                    infect += 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        List<Integer>[] g = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++) g[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);
            g[b].add(a);
        }
        boolean flag[] = new boolean[n + 1];

        find_route(1, g, flag);



        System.out.println(infect);






    }
}
