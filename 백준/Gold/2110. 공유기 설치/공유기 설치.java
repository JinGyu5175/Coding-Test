import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int item[] = new int[n];

        for (int i = 0; i < n; i++) {
            item[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(item);

        long start = 1;
        long end = item[n - 1] - item[0];
        long target = 0;

        while(start <= end){
            long mid = (start + end) / 2;
            int count = 1;
            int previtem = item[0];

            for(int i = 1; i < n; i++){
                if(item[i] - previtem >= mid){
                    count += 1;
                    previtem = item[i];
                }
            }

            if(count >= c){
                target = mid;
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        System.out.println(target);

    }
}
