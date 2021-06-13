// https://leetcode.com/problems/subarray-sum-equals-k
public class LeetCode560 {
}

// sum(0,j) just calc i == 0
// sum(i,j)=sum(0,j)-sum(0,i-1), i!= 0
//  1 2 4 8
//  0 1 2 3
// sum(2, 3) = sum[0, 3] - sum(0, 1) = 15 - 3 = 12

class Solution560 {


    public static void main(String[] args) {
        final int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        System.out.println(new Solution560().subarraySum(nums, 3));
    }

    public int subarraySum(int[] nums, int k) {
        final int n = nums.length;
        final int[] sumData = new int[n];

        int result = calcSumData(nums, k, sumData);

        for(int i = 1; i < n; ++i) {
            for(int j = i; j < n; ++j) {
                final int tempSum = sumData[j] - sumData[i-1];
                if (tempSum == k) {
                    ++result;
                }
            }
        }

        return result;
    }

    private int calcSumData(int[] nums, int k, int[] sumData) {
        int result = 0;
        int tempSum = 0;
        for(int i=0; i<nums.length; ++i) {
            tempSum += nums[i];
            if (tempSum == k) {
                ++result;
            }
            sumData[i] = tempSum;
        }
        return result;
    }

}