import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        List<int[]> arr = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.add(new int[]{a, b});
        }
        arr.sort((a, b)-> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        for (int i = 0; i < n; i++) {
            System.out.println(arr.get(i)[0] + " "+ arr.get(i)[1]);

        }
    }
}
