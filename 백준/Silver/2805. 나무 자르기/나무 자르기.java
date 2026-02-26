
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
		
		int max_tree = 0;

		int tree[] = new int [n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i ++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if(tree[i] > max_tree) max_tree = tree[i];
		}
		
		int start_h = 0;
		int end_h = max_tree;
		int result = 0;
		while(start_h <= end_h) {
			
			int mid = (start_h + end_h) / 2;
			
			long sum = 0;
			for(int i = 0; i < n; i++) {
				if(tree[i] > mid) sum += tree[i] - mid;
			}

			if(sum >= target) {
				result = mid;
				start_h = mid + 1;
				
			}
			else if(sum < target){
				end_h = mid - 1;
			}
		}
		System.out.println(result);
		
		
	}
}
