import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int board[][] = new int [n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int result = 0;
		
		for(int i = 0; i < n; i++) {
			int arr[] = new int[n];
			for(int j = 0; j < n; j++) {
				arr[j] = board[i][j];
			}
			boolean visited[] = new boolean[n];
			boolean fail = false;
			for(int k = 1; k < n; k++) {
				if(arr[k] == arr[k - 1]) continue; // 같을 때
				
				else if(arr[k] == arr[k - 1] + 1) { // 상승
					for(int m = 1; m < l + 1; m++) {
						if(k - m < 0 || visited[k - m]) { // 길이가 부족하거나 이미 쓰고 있는 곳 일 경우 
							fail = true;
							break;
						}
						visited[k - m] = true;
					}
				}
				
				else if(arr[k] == arr[k - 1] - 1){ // 하강
					for(int m = 0; m < l; m++) {
						if(k + m >= n || visited[k + m]) { // 길이가 부족하거나 이미 쓰고 있는 곳 일 경우 
							fail = true;
							break;
						}
						visited[k + m] = true;
					}
				}
				else {
					fail = true;
				}
				
				if(fail) {
					break;
				}
			}
			
			if(!fail) {
				result++;

			}
		}
		
		for(int j = 0; j < n; j++) {
			int arr[] = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = board[i][j];
			}
			boolean visited[] = new boolean[n];
			boolean fail = false;
			for(int k = 1; k < n; k++) {
				if(arr[k] == arr[k - 1]) continue; // 같을 때
				
				else if(arr[k] == arr[k - 1] + 1) { // 상승
					for(int m = 1; m < l + 1; m++) {
						if(k - m < 0 || visited[k - m]) { // 길이가 부족하거나 이미 쓰고 있는 곳 일 경우 
							fail = true;
							break;
						}
						visited[k - m] = true;
					}
				}
				
				else if(arr[k] == arr[k - 1] - 1){ // 하강
					for(int m = 0; m < l; m++) {
						if(k + m >= n || visited[k + m]) { // 길이가 부족하거나 이미 쓰고 있는 곳 일 경우 
							fail = true;
							break;
						}
						visited[k + m] = true;
					}
				}
				else {
					fail = true;
				}
				
				if(fail) {
					break;
				}
			}
			
			if(!fail) {
				result++;

			}
		}
		System.out.println(result);

	}
}
