import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String words = br.readLine();
    	String target = br.readLine();
    	int tl = target.length();
    	char []stack = new char[words.length()];
    	
    	int top = 0;
    	
    	for(int i = 0; i < words.length(); i++) {
    		stack[top] = words.charAt(i);
    		boolean correct = true;
    		if(top >= tl - 1) { // stack의 담은 글자 수의 길이가 target보다 길어지면
    			for(int j = 0; j < tl; j++) { // target과 동일한지 체크
    				if(stack[top - tl + 1 + j] != target.charAt(j)) {
    					correct = false;
    					if(correct == false) {
    						break;
    					}
    				}
    			}
    			if(correct) { // 동일하면
    				top -= tl;
    			}
    		}
    		top++;
    	}
    	StringBuilder sb = new StringBuilder();
    	if(top == 0) {
    		sb.append("FRULA");
    	}
    	else {
    		for(int i = 0; i < top; i++) {
        		sb.append(stack[i]);
        	}
    	}
    	System.out.println(sb);
    	
    	
    }
}