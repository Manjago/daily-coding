import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://contest.yandex.ru/contest/27393/problems/A/
public class Yandex27393A {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int tRoom = Integer.parseInt(st.nextToken());
            final int tCond = Integer.parseInt(st.nextToken());
            final String command = br.readLine();

            switch(command) {
                case "freeze":
                    if (tCond < tRoom) {
                        System.out.println(tCond);
                    } else {
                        System.out.println(tRoom);
                    }
                    return;
                case "heat":
                    if (tCond > tRoom) {
                        System.out.println(tCond);
                    } else {
                        System.out.println(tRoom);
                    }
                    return;
                case "auto":
                    System.out.println(tCond);
                    return;
                case "fan":
                    System.out.println(tRoom);
                    return;
                default:
                    throw new IllegalArgumentException(command);

            }

        }
    }
}

