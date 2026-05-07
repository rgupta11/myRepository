package com.rga.q.crackingCodingQ.search;


/**
 * DESCRIPTION (inspired by Leetcode.com)
You are given an array nums and an integer k. nums represents the weights of n consecutive tasks while k represents the number of workers. Tasks are assigned to the workers as contiguous blocks.

Your goal is to distribute the work so that the heaviest workload (sum of task weights for any single worker) is as small as possible.

Return the minimum possible value of the maximum workload.

nums = [4, 8, 15, 7, 3], k = 3
Output: 15

Approach:
1. Binary Search on the answer: The maximum workload will be between the maximum single task weight
    and the total weight of all tasks. We can use binary search to find the optimal maximum workload.
2. Create range of nos - Max to sum of all elements in nums [15 37]
3. For each mid in the range, check if it is possible to assign tasks to k    
    workers such that no worker has a workload greater than mid.
    - Initialize current workload and worker count to 0
    - Iterate through the tasks and keep adding task weights to current workload
    - If current workload exceeds mid, increment worker count and reset current workload to current task weight
    - If worker count exceeds k, it means mid is too small, so we need to search in the upper half of the range
4. If worker count is within k, it means mid is a valid maximum workload, so we can try to find a smaller maximum workload by searching in the lower half of the range
5. Continue the binary search until low is less than or equal to high, and return the minimum valid
maximum workload found.


 */
public class SplitArrayLargestSum {

        public static int splitArray(int[] nums, int k) {
            int low = 0, high = 0;
            for (int num : nums) {
                low = Math.max(low, num); // The maximum single task weight
                high += num; // The total weight of all tasks
            }
            
            while (low <= high) {
                int mid = low + (high - low) / 2; // Midpoint of the current range
                
                if (canSplit(nums, k, mid)) {
                    high = mid - 1; // Try to find a smaller maximum workload
                } else {
                    low = mid + 1; // Mid is too small, search in the upper half
                }
            }
            
            return low; // The minimum valid maximum workload found
        }
        
        private static boolean canSplit(int[] nums, int k, int maxWorkload) {
            int currentWorkload = 0;
            int workerCount = 1; // Start with one worker
            
            for (int num : nums) {
                if (currentWorkload + num > maxWorkload) {
                    workerCount++; // Need another worker
                    currentWorkload = num; // Start new workload with current task
                    
                    if (workerCount > k) {
                        return false; // More workers needed than available
                    }
                } else {
                    currentWorkload += num; // Add task to current workload
                }
            }
            
            return true; // All tasks can be assigned within maxWorkload
        }

    public static void main(String[] args) {
        int[] nums = {4, 8, 15, 7, 3};
        int k = 3;
        int result = splitArray(nums, k);
        System.out.println("Minimum possible value of the maximum workload: " + result);
    
    }
}
