package com.yoyoig.leetcode.moveZeroes;

/**
 * <p>
 * description
 * </p>
 *
 * @author mingke.yan@hand-china.com 2019-11-05 9:36 下午
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        // 0的数量
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                // 统计0的数量
                count++;
            } else {
                // 如果不为0，则将该数字需要向前移动 0的个数位
                nums[i - count] = nums[i];
            }
        }
        // 将移动后的末尾多余数据填充为 0
        for (int i = nums.length - count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
