import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        @SuppressWarnings("unchecked")
        ArrayList<int[]>[][] shark = new ArrayList[R][C];

        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, 1, -1};

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken()); // 속력
            int d = Integer.parseInt(st.nextToken()) - 1; // 이동방향
            int z = Integer.parseInt(st.nextToken()); // 무게
            if(shark[r][c] == null) shark[r][c] = new ArrayList<>(1);
            shark[r][c].add(new int[] {s, d, z});
        }
        int total = 0;

        for(int f = 0; f < C; f++) {
            // 낚시왕 이동
            // 낚시왕이 땅과 제일 가까운 상어 잡음
            for(int c = 0; c < R; c++) {
                if(shark[c][f] == null || shark[c][f].isEmpty()) continue;
                int z = shark[c][f].get(0)[2];
                total += z;
                shark[c][f].clear();
                break;
            }

            @SuppressWarnings("unchecked")
            ArrayList<int[]>[][] next = new ArrayList[R][C];

            // 상어 이동
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    if(shark[i][j] == null || shark[i][j].isEmpty()) continue;
                    int s = shark[i][j].get(0)[0];
                    int d = shark[i][j].get(0)[1];
                    int z = shark[i][j].get(0)[2];
                    int nx = i;
                    int ny = j;

                    int new_s = s;
                    if (d==0 || d==1) {
                        new_s = s % ((R-1)*2);
                    } else {
                        new_s = s % ((C-1)*2);
                    }
                    for(int k = 0; k < new_s; k++) {
                        nx += dx[d];
                        ny += dy[d];

                        if(nx < 0 || nx >= R || ny < 0 || ny >= C) { // 벽 부딪쳤을때
                            nx -= dx[d];
                            ny -= dy[d];

                            if(d == 0) d = 1;
                            else if(d == 1) d = 0;
                            else if(d == 2) d = 3;
                            else d = 2;

                            nx += dx[d];
                            ny += dy[d];
                        }
                    }

                    if (next[nx][ny] == null) next[nx][ny] = new ArrayList<>();

                    if (next[nx][ny].isEmpty() || next[nx][ny].get(0)[2] < z) {
                        if (next[nx][ny].isEmpty()) next[nx][ny].add(new int[]{s, d, z});
                        else next[nx][ny].set(0, new int[]{s, d, z});
                    }
                }
            }
            shark = next;
        }
        System.out.println(total);
    }
}

