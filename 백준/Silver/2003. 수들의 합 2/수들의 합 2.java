
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		
		int arr[] = new int [n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int cnt = 0;
		while(true) {
			int sum = 0;
			if(end > n) break;
			for(int i = start; i < end; i++) {
				sum += arr[i];
			}
			
			if(sum < target) {
				end += 1;
			}
			else if (sum >= target){
				start += 1;
				if(sum == target) cnt += 1;
			}
			
			
		}
		System.out.println(cnt);
		
	}
}
