import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://contest.yandex.ru/contest/27393/problems/B/
public class Yandex27393B {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            final int a = Integer.parseInt(br.readLine());
            final int b = Integer.parseInt(br.readLine());
            final int c = Integer.parseInt(br.readLine());

            if ( ((a + b) > c) && ((a + c) > b) && ((b + c) > a) ) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

}
