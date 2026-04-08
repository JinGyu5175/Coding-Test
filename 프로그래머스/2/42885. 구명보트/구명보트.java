import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int l = people.length;
        
        int end = l - 1;
        int start = 0;
        if(l == 1){
            return 1;
        }
        while(start <= end){
            if(people[start] + people[end] <= limit){
                start++;
            }
            answer += 1;
            end -= 1;

        }
        return answer;
    }
}