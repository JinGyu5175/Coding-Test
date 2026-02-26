import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(br.readLine());
            int[] top = new int[n + 1];
            int[] bot = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) top[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) bot[i] = Integer.parseInt(st.nextToken());

            int dp0 = 0;
            int dp1 = 0;
            int dp2 = 0;

            for(int i = 1; i <=n; i++){
                int ndp0 = Math.max(dp0, Math.max(dp1, dp2));
                int ndp1 = Math.max(dp0, dp2) + bot[i];
                int ndp2 = Math.max(dp0, dp1) + top[i];
                dp0 = ndp0;
                dp1 = ndp1;
                dp2 = ndp2;
            }
            System.out.println(Math.max(dp0,Math.max(dp1, dp2)));
        }
    }
}
