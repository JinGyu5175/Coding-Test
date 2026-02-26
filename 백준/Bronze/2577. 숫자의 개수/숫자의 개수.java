import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int f1 = Integer.parseInt(br.readLine());
        int f2 = Integer.parseInt(br.readLine());
        int f3 = Integer.parseInt(br.readLine());

        int num[] = new int[10];
        int tmp = f1 * f2 * f3;

        for(int i = 0; i < String.valueOf(tmp).length(); i++){
            num[String.valueOf(tmp).charAt(i) - 48] += 1;
        }
        for(int i = 0; i < 10; i++){
            System.out.println(num[i]);
        }

    }
}