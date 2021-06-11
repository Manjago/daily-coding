// https://leetcode.com/problems/group-anagrams
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode49 {
}

/*
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Input: strs = [""]
Output: [[""]]

Input: strs = ["a"]
Output: [["a"]]

*/
class Solution49_1 {
    public List<List<String>> groupAnagrams(String[] strs) {

        final int n = strs.length;
        if (n == 0) {
            throw new IllegalArgumentException();
        }

        final Map<String, List<String>> data = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            final String current = strs[i];
            final String key = calcKey(current);
            if (data.containsKey(key)) {
                data.get(key).add(current);
            } else {
                final List<String> value = new ArrayList<>();
                data.put(key, value);
                value.add(current);
            }
        }

        return new ArrayList<>(data.values());
    }

    private String calcKey(String s) {
        final char[] temp = s.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }
}

class Solution49_2 {
    public List<List<String>> groupAnagrams(String[] strs) {

        final int n = strs.length;
        if (n == 0) {
            throw new IllegalArgumentException();
        }

        final int[] counter = new int[26];

        final Map<String, List<String>> data = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            final String current = strs[i];
            final String key = fastCalcKey(current, counter);
            if (data.containsKey(key)) {
                data.get(key).add(current);
            } else {
                final List<String> value = new ArrayList<>();
                data.put(key, value);
                value.add(current);
            }
        }

        return new ArrayList<>(data.values());
    }

    private String fastCalcKey(String s, int[] counter) {
        Arrays.fill(counter, 0);
        for (int i = 0; i < s.length(); ++i) {
            final int index = s.charAt(i) - 'a';
            ++counter[index];
        }

        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; ++i) {
            sb.append('.');
            sb.append(counter[i]);
        }

        return sb.toString();
    }

}
