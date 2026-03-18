import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int answer = Integer.MAX_VALUE;

    static ArrayList<int[]> house = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();

    static int[] selected; // 선택한 치킨집의 인덱스 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 1) {
                    house.add(new int[]{i, j});
                } else if (num == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        selected = new int[m];
        DFS(0, 0);

        System.out.println(answer);
    }

    static void DFS(int depth, int start) {
        if (depth == m) {
            int sum = getDistance();
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            selected[depth] = i;
            DFS(depth + 1, i + 1);
        }
    }

    static int getDistance() {
        int total = 0;

        for (int i = 0; i < house.size(); i++) {
            int[] h = house.get(i);
            int minDist = Integer.MAX_VALUE;

            for (int j = 0; j < m; j++) {
                int[] c = chicken.get(selected[j]);
                int dist = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                minDist = Math.min(minDist, dist);
            }

            total += minDist;
        }

        return total;
    }
}