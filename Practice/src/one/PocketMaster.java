package one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class PocketMaster {

    static void main() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 포켓몬 이름
        String[] pocketArr = new String[n + 2];
        Map<String, Integer> pocketMap = new HashMap<String, Integer>();

        // Map을 통해 문자 입력시 숫자 반환
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            pocketArr[i + 1] = s;
            pocketMap.put(s, i + 1);
        }

        // 입력값이 숫자인지 문자열인지 분기
        for (int i = 0; i < m; i++) {
            String question = br.readLine();
            if (Character.isDigit(question.charAt(0))) {
                int num = Integer.parseInt(question);
                System.out.println(pocketArr[num]);
            } else {
                System.out.println(pocketMap.get(question));
            }
        }
    }

}
