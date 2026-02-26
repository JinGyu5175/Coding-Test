import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max_num = -1;
        int max_index = -1;
        int num = 0;
        for(int i = 1; i < 10; i++){
            num = Integer.parseInt(br.readLine());
            if(num > max_num){
                max_index = i;
                max_num = num;
            }
        }
        System.out.println(max_num);
        System.out.println(max_index);
    }
}
