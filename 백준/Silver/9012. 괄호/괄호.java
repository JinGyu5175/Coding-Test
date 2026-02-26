import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Queue;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            Deque<String> deque = new ArrayDeque<>();
            boolean flag = true;
            for (int j = 0; j < tmp.length(); j++) {
                if(deque.size() == 0 && tmp.charAt(j) == ')'){
                    flag = false;
                    break;
                }

                if(tmp.charAt(j) == '('){
                    deque.add("(");
                }
                else if(tmp.charAt(j) == ')'){
                    deque.poll();
                }
            }
            if(deque.size() != 0 || !flag) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
