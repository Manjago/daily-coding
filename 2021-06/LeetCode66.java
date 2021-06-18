import java.util.Arrays;

// https://leetcode.com/problems/plus-one/
public class LeetCode66 {
}

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().plusOne1(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(new Solution().plusOne1(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(new Solution().plusOne1(new int[]{0})));
        System.out.println(Arrays.toString(new Solution().plusOne1(new int[]{9,9})));
    }

    public int[] plusOne(int[] digits) {

        final int n = digits.length;

        //check 9
        boolean no9 = false;
        for (int i = 0; i < n; ++i) {
            if (digits[i] != 9) {
                no9 = true;
                break;
            }
        }

        if (!no9) {
            final int[] result9 = new int[n + 1];
            result9[0] = 1;
            return result9;
        }

        //normal flow
        final int[] result = new int[n];
        int carry = 1;
        for (int i = n - 1; i >= 0; --i) {
            final int temp = digits[i] + carry;
            if (temp >= 10) {
                result[i] = temp - 10;
                carry = 1;
            } else {
                result[i] = temp;
                carry = 0;
            }
        }

        return result;
    }

    public int[] plusOne1(int[] digits) {

        final int n = digits.length;

        //check 9
        boolean no9 = false;
        for(int i=0; i<n; ++i){
            if (digits[i] != 9) {
                no9 = true;
                break;
            }
        }

        if (!no9) {
            final int[] result9 =  new int[n + 1];
            result9[0] = 1;
            return result9;
        }

        //normal flow
        for(int i = n - 1; i >= 0; --i) {
            final int temp = digits[i] + 1;
            if (temp >= 10) {
                digits[i] = temp - 10;
            } else {
                digits[i] = temp;
                break;
            }
        }

        return digits;
    }

}
