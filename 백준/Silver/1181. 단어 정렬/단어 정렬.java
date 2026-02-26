import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String words[] = new String[n];
		
		for(int i = 0; i < n; i++) {
			words[i] = br.readLine();
		}

		Arrays.sort(words, (a, b) -> {
			if (a.length() != b.length()) return a.length() - b.length(); // 짧은 게 먼저
			return a.compareTo(b);                                        // 길이 같으면 사전순
});
		

        String prev = null;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(prev)) continue;  // 중복이면 출력 X
            System.out.println(words[i]);
            prev = words[i];
        }
	}
}
