import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int bonus = 0;
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            sum = 0;
            bonus = 0;
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == 'O'){
                    sum += 1 + bonus;
                    bonus++;
                }
                if(str.charAt(j) == 'X'){
                    bonus = 0;
                }
            }
            System.out.println(sum);
        }

    }
}