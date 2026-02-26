import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			int third = Integer.parseInt(st.nextToken());
			
			if(first == 0 && second == 0 && third == 0){
				break;
			}
			
			if(third > second && third > first) {
				if(third * third == second * second + first * first) {
					System.out.println("right");
					continue;
				}
				else {
					System.out.println("wrong");
					continue;
				}
			}
			
			if(first > second && first > third) {
				if(first * first == second * second + third * third) {
					System.out.println("right");
					continue;
				}
				else {
					System.out.println("wrong");
					continue;
				}
			}
			
			if(second > first && second > third) {
				if(second * second == third * third + first * first) {
					System.out.println("right");
					continue;
				}
				else {
					System.out.println("wrong");
					continue;
				}
			}
			
		}
		
	}
}
