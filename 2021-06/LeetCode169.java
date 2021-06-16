// https://leetcode.com/problems/majority-element/
import java.util.HashMap;
import java.util.Map;

public class LeetCode169 {
}

class Solution169 {
    public int majorityElement(int[] nums) {
        final int n = nums.length;

        final Map<Integer, Integer> data = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            final int current = nums[i];
            if (data.containsKey(current)) {
                data.put(current, data.get(current) + 1);
            } else {
                data.put(current, 1);
            }
        }

        final int limit = n / 2;
        for (Map.Entry<Integer, Integer> item : data.entrySet()) {
            if (item.getValue() > limit) {
                return item.getKey();
            }
        }
        throw new IllegalArgumentException();
    }
}
