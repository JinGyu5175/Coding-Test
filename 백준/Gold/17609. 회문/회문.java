import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String words = br.readLine();

            boolean flag = false;
            int s = 0;
            int e = words.length() - 1;
            while(s < e){
                if(words.charAt(s) == words.charAt(e)) {
                    s++;
                    e--;
                }
                else{
                    if(cal(words, s + 1, e) || cal(words, s, e - 1)){
                        System.out.println(1);
                        flag = true;
                        break;
                    }
                    else{
                        System.out.println(2);
                        flag = true;
                        break;
                    }

                }
            }
            if(flag == false) System.out.println(0);

        }
    }

    static boolean cal(String words, int s, int e){

        while(s < e){
            if(words.charAt(s) != words.charAt(e)) return false;
            s++;
            e--;
        }
        return true;
    }
}
