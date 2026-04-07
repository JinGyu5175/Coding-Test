
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int mask = 0;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			if(order.equals("add")) {
				int num = Integer.parseInt(st.nextToken());
				mask |= (1 << num);
			}
			else if(order.equals("remove")) {
				int num = Integer.parseInt(st.nextToken());
				if((mask & (1 << num)) != 0) { // 존재하는 것
					mask &= ~(1 << num); 
				}
			}
			else if(order.equals("check")) {
				int num = Integer.parseInt(st.nextToken());
				if((mask & (1 << num)) != 0) { // 존재하는 것
					sb.append(1).append('\n');
				}
				else {
					sb.append(0).append('\n');
				}
			}
			else if(order.equals("toggle")) {
				int num = Integer.parseInt(st.nextToken());
				if((mask & (1 << num)) != 0) { // 존재하는 것
					mask &= ~(1 << num); 
				}
				else {
					mask |= (1 << num);
				}
			}
			else if(order.equals("all")) {
				mask = (1 << 21) -1;
			}
			else if(order.equals("empty")) {
				mask = 0;
			}
		}
		System.out.print(sb);
	}
}
