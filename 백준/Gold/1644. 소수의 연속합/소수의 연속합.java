import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        if (n >= 0) isPrime[0] = false;
        if (n >= 1) isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) primes.add(i);
        }
        int cnt = 0;

		int start = 0;
		int end = 0;
		int sum = 0;
		while(true) {
			if(sum >= n) {
				if(sum == n) cnt++;
				sum -= primes.get(start);
				start++;
			}
			else {
				if(end == primes.size())break;
				sum += primes.get(end);
				end++;
			}
        }
		System.out.println(cnt);
    }
}