import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/contains-duplicate/
public class LeetCode217 {
}

class Solution {
    public boolean containsDuplicate(int[] nums) {

        final Set<Integer> dupes = new HashSet<>();
        for (int i=0; i < nums.length; ++i) {
            final int current = nums[i];
            if (dupes.contains(current)) {
                return true;
            } else {
                dupes.add(current);
            }
        }
        return false;
    }
}
