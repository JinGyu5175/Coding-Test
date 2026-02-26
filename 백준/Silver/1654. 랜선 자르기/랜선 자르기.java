import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] arr = new long[K];
        long high = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
            if (arr[i] > high) high = arr[i];
        }

        long low = 1;
        long ans = 0;

        while (low <= high) {
            long mid = (low + high) / 2;

            long cnt = 0;
            for (int i = 0; i < K; i++) {
                cnt += arr[i] / mid;
            }

            if (cnt >= N) {          // N개 이상 만들 수 있으면 길이를 늘려본다
                ans = mid;
                low = mid + 1;
            } else {                 // 부족하면 길이를 줄인다
                high = mid - 1;
            }
        }

        System.out.println(ans);
    }
}