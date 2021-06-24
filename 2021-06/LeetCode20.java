// https://leetcode.com/problems/valid-parentheses/
public class LeetCode20 {
}

class Solution20 {

    public static void main(String[] args) {
        final Solution20 sol = new Solution20();
        lameAssert(sol.isValid("([])"));
        lameAssert(sol.isValid("()"));
        lameAssert(sol.isValid("()[]{}"));
        lameAssert(!sol.isValid("(]"));
        lameAssert(!sol.isValid("([)]"));
        lameAssert(sol.isValid("{[]}"));
    }

    private static void lameAssert(boolean condition) {
        if (!condition) {
            throw new IllegalStateException();
        }
    }

    public boolean isValid(String s) {

        final Stack stack = new Stack();
        for (int i = 0; i < s.length(); ++i) {
            put(stack, s.charAt(i));
        }

        return stack.isEmpty();
    }

    void put(Stack st, char c) {

        if (st.isEmpty()) {
            st.put(c);
        } else {
            final char prev = st.peek();

            if ((prev == '[' && c == ']') ||
                    (prev == '(' && c == ')') ||
                    (prev == '{' && c == '}')
            ) {
                st.drop();
            } else {
                st.put(c);
            }
        }
    }

    static class Stack {
        private final char[] data = new char[10000];
        private int pos = 0;

        boolean isEmpty() {
            return pos == 0;
        }

        void drop() {
            --pos;
        }

        void put(char c) {
            data[pos++] = c;
        }

        char peek() {
            return data[pos - 1];
        }

    }

}

class Solution20_1 {

    public static void main(String[] args) {
        final Solution20_1 sol = new Solution20_1();
        lameAssert(sol.isValid("([])"));
        lameAssert(sol.isValid("()"));
        lameAssert(sol.isValid("()[]{}"));
        lameAssert(!sol.isValid("(]"));
        lameAssert(!sol.isValid("([)]"));
        lameAssert(sol.isValid("{[]}"));
    }

    private static void lameAssert(boolean condition) {
        if (!condition) {
            throw new IllegalStateException();
        }
    }

    public boolean isValid(String s) {

        final char[] data = new char[10000];
        int pos = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (pos == 0) {
                data[pos++] = c;
            } else {
                final char prev = data[pos - 1];

                if ((prev == '[' && c == ']') ||
                        (prev == '(' && c == ')') ||
                        (prev == '{' && c == '}')
                ) {
                    --pos;
                } else {
                    data[pos++] = c;
                }
            }
        }

        return pos == 0;
    }
}