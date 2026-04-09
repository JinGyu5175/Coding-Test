
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String words = br.readLine();
			
			int start = 0;
			int end = words.length() - 1;
			boolean flag = false;
			
			while(start < end){
				
				if(words.charAt(start) == words.charAt(end)) {
					start++;
					end--;
				}
				else {
					if(ispall(start + 1, end, words) || ispall(start, end - 1, words)) {
						System.out.println(1);
						flag = true;
						break;
					}
					else {
						System.out.println(2);
						flag = true;
						break;
					}
				}
			}
            if(flag == false) System.out.println(0);
		}
				
	}
	static boolean ispall(int start, int end, String words) {
		boolean flag = true;
		
		while(start < end) {
			if(words.charAt(start) != words.charAt(end)) {
				flag = false;
				break;
			}
			start ++;
			end --;
		}
		
		return flag;		
	}
}
