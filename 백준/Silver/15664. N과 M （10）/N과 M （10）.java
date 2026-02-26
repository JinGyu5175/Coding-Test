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
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
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
		dfs(0, 0);
	}
	
	static void dfs(int depth, int start) {
		
		if(depth == m) {
			for(int i = 0; i < m; i++) {
				System.out.print(tmp[i] + " ");
			}
			System.out.println();
			return;
		}
	    int prev = Integer.MIN_VALUE;
		for(int i = start; i < n; i++) {
			if (arr[i] == prev) continue;

			tmp[depth] = arr[i];
			prev = arr[i];
			dfs(depth + 1, i+1);

		}
	}
}// 1 7 9 9

