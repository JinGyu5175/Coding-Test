import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num[] = new int[n];
        int max_num = -1000001;
        int min_num = 1000001;
        int temp = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            temp = Integer.parseInt(st.nextToken());
            if(temp > max_num){
                max_num = temp;
            }

            if(temp < min_num){
                min_num = temp;
            }
        }
        System.out.println(min_num + " " + max_num);

    }
}
