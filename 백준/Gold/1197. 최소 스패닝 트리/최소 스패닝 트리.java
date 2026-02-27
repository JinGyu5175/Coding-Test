import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<int[]> edges = new ArrayList<>();

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if(cost < 0){
                edges.add(new int[]{cost, to, from});
            }
            else{
                edges.add(new int[]{cost, from, to});
            }

        }
        Collections.sort(edges, (a, b) ->a[0] - b[0]);

        parent = new int [v + 1];

        for(int i = 1; i < v + 1; i++){
            parent[i] = i;
        }
        int total = 0;

        for(int[] ee : edges){
            int cost = ee[0];
            int from = ee[1];
            int to = ee[2];

            if(union(from, to)){
                total += cost;
            }
        }
        System.out.println(total);
    }
    static int find(int x){
        if(parent[x] == x) return x;
        else{
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa == pb) return false;
        parent[pb] = pa;
        return true;
    }
}
