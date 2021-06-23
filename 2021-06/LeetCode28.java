//https://leetcode.com/problems/implement-strstr/
public class LeetCode28 {
}

/*
   0123456789ABCDE
   ababaaabbababab
       aab
        aab
*/
class Solution {

    public static void main(String[] args) {
        final Solution s = new Solution();
        System.out.println(s.strStr("ababaaabbababab", "aab"));
        System.out.println(s.strStr("hello", "ll"));
        System.out.println(s.strStr("aaaaa", "bba"));
        System.out.println(s.strStr("", ""));
        System.out.println(s.strStr("aabc", "bc"));
        System.out.println(s.strStr("", "a"));
        System.out.println(s.strStr("aaa", "aaa"));
    }


    public int strStr(String haystack, String needle) {
        final int nLen = needle.length();
        final int hLen = haystack.length();

        if (nLen == 0) {
            return 0;
        } else if (nLen > hLen) {
            return -1;
        }

        final int diff = hLen - nLen;

        int i = 0;
        int needlePos = 0;
        while(i<hLen) {
            if (haystack.charAt(i++) == needle.charAt(needlePos++)) {
                if (needlePos == nLen) {
                    return i - needlePos;
                }
            } else {
                i = i + 1 - needlePos;
                if (i > diff) {
                    return -1;
                }
                needlePos = 0;
            }
        }
        return -1;
    }
}
