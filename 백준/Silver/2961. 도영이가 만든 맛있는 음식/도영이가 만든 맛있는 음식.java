
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int info[][] = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken()); // 신맛
			info[i][1] = Integer.parseInt(st.nextToken()); // 쓴맛
		}
		int min_value = Integer.MAX_VALUE;
		
		for(int mask = 1; mask < (1 << n); mask++) {
			
			int first = 0;
			int second = 0;
			
			for(int i = 0; i < n; i++) {
				if((mask & (1 << i)) != 0) { // 켜져있음
					
					if(first == 0) {
						first = info[i][0];
					}
					else {
						first = first * info[i][0];
					}
						second += info[i][1];
					
				}

			}
			
			int diff = Math.abs(first - second);
//			System.out.println(first);
//			System.out.println(second);
			if(diff < min_value) {
				min_value = diff;
			}
		}
		System.out.println(min_value);
	}
}
