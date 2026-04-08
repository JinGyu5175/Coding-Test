
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
		
		int num[] = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int sum = 0;
		for(int i = 0; i < m; i++) {
			sum += num[i];
		}
		int max_value = sum;
		int start = 0;
		int end = m - 1;
		
		while(true) {
			if(end + 1 < n) {
				end++;
				sum += num[end];
				sum -= num[start];
				start++;	
				
				if(sum > max_value) {
					max_value = sum;
				}
			}
			else {
				break;
			}
		}
		System.out.println(max_value);
		
 	}
}
