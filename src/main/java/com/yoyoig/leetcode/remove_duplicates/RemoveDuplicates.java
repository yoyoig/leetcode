package com.yoyoig.leetcode.remove_duplicates;

/**
 * <p>
 * 自己的写的方案
 * </p>
 *
 * @author mingke 2019-11-05 5:14 下午
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int j = 1;
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            for (; j < nums.length; j++) {
                // 如果相邻数据不等则直接跳过
                if (nums[i] != nums[j] && j == i + 1) {
                    break;
                }
                // 如果数据不等且不相临则下个元素 替换 j位置元素
                if (nums[i] != nums[j] && j != i + 1) {
                    i++;
                    nums[i] = nums[j];
                }
            }
            // 如果j已经到数组末尾，则退出循环
            if (j == nums.length) {
                size = i + 1;
                break;
            }
        }
        return size;
    }


}
