import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> li = new ArrayList<>();
        while (true){
            String s = br.readLine();
            if(s.equals(".")){
                break;
            }
            if(go(s)){
                li.add("yes");
            }
            else {
                li.add("no");
            }
        }
        for(String s : li){
            System.out.println(s);
        }
    }

    private static boolean go(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) == '[' || s.charAt(i) == '(')
                stk.push(s.charAt(i));
            else if (s.charAt(i) == ']') {
                if(!stk.isEmpty()){
                    if(stk.peek() == '['){
                        stk.pop();
                    }
                    else
                        return false;
                }
                else
                    return false;
            }
            else if (s.charAt(i) == ')') {
                if(!stk.isEmpty()){
                    if(stk.peek() == '('){
                        stk.pop();
                    }
                    else
                        return false;
                }
                else
                    return false;
            }
        }
        return (stk.isEmpty());
    }
}