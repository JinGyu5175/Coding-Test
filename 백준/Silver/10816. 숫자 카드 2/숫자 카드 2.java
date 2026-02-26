import java.io.*;
import java.util.*;

public class Main {

    static int firstEqual(int[] a, int target) {
        int l = 0, r = a.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;

            if (a[mid] == target) {
                ans = mid;
                r = mid - 1;          // 더 왼쪽에 같은 값이 있는지 계속 찾기
            } else if (a[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    static int lastEqual(int[] a, int target) {
        int l = 0, r = a.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;

            if (a[mid] == target) {
                ans = mid;
                l = mid + 1;          // 더 오른쪽에 같은 값이 있는지 계속 찾기
            } else if (a[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(a);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());

            int first = firstEqual(a, x);
            if (first == -1) sb.append(0);
            else {
                int last = lastEqual(a, x);
                sb.append(last - first + 1);
            }

            if (i < m - 1) sb.append(' '); // 공백 구분
        }
        System.out.print(sb.toString());

    }
}
