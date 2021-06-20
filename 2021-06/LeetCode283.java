import java.util.Arrays;

// https://leetcode.com/problems/move-zeroes/
public class LeetCode283 {
}
class Solution {

    public static void main(String[] args) {
        final int[] data = { 2, 0, 0, 0, 0, 3, 0, 0, 4, 5, 6};
//        final int[] data = { 1};
        new Solution().moveZeroes(data);
        System.out.println(Arrays.toString(data));
    }

    public void moveZeroes(int[] nums) {

        final int n = nums.length;

        int writer = 0;
        while(writer < n) {

            while(nums[writer] != 0) {
                ++writer;
                if (writer == n) {
                    return;
                }
            }

            int reader = writer + 1;
            if (reader == n) {
                return;
            }

            while(nums[reader] == 0) {
                ++reader;
                if (reader == n) {
                    return;
                }
            }
            // writer = 0, reader != 0
            final int temp = nums[writer];
            nums[writer] = nums[reader];
            nums[reader] = temp;
            ++writer;
        }
    }

}
