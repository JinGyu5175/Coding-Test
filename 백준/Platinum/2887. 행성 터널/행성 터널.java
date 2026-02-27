import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int parent[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] list = new int[n][4];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list[i][0] = i;
			list[i][1] =Integer.parseInt(st.nextToken());
			list[i][2] = Integer.parseInt(st.nextToken());
			list[i][3] = Integer.parseInt(st.nextToken());
			
		}
		List<int[]> edges = new ArrayList<>();
		Arrays.sort(list, (a, b) -> Integer.compare(a[1], b[1]));
        for (int i = 0; i < n - 1; i++) {
            int cost = Math.abs(list[i][1] - list[i + 1][1]);
            int from = list[i][0];
            int to = list[i + 1][0];
            edges.add(new int[]{cost, from, to});
        }
        
		Arrays.sort(list, (a, b) -> Integer.compare(a[2], b[2]));
        for (int i = 0; i < n - 1; i++) {
            int cost = Math.abs(list[i][2] - list[i + 1][2]);
            int from = list[i][0];
            int to = list[i + 1][0];
            edges.add(new int[]{cost, from, to});
        }
        
		Arrays.sort(list, (a, b) -> Integer.compare(a[3], b[3]));
        for (int i = 0; i < n - 1; i++) {
            int cost = Math.abs(list[i][3] - list[i + 1][3]);
            int from = list[i][0];
            int to = list[i + 1][0];
            edges.add(new int[]{cost, from, to});
        }
        Collections.sort(edges, (a, b) -> Integer.compare(a[0], b[0]));
        
		parent = new int[n];
		for(int i = 0; i < n; i++) {
			parent[i] = i;
		}
		long total = 0;
		int cnt = 0;
        for (int[] e : edges) {
            int cost = e[0];
            int from = e[1];
            int to = e[2];

            if (union(from, to)) {
                total += cost;
                cnt++;
                if (cnt == n - 1) break;
            }
        }

		System.out.println(total);
		
	}
	static int find(int x) {
		if(parent[x] == x) return x;
		parent[x] = find(parent[x]);
		return parent[x];
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa == pb) {
			return false;
		}
		parent[pb] = pa;
		return true;
	}
	
}
