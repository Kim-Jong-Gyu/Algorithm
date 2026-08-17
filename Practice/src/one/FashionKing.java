package one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class FashionKing {

    static void main() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {

            int m = Integer.parseInt(br.readLine());

            // 종류 , 개수
            Map<String, Integer> map = new HashMap<>();

            for (int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String category = st.nextToken();
                map.put(category, map.getOrDefault(category, 0) + 1);
            }
            int result = 1;
            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                result *= entry.getValue() + 1;
            }
            answer[i] = result - 1;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(answer[i]);
        }
    }

}
