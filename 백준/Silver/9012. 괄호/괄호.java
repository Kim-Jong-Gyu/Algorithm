import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Character> stk = new Stack<>();
        ArrayList<String> li = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            stk.clear();
            for (int j = 0; j < s.length(); j++) {
                if (stk.isEmpty()) {
                    stk.push(s.charAt(j));
                } else {
                    if (s.charAt(j) == ')' && stk.peek() == '(') {
                        stk.pop();
                    } else {
                        stk.push(s.charAt(j));
                    }
                }
            }
            if (stk.isEmpty()) {
                li.add("YES");
            } else {
                li.add("NO");
            }
        }
        for (
                String str : li) {
            System.out.println(str);
        }
    }
}