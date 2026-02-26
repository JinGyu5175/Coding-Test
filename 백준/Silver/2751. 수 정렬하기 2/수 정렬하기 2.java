import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		int n[] = new int[size];
		
		for(int i = 0; i < size; i++) {
			n[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(n);
		for(int i = 0; i < size; i++) {
			System.out.println(n[i]);
		}
	}
		
}
