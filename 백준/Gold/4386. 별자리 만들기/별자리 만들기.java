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
		parent = new int [n] ;
		double star[][] = new double[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());	
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			star[i][0] = x;
			star[i][1] = y;
		}
		
		List<double[]> edges = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				double f_x = star[i][0];
				double f_y = star[i][1];
				
				double l_x = star[j][0];
				double l_y = star[j][1];
				
				double dist = Math.hypot(f_x - l_x, f_y - l_y);
				
				edges.add(new double[] {dist, i, j});
			}
		}
		Collections.sort(edges, (a, b) -> Double.compare(a[0], b[0]));
		
		for(int i = 0 ; i < n; i++) {
			parent[i] = i;
		}
		double total = 0;
		for(double e[] : edges) {
			double dist = e[0];
			int from = (int) e[1];
			int to = (int) e[2];
			
			if(union(from, to)) {
				total += dist;
			}
		}
		System.out.printf("%.2f", total);
		
		
	}
	
	static int find(int x) {
		if(parent[x] == x) return x;
		parent[x] = find(parent[x]);
		return parent[x];
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa == pb) return false;
		parent[pb] = pa;
		return true;
	}
}
