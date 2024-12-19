import java.io.*;
import java.util.*;


class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String boom = br.readLine();
		int boomSize = boom.length();
		Stack<Character> stk = new Stack<>();

		for(int i = 0; i < s.length(); i++){
			stk.add(s.charAt(i));
			if(stk.size() >= boomSize){
				boolean flag = true;
				for(int j = 0; j < boomSize; j++){
					if(stk.get(stk.size() - boomSize + j) != boom.charAt(j)){
						flag = false;
						break;
					}
				}
				if(flag){
					for(int j = 0; j < boomSize; j++){
						stk.pop();
					}
				}
			}
		}
		if(stk.isEmpty()){
			System.out.println("FRULA");
		}
		else {
			StringBuilder sb = new StringBuilder();
			for(Character ch : stk){
				sb.append(ch);
			}
			System.out.println(sb);
		}
	}
}