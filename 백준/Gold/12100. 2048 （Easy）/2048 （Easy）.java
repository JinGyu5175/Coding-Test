import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int max_num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        max_num = -1;
        dfs(0);
        System.out.println(max_num);


    }
    static void dfs(int idx){

        if(idx == 5){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j] > max_num){
                        max_num = board[i][j];
                    }
                }
            }
            return;
        }
        int[][] backup = copyBoard(board);
        
        for(int i = 0 ; i < 4; i++){

            cal(i);
            dfs(idx + 1);
            board = copyBoard(backup);

        }


    }

    static int[][] copyBoard(int[][] src){
        int[][] dst = new int[n][n];
        for(int i=0;i<n;i++){
            System.arraycopy(src[i], 0, dst[i], 0, n);
        }
        return dst;
    }
    static void cal(int direct) {
        if(direct == 0 || direct == 2) {
            for (int j = 0; j < n; j++) {

                int num[] = new int[n];
                if(direct == 0) {
                    for (int i = 0; i < n; i++) {
                        num[i] = board[i][j];
                    }
                }
                else if(direct == 2){
                    int d2 = 0;
                    for (int i = n - 1; i >= 0; i--) {
                        num[d2++] = board[i][j];
                    }
                }


                //방향 상관 x
                int tmp_num[] = new int[n];
                int tmp = 0;
                for (int a = 0; a < n; a++) { // 0 없애고 맨 위로 모으기
                    if (num[a] != 0) {
                        tmp_num[tmp++] = num[a];

                    }
                }
                // 합치기
                for (int a = 0; a < n - 1; a++) {
                    if (tmp_num[a] != 0 && (tmp_num[a] == tmp_num[a + 1])) { // 0이 아니고 뒷자리랑 같을때
                        tmp_num[a] *= 2;
                        tmp_num[a + 1] = 0;
                        a++;
                    }
                }

                int result[] = new int[n];
                int t = 0;
                for (int a = 0; a < n; a++) { // 0 없애고 맨 위로 모으기
                    if (tmp_num[a] != 0) {
                        result[t++] = tmp_num[a];

                    }
                }
                //방향 상관 x



                if(direct == 0) {
                    for (int k = 0; k < n; k++) {
                        board[k][j] = result[k];
                    }
                }
                else if(direct == 2){
                    int d2 = 0;
                    for (int k = n - 1; k >= 0; k--) {
                        board[k][j] = result[d2++];
                    }
                }


            }
        }
        if(direct == 1 || direct == 3) {
            for (int i = 0; i < n; i++) {

                int num[] = new int[n];
                if(direct == 1) {
                    for (int j = 0; j < n; j++) {
                        num[j] = board[i][j];
                    }
                }
                else if(direct == 3){
                    int d2 = 0;
                    for (int j = n - 1; j >= 0; j--) {
                        num[d2++] = board[i][j];
                    }
                }

                //방향 상관 x
                int tmp_num[] = new int[n];
                int tmp = 0;
                for (int a = 0; a < n; a++) { // 0 없애고 맨 위로 모으기
                    if (num[a] != 0) {
                        tmp_num[tmp++] = num[a];

                    }
                }
                // 합치기
                for (int a = 0; a < n - 1; a++) {
                    if (tmp_num[a] != 0 && (tmp_num[a] == tmp_num[a + 1])) { // 0이 아니고 뒷자리랑 같을때
                        tmp_num[a] *= 2;
                        tmp_num[a + 1] = 0;
                        a++;
                    }
                }

                int result[] = new int[n];
                int t = 0;
                for (int a = 0; a < n; a++) { // 0 없애고 맨 위로 모으기
                    if (tmp_num[a] != 0) {
                        result[t++] = tmp_num[a];

                    }
                }
                //방향 상관 x

                if(direct == 1) {
                    for (int k = 0; k < n; k++) {
                        board[i][k] = result[k];
                    }
                }
                else if(direct == 3){
                    int d2 = 0;
                    for (int k = n - 1; k >= 0; k--) {
                        board[i][k] = result[d2++];
                    }
                }


            }
        }

    }
}

