import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class L1 {

    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // 15, 16
                if (nums[j] == (target - nums[i])) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No Pair is Found");
    }

    public static int[] twoSumMap(int[] nums, int target) {
       Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; 

        
        // Check if the complement exists in the HashMap
            if (numMap.containsKey(complement)) {
            return new int[] { numMap.get(complement), i };
            } else {
            // If the complement doesn't exist, add the current number to the HashMap
            numMap.put(nums[i], i);
            }
    }

    // If no pair is found, return an empty array or handle it appropriately
    return new int[0];
}
    public static  int[] twoSumPointer(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                return new int[]  {l + 1, r + 1};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[2]; 

    }

    public static void main(String[] args) {
        
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSumBruteForce(nums, target);
        System.out.println(Arrays.toString(result)); 
    }
}