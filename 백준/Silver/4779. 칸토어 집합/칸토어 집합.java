import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static void solve(int x, char[] tmp, int size){
        for(int i = x + size; i < x + size * 2; i++){
            tmp[i] = ' ';
        }
        if(size == 1) return;


        solve(x + size * 2, tmp, size / 3);
        solve(x, tmp, size / 3);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;   // 빈 줄 방어

            int n = Integer.parseInt(line);
            if(n == 0) {
                sb.append('-').append("\n");
            } else {
                int len = 1;
                for(int i = 0; i < n; i++) len *= 3;

                char[] tmp = new char[len];
                for(int i = 0; i < len; i++) tmp[i] = '-';

                solve(0, tmp, len / 3);

                for(int i = 0; i < len; i++) sb.append(tmp[i]);
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }
}
