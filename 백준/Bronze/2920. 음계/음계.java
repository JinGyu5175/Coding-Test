import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        if(n == 1) //ascending 확인
        {
            int count = 1;
            boolean flag = true;
            for(int i = 0; i < 7; i++){
                n = Integer.parseInt(st.nextToken());
                if(n == count + 1){
                    count++;
                }
                else{
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("ascending");
            }
            else{
                System.out.println("mixed");
            }
        }
        else if(n == 8) //descending 확인
        {
            int count = 8;
            boolean flag = true;
            for(int i = 0; i < 7; i++){
                n = Integer.parseInt(st.nextToken());
                if(n == count - 1){
                    count--;
                }
                else{
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("descending");
            }
            else{
                System.out.println("mixed");
            }
        }
        else{
            System.out.println("mixed");
        }
    }
}