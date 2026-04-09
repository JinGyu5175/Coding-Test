import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int nums[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int order[][] = new int[m][2];

        for(int i = 0 ; i  < m; i++){
            st = new StringTokenizer(br.readLine());
            order[i][0] = Integer.parseInt(st.nextToken());
            order[i][1] = Integer.parseInt(st.nextToken());
        }

        boolean dist[][] = new boolean[n][n];

        // 길이기 1
        for(int i = 0; i < n; i++){
            dist[i][i] = true;
        }

        // 길이가 2
        for(int i = 0; i < n - 1; i++){
            if(nums[i] == nums[i + 1]){
                dist[i][i + 1] = true;
            }
        }

        // 길이가 3
        for(int len = 3; len < n + 1; len++){
            for(int i = 0; i < n - len + 1; i++){

                if(nums[i] == nums[i + len - 1] && dist[i + 1][i + len - 2]){
                    dist[i][i + len - 1] = true;
                }
            }
        }
    StringBuilder sb = new StringBuilder();
    for(int i = 0 ; i < m; i++){
        if(dist[order[i][0] - 1][order[i][1] - 1] == true){
            sb.append(1);
            sb.append("\n");
        }
        else{
            sb.append(0);
            sb.append("\n");
        }

    }
        System.out.println(sb);
    }
}
