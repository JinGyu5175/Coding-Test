import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] board = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(board);

        long minCount = Long.MAX_VALUE;
        int a = 0, b = 0, c = 0;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long sum = (long) board[i] + board[left] + board[right];

                if (Math.abs(sum) < minCount) {
                    minCount = Math.abs(sum);
                    a = board[i];
                    b = board[left];
                    c = board[right];
                }

                if (sum == 0) {
                    System.out.println(a + " " + b + " " + c);
                    return;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(a + " " + b + " " + c);
    }
}