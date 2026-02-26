import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int num[] = new int[26];
        for(int i = 0; i < str.length(); i++){
            for(int j = 0; j < 26; j++){
                if(str.charAt(i) == j + 97 && num[j] == 0){
                    num[j] = i + 1;
                }
            }
        }
        for(int i = 0; i < num.length; i++){
            if(num[i] == 0) {
                System.out.print(-1 + " ");
            }
            else{
                    System.out.print(num[i] - 1 + " ");
                }
            }
        }
    }
