class Solution {
     public int[] limitOccurrences(int[] nums, int k) {
    List<Integer> result = new ArrayList<>();

        int count = 0;
        int prev = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num != prev) {
                prev = num;
                count = 1;
            } else {
                count++;
            }

            if (count <= k) {
                result.add(num);
            }
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}