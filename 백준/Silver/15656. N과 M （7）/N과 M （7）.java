import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int []arr;
	static int []tmp;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		tmp = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());			
		}
		Arrays.sort(arr);
		DFS(0);
		
		System.out.println(sb);
	}
	
	static void DFS(int idx) {
		if(idx == m) {
			for(int i = 0; i < m; i++) {
				
				sb.append(tmp[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0 ; i < n; i++) {
			tmp[idx] = arr[i];
			DFS(idx + 1);
		}
	}
}
