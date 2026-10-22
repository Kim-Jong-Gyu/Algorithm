package two;

import java.io.*;

public class PasswordPronounce {

    static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s;
        while (!(s = br.readLine()).equals("end")) {
            sb.append('<').append(s).append("> is ")
                    .append(isAcceptable(s) ? "" : "not ")
                    .append("acceptable.\n");
        }
        System.out.print(sb);
    }

    static boolean isAcceptable(String s) {
        boolean hasVowel = false;
        int vowelRun = 0, consonantRun = 0;
        char prev = 0;

        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                hasVowel = true;
                vowelRun++;
                consonantRun = 0;
            } else {
                consonantRun++;
                vowelRun = 0;
            }

            // 모음 3개 또는 자음 3개 연속
            if (vowelRun == 3 || consonantRun == 3) return false;

            // 같은 글자 연속 (ee, oo는 허용)
            if (ch == prev && ch != 'e' && ch != 'o') return false;

            prev = ch;
        }
        return hasVowel;   // 모음이 하나는 있어야 함
    }

    static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}