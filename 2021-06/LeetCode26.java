import java.util.Arrays;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class LeetCode26 {
}

class Solution26 {

    public static void main(String[] args) {
        final int[] nums = new int[10];
        nums[0] = 0;
        nums[1] = 0;
        nums[2] = 1;
        nums[3] = 1;
        nums[4] = 1;
        nums[5] = 2;
        nums[6] = 2;
        nums[7] = 3;
        nums[8] = 3;
        nums[9] = 4;
        System.out.println(new Solution26().removeDuplicates2(nums));
        System.out.println(Arrays.toString(nums));
    }


    public int removeDuplicates(int[] nums) {

        final int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int nextNonDupIndex = 0;
        int nonDupValue = nums[nextNonDupIndex++];

        for (int i = 1; i < n; ++i) {
            int currentValue = nums[i];
            if (currentValue > nonDupValue) {
                nonDupValue = currentValue;
                nums[nextNonDupIndex++] = nonDupValue;
            }
        }
        return nextNonDupIndex;
    }

    public int removeDuplicates2(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int nextNonDupIndex = 1;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[nextNonDupIndex - 1]) {
                nums[nextNonDupIndex++] = nums[i];
            }
        }
        return nextNonDupIndex;
    }

}
