import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // sort to handle duplicates
        backtrack(nums, new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> result, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

           
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            tempList.add(nums[i]);
            used[i] = true;
            backtrack(nums, tempList, result, used);
            used[i] = false; 
            tempList.remove(tempList.size() - 1);
        }
    }
}
