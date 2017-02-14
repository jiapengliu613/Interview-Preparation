class FindNumber {
	public static int findIndex(int[] nums, int val) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int total = 0;
		for (int num : nums) {
			if (num == val) {
				total++;
			}
		}
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val) {
				count++;
			}
			int left = nums.length - 1 - i;
			if (count == left - (total - count)) {
				return i + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 5, 6, 2};
		int result = findIndex(nums, 1);
		System.out.println(result);
	}
}