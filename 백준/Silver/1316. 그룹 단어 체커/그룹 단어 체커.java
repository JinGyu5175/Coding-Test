import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int cnt = n; // 그룹 단어 cnt
		
		for(int i = 0; i < n; i++) {
			Set<Character> set = new HashSet<>();
			String s = br.readLine();
			
			char past = 0;
			
			for(int j = 0; j < s.length(); j++) {
				char cur_char = s.charAt(j); // 현재 Char
				
				if(past == 0) { // 맨 앞 글자 Check
					past = cur_char; // 앞 글자 저장
					set.add(cur_char); // Set에 저장
				}
				else {
					if(past == cur_char) // 앞 글자와 일치 -> continue
						continue;
					else if(set.contains(cur_char)) { // 앞글자와 일치 x, But 중복된 경우
						cnt -= 1; // 오답처리
						break;
						} 
					else { // 앞 글자와 다르고 중복되지 않은 Char일 경우
						past = cur_char; 
						set.add(cur_char);
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
