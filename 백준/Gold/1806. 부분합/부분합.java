import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int num[] = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int sum = num[start];
		int min_value = Integer.MAX_VALUE;
		
		while(true) {
			// 합이 작을때
			if(sum < s) {
				if(end + 1 < n) {
					end++;
					sum += num[end];
				}
				else {
					break;
				}
			}
			
			// 합이 클때
			else {
				if(min_value > end - start) {
					min_value = end - start;
				}
				
				sum -= num[start];
				start += 1;
				
				if(start > end) {
					break;
				}
			}
		}
		
		if(min_value == Integer.MAX_VALUE) {
			System.out.println(0);
		}
		else {
			System.out.println(min_value + 1);
		}
 	}
}
