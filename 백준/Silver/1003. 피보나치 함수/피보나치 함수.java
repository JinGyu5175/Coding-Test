
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		int fibo[][] = new int [41][2];
		fibo[0] = new int[]{1, 0};
		fibo[1] = new int[]{0, 1};
		
		int cnt = 2;
		while(cnt != 41) {
			fibo[cnt][0] = fibo[cnt - 1][0] + fibo[cnt - 2][0];
			fibo[cnt][1] = fibo[cnt - 1][1] + fibo[cnt - 2][1];
			cnt++;
		}
		
		for(int i = 0; i < t; i++) {
			int k = Integer.parseInt(br.readLine());
			System.out.println(fibo[k][0] + " " + fibo[k][1]);
		}
	}
}
