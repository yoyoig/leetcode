package com.yoyoig.leetcode.removeduplicates;

/**
 * <p>
 * 根据官方题解思路重做
 * </p>
 *
 * @author mingke 2019-11-05 5:14 下午
 */
public class RemoveDuplicatesPro {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int i = 0;
        // j 在前面，每次不等 i++ j++，并将i+1的位置和j的位置互换
        // 对于[1,2,3,4]的情况有多余的替换操作。
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


}
