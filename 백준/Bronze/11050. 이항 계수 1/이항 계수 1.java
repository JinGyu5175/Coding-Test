import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int result = 1;
		int real_m = m;
		for(int i = 0; i < m; i++) {
			result *= n;
			n--;
		}

		for(int i = 0; i < real_m; i++) {
			result = result / m;
			m--;
		}
		System.out.println(result);
		
	}
}
