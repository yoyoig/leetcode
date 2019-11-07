package com.yoyoig.leetcode.rotate;

/**
 * <p>
 * 旋转数组
 * </p>
 *
 * @author mingke.yan@hand-china.com 2019-11-06 4:59 下午
 */
public class Rotate {

    /**
     * 右旋解答
     * 非原地
     * 时间复杂 O(n)
     * 空间复杂 O(n)
     */
    public void rightRotate(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }
        int l = k % nums.length;
        if (l == 0) {
            return;
        }
        // 数组的后k个数据
        int[] cache = new int[l];
        // 需要缓存的次数 需要注意有可能缓存不到全部数据，所以这里取更小的值 对于需要移动的个数是否超过数组的一半
        int count = nums.length - l < l ? nums.length - l : l;
        for (int i = nums.length - 1; i >= count; i--) {
            // 将后 k 个数据缓存
            if (nums.length - i <= l) {
                cache[nums.length - i - 1] = nums[i];
            }
            // 对于末尾先移动 不需要缓存的移动
            if (i >= l) {
                nums[i] = nums[i - l];
            }
        }
        // 将缓存的数据填充到后面
        for (int i = 0; i < l; i++) {
            nums[i] = cache[l - 1 - i];
        }
    }

}
