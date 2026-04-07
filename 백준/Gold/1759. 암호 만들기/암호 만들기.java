import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char[] arr;
    static char[] selected;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int idx, int depth) {
        if (depth == n) {
            int vowel = 0, consonant = 0;

            for (int i = 0; i < n; i++) {
                char c = selected[i];
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowel++;
                } else {
                    consonant++;
                }
            }

            if (vowel >= 1 && consonant >= 2) {
                sb.append(selected).append('\n');
            }
            return;
        }

        for (int i = idx; i < m; i++) {
            selected[depth] = arr[i];
            dfs(i + 1, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[m];
        selected = new char[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        dfs(0, 0);

        System.out.print(sb);
    }
}