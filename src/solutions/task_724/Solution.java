package solutions.task_724;

/**
 * 724. Find Pivot Index
 * Given an array of integers nums, calculate the pivot index of this array.
 * The pivot index is the index where the sum of all the numbers strictly to
 * the left of the index is equal to the sum of all the numbers strictly to the index's right.
 * If the index is on the left edge of the array, then the left sum is
 * 0 because there are no elements to the left. This also applies to the right edge of the array.
 * Return the leftmost pivot index. If no such index exists, return -1.
 */

class Solution {
    public int pivotIndex(int[] nums) {
        int[][] sum = new int[nums.length][2];
        sum[0][0] = 0;
        sum[nums.length - 1][1] = 0;
        for (int i = 1; i < nums.length; i++) {
            sum[i][0] = sum[i - 1][0] + nums[i - 1];
            sum[nums.length - 1 - i][1] = sum[nums.length - i][1] + nums[nums.length - i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (sum[i][0] == sum[i][1]) {
                return i;
            }
        }
        return -1;
    }
}