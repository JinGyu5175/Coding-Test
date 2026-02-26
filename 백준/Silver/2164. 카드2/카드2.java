import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i < n + 1; i++) {
            queue.add(i);
        }

        while(queue.size() != 1){
            queue.poll();
            int m = queue.poll();
            queue.add(m);
        }
        System.out.println(queue.poll());
    }
}
