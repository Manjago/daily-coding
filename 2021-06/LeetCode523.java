// https://leetcode.com/problems/continuous-subarray-sum/
import java.util.HashMap;
import java.util.Map;

public class LeetCode523 {
}

class Solution523 {

    public static void main(String[] args) {

        {
            /*
            [1,2,3]
            5
             */
            final int[] nums = new int[3];
            nums[0] = 1;
            nums[1] = 2;
            nums[2] = 3;
            boolean actual2 = new Solution523().checkSubarraySum(nums, 5);
            if (!actual2) {
                throw new IllegalStateException();
            } else {
                System.out.println("Ok");
            }
        }
        {
            /*
            [0,1,0,3,0,4,0,4,0]
            5
             */
            final int[] nums = new int[9];
            nums[0] = 0;
            nums[1] = 1;
            nums[2] = 0;
            nums[3] = 3;
            nums[4] = 0;
            nums[5] = 4;
            nums[6] = 0;
            nums[7] = 4;
            nums[8] = 0;
            boolean actual2 = new Solution523().checkSubarraySum(nums, 5);
            if (actual2) {
                throw new IllegalStateException();
            } else {
                System.out.println("Ok");
            }
        }

        {
            // [23,2,4,6,6]
            final int[] nums = new int[5];
            nums[0] = 23;
            nums[1] = 2;
            nums[2] = 4;
            nums[3] = 6;  // 23 + 2 + 4 + 6 = 35 = 5 * 7
            nums[4] = 6;
            boolean actual = new Solution523().checkSubarraySum(nums, 7);
            if (!actual) {
                throw new IllegalStateException();
            } else {
                System.out.println("Ok");
            }
        }

        {
            final int[] nums = new int[4];
            nums[0] = 5;
            nums[1] = 0;
            nums[2] = 0;
            nums[3] = 0;
            boolean actual2 = new Solution523().checkSubarraySum(nums, 3);
            if (!actual2) {
                throw new IllegalStateException();
            } else {
                System.out.println("Ok");
            }
        }


    }

    /*
    (a % k == c) && (b % k == c) => (a - b) % k == 0
    */
    public boolean checkSubarraySum(int[] nums, int k) {
        final int n = nums == null ? 0 : nums.length;
        if (n < 2) {
            return false;
        }

        if (k == 0) {
            throw new IllegalArgumentException();
        }

        final int minDistance = 1; // 2 - 1

        final int[] sum = new int[n];
        sum[0] = nums[0];
        for(int i=1; i< n; ++i) {
            sum[i] = sum[i-1] + nums[i];
        }

        final Map<Integer, Integer> modToPosition = new HashMap<>();
        for (int i=0; i< n; ++i) {
            final int testMod = sum[i] % k;
            if (i!=0 && testMod == 0) {
                return true;
            }
            if (modToPosition.containsKey(testMod)) {
                final int prevPostition = modToPosition.get(testMod);
                if ((i - prevPostition) > minDistance) {
                    return true;
                }
            } else {
                modToPosition.put(testMod, i);
            }
        }

        return false;
    }

}
