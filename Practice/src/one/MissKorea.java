package one;

import java.util.Scanner;

public class MissKorea {

    static void main() {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        String pattern = sc.nextLine();

        String prefix = pattern.substring(0, pattern.indexOf('*'));

        String suffix = pattern.substring(pattern.indexOf('*') + 1);

        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = sc.nextLine();
        }

        for(int i = 0; i < n; i++){
            if(str[i].startsWith(prefix) && str[i].endsWith(suffix)){
                System.out.println("DA");
            }
            else{
                System.out.println("NE");
            }
        }
    }

}

