// https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
public class LeetCode1450 {
}

/*
 startTime = [1,2,3], endTime = [3,2,7], queryTime = 4 -> 1
 startTime = [4], endTime = [4], queryTime = 4 -> 1
 startTime = [4], endTime = [4], queryTime = 5 -> 0
*/
class Solution1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {

        final int n = startTime.length;
        if (n == 0) {
            return 0;
        }

        int counter = 0;
        for(int i=0; i < n; ++i) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                ++counter;
            }
        }

        return counter;
    }
}