import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int board[][] = new int [n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, -1, 0, 1};

        int max_Value = -1;

        // 일자 블럭
        int Lblock[] = {3, 3, 3};

        for(int l = 0; l < 2; l++){
            if(l != 0){
                for(int k = 0; k < Lblock.length; k++){
                    Lblock[k] = (Lblock[k] + 1) % 4;
                }
            }
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    Deque<int[]> queue = new ArrayDeque<>();
                    int sum = 0;
                    int cnt = 0;
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {

                        int num[] = queue.poll();
                        int x = num[0];
                        int y = num[1];
                        sum += board[x][y];
                        if (cnt == 3) {
                            break;
                        }
                        int nx = x + dx[Lblock[cnt]];
                        int ny = y + dy[Lblock[cnt]];
                        cnt++;
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                            queue.add(new int[]{nx, ny});
                        }
                    }
                    if (cnt == 3) {
                        if (sum > max_Value) {

                            max_Value = sum;
                        }
                    }
                }
            }
        }



        int Sblock[] = {3, 0, 1};

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Deque<int[]> queue = new ArrayDeque<>();
                int sum = 0;
                int cnt = 0;
                queue.add(new int[]{i, j});
                while (!queue.isEmpty()) {
                    int num[] = queue.poll();
                    int x = num[0];
                    int y = num[1];
                    sum += board[x][y];

                    if (cnt == 3) {
                        break;
                    }
                    int nx = x + dx[Sblock[cnt]];
                    int ny = y + dy[Sblock[cnt]];
                    cnt++;
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        queue.add(new int[]{nx, ny});
                    }
                }
                if (cnt == 3) {
                    if (sum > max_Value) {

                        max_Value = sum;
                    }
                }
            }
        }

        int Rblock[] = {0, 0, 3};
        //R 블럭
        for(int l = 0; l < 4; l++){
            if(l != 0){
                for(int k = 0; k < Rblock.length; k++){
                    Rblock[k] = (Rblock[k] + 1) % 4;
                }
            }
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    Deque<int[]> queue = new ArrayDeque<>();
                    int sum = 0;
                    int cnt = 0;
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {

                        int num[] = queue.poll();
                        int x = num[0];
                        int y = num[1];
                        sum += board[x][y];
                        if (cnt == 3) {
                            break;
                        }
                        int nx = x + dx[Rblock[cnt]];
                        int ny = y + dy[Rblock[cnt]];
                        cnt++;
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                            queue.add(new int[]{nx, ny});
                        }
                    }
                    if (cnt == 3) {
                        if (sum > max_Value) {

                            max_Value = sum;
                        }
                    }
                }
            }
        }

        int RRblock[] = {0, 0, 1};

        for(int l = 0; l < 4; l++){
            if(l != 0){
                for(int k = 0; k < RRblock.length; k++){
                    RRblock[k] = (RRblock[k] + 1) % 4;
                }
            }
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    Deque<int[]> queue = new ArrayDeque<>();
                    int sum = 0;
                    int cnt = 0;
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {

                        int num[] = queue.poll();
                        int x = num[0];
                        int y = num[1];
                        sum += board[x][y];
                        if (cnt == 3) {
                            break;
                        }
                        int nx = x + dx[RRblock[cnt]];
                        int ny = y + dy[RRblock[cnt]];
                        cnt++;
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                            queue.add(new int[]{nx, ny});
                        }
                    }
                    if (cnt == 3) {
                        if (sum > max_Value) {

                            max_Value = sum;
                        }
                    }
                }
            }
        }



        int RSblock[] = {0, 3, 0};

        for(int l = 0; l < 4; l++){
            if(l != 0){
                for(int k = 0; k < RSblock.length; k++){
                    RSblock[k] = (RSblock[k] + 1) % 4;
                }
            }
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    Deque<int[]> queue = new ArrayDeque<>();
                    int sum = 0;
                    int cnt = 0;
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {

                        int num[] = queue.poll();
                        int x = num[0];
                        int y = num[1];
                        sum += board[x][y];
                        if (cnt == 3) {
                            break;
                        }
                        int nx = x + dx[RSblock[cnt]];
                        int ny = y + dy[RSblock[cnt]];
                        cnt++;
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                            queue.add(new int[]{nx, ny});
                        }
                    }
                    if (cnt == 3) {
                        if (sum > max_Value) {

                            max_Value = sum;
                        }
                    }
                }
            }
        }

        int RRSblock[] = {0, 1, 0};

        for(int l = 0; l < 4; l++){
            if(l != 0){
                for(int k = 0; k < RRSblock.length; k++){
                    RRSblock[k] = (RRSblock[k] + 1) % 4;
                }
            }
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    Deque<int[]> queue = new ArrayDeque<>();
                    int sum = 0;
                    int cnt = 0;
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {

                        int num[] = queue.poll();
                        int x = num[0];
                        int y = num[1];
                        sum += board[x][y];
                        if (cnt == 3) {
                            break;
                        }
                        int nx = x + dx[RRSblock[cnt]];
                        int ny = y + dy[RRSblock[cnt]];
                        cnt++;
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                            queue.add(new int[]{nx, ny});
                        }
                    }
                    if (cnt == 3) {
                        if (sum > max_Value) {

                            max_Value = sum;
                        }
                    }
                }
            }
        }
        int Mblock[] = {1, 0, 3};

        for(int l = 0; l < 4; l++){
            if(l != 0){
                for(int k = 0; k < Mblock.length; k++){
                    Mblock[k] = (Mblock[k] + 1) % 4;
                }
            }
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    Deque<int[]> queue = new ArrayDeque<>();
                    int sum = 0;
                    int cnt = 0;
                    sum += board[i][j];
                    for(int k = 0; k < Mblock.length; k++){
                        int nx = i + dx[Mblock[k]];
                        int ny = j + dy[Mblock[k]];
                        queue.add(new int[]{nx, ny});
                    }

                    while (!queue.isEmpty()) {
                        int num[] = queue.poll();
                        int x = num[0];
                        int y = num[1];
                        if (x >= 0 && x < n && y >= 0 && y < m) {
                            sum += board[x][y];
                        }
                        else break;
                        if (cnt == 3) {
                            break;
                        }
                        cnt++;

                    }

                if (sum > max_Value) {

                    max_Value = sum;
                }
                }
            }
        }


        System.out.println(max_Value);











    }
}
