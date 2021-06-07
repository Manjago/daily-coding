// https://leetcode.com/problems/string-compression
/*
  Example 1:

Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".

Example 2:

Input: chars = ["a"]
Output: Return 1, and the first character of the input array should be: ["a"]
Explanation: The only group is "a", which remains uncompressed since it's a single character.

Example 3:

Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".

Example 4:

Input: chars = ["a","a","a","b","b","a","a"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","3","b","2","a","2"].
Explanation: The groups are "aaa", "bb", and "aa". This compresses to "a3b2a2". Note that each group is independent even if two groups have the same character.

*/

/*
pos 6
counter 3
current c
prev c
["a","a","b","b","c","c","c"]
  a   2   b   2   c   3

*/
class Solution {


    public int compress(char[] chars) {

        final int n =  chars.length;


        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        final char[] buffer = new char[4];

        int pos = 0;
        char prev = chars[pos++];
        int counter = 1;


        for (int i=1; i < n; ++i) {
            char current = chars[i];
            if (current != prev) {

                pos = writeCounter(chars, counter, pos, buffer);
                counter = 1;
                prev = current;
                chars[pos++] = current;
            } else {

                ++counter;

            }
        }

        return writeCounter(chars, counter, pos, buffer);
    }

    private int writeCounter(char[] chars, int counter, int pos, char[] buffer) {

        if (counter == 1) {
            return pos;
        } else if (counter <= 9) {
            chars[pos++] = digit2char(counter);
        } else {

            int bufferPos = 0;
            while(counter >= 10) {
                int digit = counter % 10;
                counter = (counter - digit) / 10;
                buffer[bufferPos++] = digit2char(digit);
            }
            buffer[bufferPos++] = digit2char(counter);

            //  2 1 bufferPos 2

            for(int i = bufferPos - 1; i >=0; --i) {
                chars[pos++] = buffer[i];
            }

        }

        return pos;
    }

    private char digit2char(int digit) {
        return (char)(digit + '0');
    }

}















