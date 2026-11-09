package two;

import java.util.Scanner;
import java.util.StringTokenizer;

public class WeatherForecaster {

    static void main() {
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        char[][] map = new char[y][x];

        for (int i = 0; i < y; i++) {
            String str = sc.nextLine();
            for(int j = 0; j < x; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int[][] forecast = new int[y][x];

        for(int i = 0; i < y; i++) {
            int minute = 0;
            boolean found = false;
            for(int j = 0; j < x; j++) {
                if(map[i][j] == 'c') {
                    found = true;
                    minute = 0;
                    forecast[i][j] = minute;
                }
                else {
                    if(found) {
                        minute++;
                        forecast[i][j] = minute;
                    }
                    else {
                        forecast[i][j] = -1;
                    }
                }
            }
        }
        for(int i =0; i < y; i++) {
            for(int j = 0; j < x; j++) {
                System.out.print(forecast[i][j] + " ");
            }
            System.out.println();
        }
    }
}
