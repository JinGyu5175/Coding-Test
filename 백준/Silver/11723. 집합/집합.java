import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		Set<Integer> set = new HashSet<>();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			
			
			
			if(tmp.equals("add")) {
				int num = Integer.parseInt(st.nextToken());
				set.add(num);
			}
			
			else if(tmp.equals("remove")) {
				int num = Integer.parseInt(st.nextToken());		
				set.remove(num);
			}
			
			else if(tmp.equals("check")) {
				int num = Integer.parseInt(st.nextToken());
				sb.append(set.contains(num) ? 1 : 0).append('\n');
			}
			
			else if(tmp.equals("toggle")) {
				int num = Integer.parseInt(st.nextToken());
				if(set.contains(num)) set.remove(num);
				else set.add(num);
			}
			
			else if(tmp.equals("all")) {
			    set.clear();
			    for (int x = 1; x <= 20; x++) set.add(x);
			}

			else if(tmp.equals("empty")) {
				set.clear();
			}
		}
		System.out.print(sb.toString());
	}
}
