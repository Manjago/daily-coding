import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://contest.yandex.ru/contest/27393/problems/C/
public class Yandex27393C {
    /*
    8(495)430-23-97
    +7-4-9-5-43-023-97 YES
    4-3-0-2-3-9-7 YES
    8-495-430 NO
    */
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            final Stack stack = new Stack();
            final String mold = normalForm(br.readLine(), stack);
            final String a = normalForm(br.readLine(), stack);
            final String b = normalForm(br.readLine(), stack);
            final String c = normalForm(br.readLine(), stack);
            test(mold, a);
            test(mold, b);
            test(mold, c);
        }
    }

    private static void test(String x, String y) {
        if (x.equals(y)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static String normalForm(String s, Stack stack) {
        for(int i = s.length() - 1; i >=0; --i) {
            final char current = s.charAt(i);

            if (Character.isDigit(current)) {
                stack.push(current);
            }
        }

        final int n = stack.size();
        final StringBuilder sb = new StringBuilder();
        if (n == 11) {
            // normal
            final char c = stack.pop();
            if (c == '7') {
                sb.append('8');
            } else {
                sb.append(c);
            }
            fill(sb, stack);

        } else if (n == 8) {
            // no code
            final char c = stack.pop();
            if (c == '7') {
                sb.append('8');
            } else {
                sb.append(c);
            }
            sb.append("495");
            fill(sb, stack);
        } else if (n == 7) {
            // no code no country code
            sb.append("8495");
            fill(sb, stack);
        } else if (n == 10) {
            // no country code
            sb.append('8');
            fill(sb, stack);
        } else {
            fill(sb, stack);
        }
        return sb.toString();
    }


    private static void fill(StringBuilder sb, Stack st) {
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
    }

    static class Stack {

        private final char[] data = new char[20];
        private int pos = 0;

        void push(char c) {
            data[pos++] = c;
        }

        char pop() {
            if (pos == 0) {
                throw new IllegalStateException();
            }
            final int getPos = pos-1;
            --pos;
            return data[getPos];
        }

        boolean isEmpty() {
            return pos == 0;
        }

        int size() {
            return pos;
        }
    }



}
