import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n_card = Integer.parseInt(st.nextToken());
		int goal_num = Integer.parseInt(st.nextToken());
		int max_num = -1;
		st = new StringTokenizer(br.readLine());
		int card[] = new int[n_card];
		
		for(int i = 0; i < n_card; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		for(int i = 0; i < n_card; i++) {
			for(int j = i + 1; j < n_card; j++) {
				for(int k = j + 1; k < n_card; k++) {
					sum = card[i] + card[j] + card[k];

					if(sum <= goal_num && sum > max_num ) {
						max_num = sum;
					}
				}
			}
		}
		System.out.println(max_num);
		
		
	}
}
