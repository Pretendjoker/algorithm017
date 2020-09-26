/**
 * @author Zewei Ni
 * @version :PACKAGE_NAME on 2020-09-24 21:51 Zewei Ni
 * @name Rotate
 */
public class Rotate {
    public void rotate(int[] nums, int k) {
        //双层循环
        //使用另一个数组
        //反转
        //[1,2,3,4,5,6,7]->[7,6,5,4,3,2,1]->[5,6,7,4,3,2,1]->[5,6,7,1,2,3,4]
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
