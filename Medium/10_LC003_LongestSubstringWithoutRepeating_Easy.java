class Solution {
    public int lengthOfLongestSubstring(String s) {

        int max = 0;
        int start = 0;

        int[] arr = new int[128];

        for (int end = 0; end < s.length(); end++) {

            char ch = s.charAt(end);

            while (arr[ch] == 1) {
                arr[s.charAt(start)] = 0;
                start++;
            }

            arr[ch] = 1;

            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
