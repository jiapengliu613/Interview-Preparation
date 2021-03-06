public class Solution {
    
    
    
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return ;
        }
        
        
        int n = nums.length;
        int left = 0, right = nums.length - 1;
        for (int i = left; i <= right;) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
                i++;
                //System.out.println("im here");
            } else if (nums[i] == 2) {
                swap(nums, right, i);
                right--;
            } else {
                i++;
            }
        }
        
        
    
        
        
        /*
        int low = 0, high = nums.length - 1;
        for (int i = low; i <= high;) {
            if (nums[i] == 0) {
                swap(nums, low, i);
                low++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, high, i);
                high--;
            } else {
                i++;
            }
        }
        return ;
        */
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}