import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Main {
    static int MAX = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if(n >= k){
            System.out.println(n - k);
            return;
        }
        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(n);
        dist[n] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur == k) break;

            int[] nexts = {cur - 1, cur + 1, cur * 2};
            for(int nxt : nexts){
                if(nxt < 0 || nxt > MAX)continue;
                if(dist[nxt] != -1) continue;
                dist[nxt] = dist[cur] + 1;
                q.add(nxt);

            }
        }
        System.out.println(dist[k]);

   }
}
