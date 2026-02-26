import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> min = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> max = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());

            if(min.size() == 0){
                min.add(num);
            }
            else if(max.size() == 0){
                if(num < min.peek()){
                    max.add(min.poll());
                    min.add(num);
                }
                else{
                    max.add(num);
                }
            }
            else if(min.size() != 0 && min.size() == max.size()){
                if(max.peek() < num){
                    min.add(max.poll());
                    max.add(num);
                }
                else{
                    min.add(num);
                }
            }
            else if(min.size() >= 1 && max.size() >= 1 && min.size() > max.size()) {
                if (min.peek() > num) {
                    max.add(min.poll());
                    min.add(num);
                } else {
                    max.add(num);
                }
            }
            System.out.println(min.peek());
        }
    }
}
