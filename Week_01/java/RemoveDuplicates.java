/**
 * @author Zewei Ni
 * @version :PACKAGE_NAME on 2020-09-24 21:18 Zewei Ni
 * @name RemoveDuplicates
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        //双指针
        int i=0;
        for (int j=1; j<nums.length; j++) {
            if (nums[i] == nums[j]) {
                continue;
            }
            nums[i+1] = nums[j];
            i++;
        }
        return i+1;
    }
}
