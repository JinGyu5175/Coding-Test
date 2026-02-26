import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			if(num[i] == 1) {
				continue;
			}
			else if(num[i] == 2) {
				count += 1;
				continue;
			}
			boolean flag = true;
			for(int j = 2; j < num[i]; j++) {
				if(num[i] % j == 0) {
					flag = false;
					break;// 다른 수로 나눠지면 바로 탈출
				}
			}
			if(flag) {
				count += 1;
			}
		}
		System.out.println(count);
		
		
		
		
		
		
	}

}
