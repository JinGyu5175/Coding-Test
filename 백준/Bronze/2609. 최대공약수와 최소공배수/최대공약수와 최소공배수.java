import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int max = 0;
		List<Integer> f_r = new ArrayList<>();
		List<Integer> s_r = new ArrayList<>();
		
		for(int i = 1; i <= n && i <= m; i++) {
			if(n % i ==0 && m % i ==0) {
				max = i;
			}
		}
		System.out.println(max);
		if(n >= m) {
			max = n;
		}
		else {
			max = m;
		}
			
		for(int i = max; i < n * m + 1; i++) {
			
			if(i % n == 0 && i % m == 0) {
				
				max = i;
				break;
			}
		}
		System.out.println(max);
	}
}
