import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        int cnt = 1;
        while(m > n){
            if(m % 10 == 1){
                m = (m - 1) / 10;
            }
            else if(m % 2 == 0){
                m = m / 2;
            }
            else{
                System.out.println(-1);
                return;
            }
            cnt++;
        }
        if(m == n){
            System.out.println(cnt);
        }
        else{
            System.out.println(-1);
        }
    }
}

