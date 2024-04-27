import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s;
        ArrayList<String> inputs = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            s = br.readLine();
            inputs.add(s);
        }
        for (String str : inputs) {
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    tmp.append(str.charAt(i));
                } else if (tmp.length() != 0) {
                    answer.add(eraseZ(String.valueOf(tmp)));
                    tmp.setLength(0);
                }
            }
            if (tmp.length() != 0) {
                answer.add(eraseZ(String.valueOf(tmp)));
                tmp.setLength(0);
            }
        }
        Collections.sort(answer,((o1, o2) -> {
            if(o1.length() == o2.length())
                return o1.compareTo(o2);
            else
                return o1.length() - o2.length();
        }));
        for (String ret : answer) {
            System.out.println(ret);
        }
    }

    private static String eraseZ(String s){
        String tmp = s;
        while(true){
            if(tmp.startsWith("0")) {
                tmp = tmp.substring(1);
            }
            else break;
        }
        if(tmp.length() == 0) tmp = "0";
        return tmp;
    }
}