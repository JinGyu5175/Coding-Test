
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] jewel = new int[n][2]; // [무게, 가격]

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jewel[i][0] = Integer.parseInt(st.nextToken());
            jewel[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] bag = new int[k];
        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        // 보석: 무게 오름차순
        Arrays.sort(jewel, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        // 가방: 용량 오름차순
        Arrays.sort(bag);

        // 현재 가방에 넣을 수 있는 보석들 중 가치가 큰 순
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        long sum = 0;
        int idx = 0;

        for (int i = 0; i < k; i++) {
            int capacity = bag[i];

            // 현재 가방에 들어갈 수 있는 보석 전부 추가
            while (idx < n && jewel[idx][0] <= capacity) {
                pq.offer(jewel[idx][1]);
                idx++;
            }

            // 가장 비싼 보석 선택
            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }

        System.out.println(sum);
    }
}