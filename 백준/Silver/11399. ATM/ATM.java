import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> tmp = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			tmp.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(tmp);
		
		int sum = 0;
		int result = 0;
		for(int a : tmp) {
			sum += a;
			result += sum;
		}
			
		System.out.println(result);
		
	}
}
