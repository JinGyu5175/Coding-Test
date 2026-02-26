import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static boolean binarySearch(List<Integer> a, int target) {
        int left = 0;
        int right = a.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int value = a.get(mid);
            if (target == value) return true;
            else if (value < target) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        List<Integer> arr2 = new ArrayList<>();
        StringTokenizer sk = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            arr2.add(Integer.parseInt(sk.nextToken()));
        }
        arr.sort((a, b)-> a.compareTo(b));

        for (int i = 0; i < m; i++) {
            if(binarySearch(arr, arr2.get(i))) System.out.println(1);
            else System.out.println(0);
        }
    }
}
