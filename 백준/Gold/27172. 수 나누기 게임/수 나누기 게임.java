import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] score = new int[1000001];
        boolean[] present = new boolean[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            present[arr[i]] = true;
            max = Math.max(max, arr[i]);
        }

        for (int i = 0; i < n; i++) {
            int x = arr[i];

            for (int multiple = x * 2; multiple <= max; multiple += x) {
                if (present[multiple]) {
                    score[x]++;
                    score[multiple]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x : arr) {
            sb.append(score[x]).append(' ');
        }
        System.out.println(sb);
    }
}