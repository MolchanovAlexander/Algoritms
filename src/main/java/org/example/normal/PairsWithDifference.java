package org.example.normal;

public class PairsWithDifference {
  public int countKDifference(int[] nums, int k) {
    int count = 0;
    for (int i = 1; i < nums.length; i++) {
      for (int j = i; j < nums.length; j++) {
        if (Math.abs(nums[i - 1] - nums[j]) == k) {
          count++;
        }
      }
    }
    return count;
  }
}
/*Your task is to count the number of pairs (i, j) in an integer array nums,
where i < j and the absolute difference between nums[i] and nums[j] is equal to a given integer k.
The absolute difference |x| is defined as:
x if x >= 0.
-x if x < 0.
Examples
Example 1:
Input: nums = [1,2,2,1], k = 1
Output: 4
Explanation: The pairs with an absolute difference of 1 are:
[1, 2, 2, 1] (1st and 2nd elements)
[1, 2, 2, 1] (1st and 3rd elements)
[1, 2, 2, 1] (2nd and 4th elements)
[1, 2, 2, 1] (3rd and 4th elements)
Example 2:
Input: nums = [1,3], k = 3
Output: 0
Explanation: There are no pairs with an absolute difference of 3.
Example 3:
Input: nums = [3,2,1,5,4], k = 2
Output: 3
Explanation: The pairs with an absolute difference of 2 are:
[3, 2, 1, 5, 4] (1st and 3rd elements)
[3, 2, 1, 5, 4] (1st and 4th elements)
[3, 2, 1, 5, 4] (2nd and 5th elements)
Constraints
1 <= nums.length <= 200
1 <= nums[i] <= 100
1 <= k <= 99
*/
