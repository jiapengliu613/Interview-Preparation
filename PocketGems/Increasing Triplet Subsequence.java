public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int n = nums.length;
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }
        return false;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= firstMin) {
                firstMin = num;
            } else if (num < secondMin) {
                secondMin = num;
            } else if (num > secondMin){
                return true;
            }
        }
        return false;
        */
    }
}