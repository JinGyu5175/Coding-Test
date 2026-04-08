
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int home[][];
	static boolean visited[];
	static List<int[]> list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		visited = new boolean[n];
		home = new int[n][2];
		list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			home[i][0] = x;
			home[i][1] = y;
		}
		
		combi(0, 0);
		
		
		int result = Integer.MAX_VALUE;
		
		for(int c[] : list) {
			int cm = -1;
			visited = new boolean[n];
			for(int i = 0; i < k; i++) {
//				System.out.print(c[i] + " ");
				visited[c[i]] = true;
				
			}
//			System.out.println("=========");
			
			
			for(int i = 0; i < n; i++) {
				if(visited[i]) continue;
				int x = home[i][0];
				int y = home[i][1];
				
				int omt = Integer.MAX_VALUE;
				for(int j = 0; j < k; j++) {
					int mx = home[c[j]][0];
					int my = home[c[j]][1];
					
					int distance = Math.abs(x - mx) + Math.abs(y - my);
					if(distance < omt) {
						omt = distance;
					}
				}
				if(cm < omt) {
					cm = omt;
				}
			}
			
			if(result > cm) {
				result = cm;
			}
		}
		System.out.println(result);
	}
	
	static void combi(int level, int start) {
		if(level == k) {
			int arr[] = new int[k];
			int c = 0;
			for(int i = 0; i < n; i++) {
				if(visited[i] == true) {
					arr[c] = i;
					c++;
				}
			}
			list.add(arr);
			return;
		}
		for(int i = start; i < n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			combi(level + 1, i + 1);
			visited[i] = false;
		}
	}
}
