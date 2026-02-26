import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Main{
    static int MAX = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if(n >= k){
            System.out.println(n - k);
            System.out.println(1);
            return;
        }
        int[] dist = new int[MAX + 1];
        int[] ways = new int[MAX + 1];
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(n);
        dist[n] = 0;
        ways[n] = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            
            int[] nexts = {cur - 1, cur + 1, cur * 2}; // 5 -> 4 -> 8 -> 16 -> 17
            for(int nxt : nexts){					//5 10 9 18 17	
            	if (nxt < 0 || nxt > MAX) continue;
            	
                if(dist[nxt] == -1) {
                	dist[nxt] = dist[cur] + 1;
                	ways[nxt] = ways[cur];
                	q.add(nxt);
                }
                
                else if(dist[nxt] == dist[cur] + 1) {
                	ways[nxt] += ways[cur];
                }
                
            }
        }
        System.out.println(dist[k]);
        System.out.println(ways[k]);
    }
}
