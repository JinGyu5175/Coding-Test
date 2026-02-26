import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] seen = new boolean[42];
        for(int i = 0; i < 10; i++){
            int num = Integer.parseInt(br.readLine());
            seen[num % 42] = true;
        }
        int sum = 0;
        for(int i = 0; i < seen.length; i++){
            if(seen[i]) sum += 1;
        }
        System.out.println(sum);
    }
}