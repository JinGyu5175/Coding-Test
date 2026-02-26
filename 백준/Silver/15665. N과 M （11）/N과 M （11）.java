import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static int n;
	static int m;
	static int arr[];
	static int tmp[];
	static boolean visited[];
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int [n];
		tmp = new int [m];
		visited = new boolean [n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);;
		dfs(0);
		System.out.println(sb);
	}
	
	static void dfs(int depth) {
		
		if(depth == m) {
			for(int i = 0; i < m; i++) {
				sb.append(tmp[i] + " ");
			}
			sb.append("\n");
			return;
		}
	    int prev = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {

			if(arr[i] == prev) continue;
			tmp[depth] = arr[i];
			prev = arr[i];
			dfs(depth + 1);

		}
	}
}

