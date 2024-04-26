import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static char[] vowel = {'a', 'e', 'i', 'o', 'u'};
    static String acc = "> is acceptable.\n";
    static String not = "> is not acceptable.\n";

    private static boolean isVowel(char ch) {
        for (char vow : vowel) {
            if (vow == ch)
                return true;
        }
        return false;
    }

    private static boolean containVowel(char[] pass) {
        for (int i = 0; i < pass.length; i++) {
            if (isVowel(pass[i])) {
                return true;
            }
        }
        return false;
    }

    private static boolean isContinuous(char ch1, char ch2) {
        if (ch1 == ch2) {
            if (ch1 == 'e')
                return false;
            else if (ch1 == 'o')
                return false;
            else {
                return true;
            }
        }
        return false;
    }

    private static String solution(String password) {
        boolean flag = true;
        char[] pass = password.toCharArray();
        for (int i = 0; i < pass.length; i++) {
            if (!containVowel(pass)) flag = false;

            if (i > 0) {
                if (isContinuous(pass[i], pass[i - 1])) {
                    flag = false;
                }
            }
            if (i > 1) {
                if (isVowel(pass[i])) {
                    if (isVowel(pass[i - 1]) && isVowel(pass[i - 2])) {
                        flag = false;
                    }
                } else {
                    if (!isVowel(pass[i - 1]) && !isVowel(pass[i - 2])) {
                        flag = false;
                    }
                }
            }
        }

        if(flag){
            return "acceptable.";
        }
        else {
            return "not acceptable.";
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> passwords = new ArrayList<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String password = br.readLine();
            if (password.equals("end")) {
                break;
            }
            passwords.add(password);
        }

        for (String password : passwords) {
            String answer = solution(password);
            bw.write("<" + password + ">" + " is " + answer + "\n");
        }
        bw.flush();
    }
}