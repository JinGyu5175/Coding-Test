import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int score[] = new int [n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max_score = -1;
		for (int i = 0; i < score.length; i++) {
			score[i] = Integer.parseInt(st.nextToken());
			if(score[i] > max_score) {
				max_score = score[i];
			}
		}
		
		double sum = 0;
		for(int i = 0; i < score.length; i++) {
			
			sum += (double)score[i]/max_score * 100;
		}
	
		System.out.println(sum/score.length);
		
		
	}
}
