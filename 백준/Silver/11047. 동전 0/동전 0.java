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
		
		int tmp[] = new int [n];
		
		for(int i = 0; i < n; i++) {
			tmp[i] = Integer.parseInt(br.readLine());
		}
		
		int count = 0;
		int start = n - 1;
		while(target != 0) {
			if(target >= tmp[start]) {
				target -= tmp[start];
				count += 1;
			}
			else {
				start -=1;
			}
			
		}
		System.out.println(count);
	}
}
