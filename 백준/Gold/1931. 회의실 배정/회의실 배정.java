import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int time[][] = new int [n][2];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            time[i][0] = a;
            time[i][1] = b;
        }
        Arrays.sort(time, (a, b) ->{if(a[1] != b[1]) return a[1] - b[1]; return a[0] - b[0];});

        int current_time = time[0][1];

        int cnt = 1;

        for(int i = 1; i < n; i++){
            if(current_time <= time[i][0]) // 시작 타임이 현재 회의 끝나는 시간 보다 큰거
            {
                current_time = time[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
