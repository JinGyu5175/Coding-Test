import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken(); // ✅ 한 번만!

            if (cmd.equals("push")) {
                queue.offerLast(Integer.parseInt(st.nextToken()));
            } else if (cmd.equals("pop")) {
                sb.append(queue.isEmpty() ? -1 : queue.pollFirst()).append('\n');
            } else if (cmd.equals("size")) {
                sb.append(queue.size()).append('\n');
            } else if (cmd.equals("empty")) {
                sb.append(queue.isEmpty() ? 1 : 0).append('\n');
            } else if (cmd.equals("front")) {
                sb.append(queue.isEmpty() ? -1 : queue.peekFirst()).append('\n');
            } else if (cmd.equals("back")) {
                sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append('\n');
            }
        }

        System.out.print(sb);
    }
}
