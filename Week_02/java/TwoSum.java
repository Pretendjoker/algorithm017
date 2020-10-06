import java.util.HashMap;

/**
 * 两数之和
 * @author Zewei Ni
 * @version :PACKAGE_NAME on 2020-09-28 17:29 Zewei Ni
 * @name TwoSum
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //一遍hash
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }
}
