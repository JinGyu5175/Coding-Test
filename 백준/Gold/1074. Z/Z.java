import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int ans = 0;

        while (N > 0) {
            int half = 1 << (N - 1);
            int block = half * half;

            if (r < half && c < half) {

            } else if (r < half && c >= half) {
                ans += block;
                c -= half;
            } else if (r >= half && c < half){
                ans += block * 2;
                r -= half;
            }
            else{
                ans += block * 3;
                r -= half;
                c -= half;
            }
            N--;
        }
        System.out.println(ans);
    }
}
