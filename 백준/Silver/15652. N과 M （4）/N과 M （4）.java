
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int n = 0;
	static int m = 0;
	
	
	static void comb(int depth, int start, int[] tmp, int arr[]) {
		if(depth == m) {
			for(int i = 0; i < m; i++) {
				if(i != 0)System.out.print(" ");
				System.out.print(tmp[i]);
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i < n; i++) {
			tmp[depth] = arr[i];
			comb(depth + 1, i, tmp, arr);
		}

		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int arr[] = new int [n];
		for(int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		int tmp[] = new int [m];
		comb(0, 0, tmp, arr);
		
	}
}
