import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int sorted[] = new int[n];
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sorted[i] = arr[i];
        }

        Arrays.sort(sorted);

        int unique[] = new int[n];
        int m = 0;
        unique[m++] = sorted[0];

        for(int i = 1; i < n; i++){
            if(sorted[i] != sorted[i - 1]) unique[m++] = sorted[i];
        }

        for(int i = 0; i < n; i++){ // index찾기
            int idx = Arrays.binarySearch(unique, 0, m, arr[i]);
            sb.append(idx).append(" ");

        }
        System.out.println(sb);
    }
}
