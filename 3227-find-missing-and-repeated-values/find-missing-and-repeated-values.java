class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        HashSet<Integer> set = new HashSet<>();
        int repeated = -1;
        for (int[] row : grid) {
            for (int num : row) {
                if (set.contains(num)) {
                    repeated = num;
                }
                set.add(num);
            }
        }
        int missing = -1;
        for (int i = 1; i <= size; i++) {
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }
        return new int[]{repeated, missing}; 
    }
}