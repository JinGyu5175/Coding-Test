
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int parent[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<long[]> edges = new ArrayList<>();
		
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (i < j) { // 중복 제거
                    edges.add(new long[]{cost, i, j});
                }
            }
        }
        Collections.sort(edges, (a, b) -> Long.compare(a[0], b[0]));
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        long total = 0;
		for(long ee[] : edges) {
			long c = ee[0];
			long f = ee[1];
			long t = ee[2];
			
			if(union(f, t)) {
				total += c;
			}
		}
		System.out.println(total);
	}
	static long find(long x) {
		if(parent[(int) x] == x) return x;
		else {
			parent[(int) x] = (int) find(parent[(int) x]);
			return parent[(int) x];
		}
	}
	static boolean union(long a, long b) {
		long pa = find(a);
		long pb = find(b);
		
		if(pa == pb) return false;
		parent[(int) pb] = (int) pa;
		return true;
 	}

}
