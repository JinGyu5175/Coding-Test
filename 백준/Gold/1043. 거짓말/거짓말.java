import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int total = 0;
		st = new StringTokenizer(br.readLine());
		int truth = Integer.parseInt(st.nextToken());
		Set<Integer> set = new HashSet<>();

		for(int i = 0; i < truth; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		
		int arr[][] = new int[m][];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			arr[i] = new int[p];
			
			for(int j = 0; j < p; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean changed = true;
		while(changed) {
			changed = false;
			for(int i = 0; i < m; i++) {
				boolean hash_flag = false;
				for(int j = 0; j < arr[i].length; j++) {
					if(set.contains(arr[i][j])) { // 거짓말을 아는 사람이 있으면
						hash_flag = true;
						break;
					}
				}
				
				if(hash_flag) {
					for(int j = 0; j < arr[i].length; j++) {
						if(set.add(arr[i][j])) { //추가가되면
							changed = true;
						}
					}
				}
			}
		}
		
		// 파티 전체 탐색
		for(int i = 0; i < m; i++) {
			boolean flag = true;
			for(int j = 0; j < arr[i].length; j++) {
				if(set.contains(arr[i][j])){
					flag = false;
					break;
				}
			}
			
			if(flag == true) {
				total++;
			}
		}
		
		if(truth == 0) {
			System.out.println(m);

		}
		else {
			System.out.println(total);
		}
		
	}
}
