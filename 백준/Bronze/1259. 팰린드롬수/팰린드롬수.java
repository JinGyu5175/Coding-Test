import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		while(true) {
			boolean flag = true;
			String num = br.readLine();
			if(num.equals("0")) break;
			int size = num.length();
			if(size % 2 == 1) { // 홀수 자리 수일 경우 ex)1, 3, 5 
				for(int i = 0; i < size / 2; i++) {
					if(num.charAt(i) != (num.charAt(size - 1 - i))) {
						flag = false; 
					}
				}
			}
			else {
				for(int i = 0; i < size / 2; i++) {
					if(num.charAt(i) != (num.charAt(size - 1 - i))) {
						flag = false; 
					}
				}				
			}
			
			if(flag) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
			
		}
	}
}
