// https://leetcode.com/problems/palindrome-number
public class LeetCode9 {
}

/*
121 - 121 yes
-121 - 121- no
10 -01 - no
Integer.MIN_VALUE..Integer.MAX_VALUE
*/

class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        final char[] buffer = new char[10];
        int pos = 0;
        while(x >= 10) {
            final int digit = x % 10;
            x = (x - digit) / 10;
            buffer[pos++] = digit2char(digit);
        }
        buffer[pos++] = digit2char(x);

        if (pos == 1) {
            return true;
        }

        int left = 0;
        int  right = pos - 1;
        while(left < right) {
            if (buffer[left++] != buffer[right--]) {
                return false;
            }
        }
        return true;
    }

    private char digit2char(int digit) {
        return (char)(digit + '0');
    }
}
