package org.example;
/*mentors
getMaxSubarraySum({-25, 12, -32, 0, 15, 50, -14}) ==> 65 // 15 + 50
getMaxSubarraySum({1, 2, 3, 4, 5}) ==> 15 // 1 + 2 + 3 + 4 + 5
getMaxSubarraySum({-6, -7, -8}) ==> 0 // всі числа від'ємні

*/
public class NumberArray {
    public static int getMaxSubarraySum(int[] nums) {
        int cur = 0;
        int max = 0;
        for (int num : nums) {
            cur = Math.max(0, cur + num);
            max = Math.max(cur, max);
        }
        return max;
    }
}