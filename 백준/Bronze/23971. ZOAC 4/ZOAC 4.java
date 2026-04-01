import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long H = Long.parseLong(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long row = (H + N) / (N + 1); // ceil(H / (N+1))
        long col = (W + M) / (M + 1); // ceil(W / (M+1))

        System.out.println(row * col);
    }
}