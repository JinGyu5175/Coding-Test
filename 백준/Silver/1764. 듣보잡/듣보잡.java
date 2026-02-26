import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Set<String> set = new HashSet<>();
		TreeSet<String> result = new TreeSet<>();
		
		
		for(int i = 0; i < n; i++) {
			
			String tmp = br.readLine();
			set.add(tmp);
		}
		
		for(int i = 0; i < m; i++) {
			String tmp = br.readLine();
			if(set.contains(tmp)) result.add(tmp);
		}
		
		System.out.println(result.size());
		for(String s : result) {
			System.out.println(s);
		}
	}

}
