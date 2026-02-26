import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long modPow(long a, long b, long mod) {
        if (b == 0) return 1 % mod;
        if (b == 1) return a % mod;

        long half = modPow(a, b / 2, mod);
        long res = (half * half) % mod;

        if (b % 2 == 1) res = (res * (a % mod)) % mod;
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(modPow(A, B, C));
    }
}
