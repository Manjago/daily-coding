import java.util.Objects;

/*
Remove emoticons  :-), :-), :-)))))),: - ((((((( and the like from the line.
It can be made a state machine, but it is very difficult, easy to make bugs 
 */

public class Solution20210606 {

    public static void main(String[] args) {
        Solution20210606 s = new Solution20210606();
        s.check("", "");
        s.check(":-)", "");
        s.check("a", "a");
        s.check("ab", "ab");
        s.check("a:-)", "a");
        s.check("a:-", "a:-");
        s.check(":-):", ":");
        s.check(":-)a", "a");
        s.check("a:-):-(", "a");
        s.check("a:-):-)", "a");
        s.check("a:-):-)b", "ab");
        s.check("a:-)b:-)c", "abc");
        s.check("a:-)):-(((", "a");
        s.check("a:-)):-))", "a");
        s.check("a:-)):-)b", "ab");
        s.check("a:-)b:-))))c", "abc");
        s.check(":", ":");
        s.check(":-", ":-");
        s.check(":-a", ":-a");
        s.check(":-):-", ":-");
        s.check(":-):-)", "");
        s.check(":-)!:-)", "!");
    }

    public String removeSmiles(String src) {
        final StringBuilder answer = new StringBuilder();

        for(int i=0; i < src.length(); ++i) {

            int rewindedIndex = tryRewind(i, src);

            if (rewindedIndex == i) {
                answer.append(src.charAt(i));
            } else if (rewindedIndex != -1) {
                i = rewindedIndex - 1;
            } else {
                break;
            }
        }
        return answer.toString();
    }

    public int tryRewind(int i, String src) {
        int result = i;
        if ((i + 3) > src.length())  {
            return result;
        }

        if (src.charAt(i) == ':' && src.charAt(i + 1) == '-' &&
                (src.charAt(i+2) == '(' || src.charAt(i+2) == ')')
        ) {
            // we found a smiley, try to extend
            result = i + 3;
            if (result >= src.length()) {
                return -1;
            }

            char mold = src.charAt(i+2);

            while(src.charAt(result) == mold) {
                ++result;
                if (result >= src.length()) {
                    return -1;
                }
            }

            return result;

        } else {
            return result;
        }

    }


    private void check(String parameter, String expected) {
        String actual = removeSmiles(parameter);
        if (!Objects.equals(expected, actual)) {
            throw new IllegalStateException(actual);
        }
    }

}
