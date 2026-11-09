package two;

import java.util.Scanner;

public class NBA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int scoreA = 0;
        int scoreB = 0;
        int totalASeconds = 0;
        int totalBSeconds = 0;
        int previousTime = 0;
        final int gameTime = 48 * 60;

        for (int i = 0; i < n; i++) {
            int team = sc.nextInt();
            int scoreTime = convertSeconds(sc.next());

            // 득점 직전까지 앞서 있던 팀에 경과 시간을 더한다.
            int elapsed = scoreTime - previousTime;
            if (scoreA > scoreB) {
                totalASeconds += elapsed;
            } else if (scoreB > scoreA) {
                totalBSeconds += elapsed;
            }

            if (team == 1) {
                scoreA++;
            } else {
                scoreB++;
            }

            previousTime = scoreTime;
        }

        // 마지막 득점부터 경기 종료까지의 시간도 더한다.
        int elapsed = gameTime - previousTime;
        if (scoreA > scoreB) {
            totalASeconds += elapsed;
        } else if (scoreB > scoreA) {
            totalBSeconds += elapsed;
        }

        System.out.println(convertOutput(totalASeconds));
        System.out.println(convertOutput(totalBSeconds));
    }

    static int convertSeconds(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    static String convertOutput(int seconds) {
        return String.format("%02d:%02d", seconds / 60, seconds % 60);
    }
}