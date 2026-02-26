import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num[] = new int[n];
        int count[] = new int[8001];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
            count[num[i] + 4000] += 1;
            sum += num[i];
        }
        Arrays.sort(num);
        int mean = (int)Math.round((double)sum / n);
        System.out.println(mean);

        System.out.println(num[n / 2]);
        int max_index = 0;
        for(int i = 0; i < 8001; i++){
            if(count[i] > max_index) max_index = count[i];
        }
        boolean flag = false;
        int mode = 0;
        for(int v = -4000; v < 4001; v++){
            if(count[v + 4000] != max_index) continue;

            if(!flag){ // 첫 발견
                mode = v;
                flag = true;
            }

            // 두번째 발견
            else{
                mode = v;
                break;
            }
        }
        System.out.println(mode);
        System.out.println(num[n - 1] - num[0]);





    }
}
