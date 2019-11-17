package com.yoyoig.leetcode.sortArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * description
 * </p>
 *
 * @author mingke.yan@hand-china.com 2019-11-08 10:03 上午
 */
public class SortArray {

    /**
     * 冒泡排序
     *
     * @param nums
     * @return
     */
    public List<Integer> bubbleSort(int[] nums) {
        boolean flag;
        for (int i = 0; i < nums.length - 1; i++) {
            flag = true;
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        List<Integer> resultList = new ArrayList<>(nums.length);
        for (int num : nums) {
            resultList.add(num);
        }
        return resultList;
    }

    /**
     * 插入排序优化
     *
     * @param nums
     * @return
     */
    public List<Integer> insertionSort(int[] nums) {
        // 0 - i 有序下标
        int temp;
        for (int i = 0; i < nums.length - 1; i++) {
            // 从后面往前对比，如果前面的大于后面的则交换位置，直到 j - 1 = 0 ，或者 nums[j - 1] > nums[j]
            for (int j = i + 1; j > 0 && nums[j - 1] > nums[j]; j--) {
                temp = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = temp;
            }
        }
        List<Integer> resultList = new ArrayList<>(nums.length);
        for (int num : nums) {
            resultList.add(num);
        }
        return resultList;
    }

    /**
     * 选择排序
     *
     * @param nums
     * @return
     */
    public List<Integer> selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            // 找到最小的
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
        List<Integer> resultList = new ArrayList<>(nums.length);
        for (int num : nums) {
            resultList.add(num);
        }
        return resultList;
    }

    /**
     * 归并排序
     *
     * @param nums
     * @return
     */
    public List<Integer> mergeSort(int[] nums) {
        int[] result = this.mergeAndSort(nums, 0, nums.length - 1);
        List<Integer> resultList = new ArrayList<>(result.length);
        for (int num : result) {
            resultList.add(num);
        }
        return resultList;
    }


    /**
     * mergeAndSort(n) = merge(mergeAndSort(0,p),mergeAndSort(p+1,r))
     * p >= r 结束
     * 6
     * 0 1 1/2 = 2
     *
     * @return
     */
    private int[] mergeAndSort(int[] array, int p, int r) {
        if (p >= r) {
            return array;
        }
        int m = (r + p) / 2;
        mergeAndSort(array, p, m);
        mergeAndSort(array, m + 1, r);
        return this.merge(array, p, m, r);
    }

    /**
     * merge(mergeSort(0,p),mergeAndSort(p,r))
     *
     * @return
     */
    private int[] merge(int[] array, int p, int m, int r) {
        // 将数据排序放入新数组
        int[] newArray = new int[r - p + 1];
        int index = 0;
        int i = p;
        int j = m + 1;
        while (i <= m && j <= r) {
            // 小的数据先放，放入之后对应的列+1
            if (array[i] < array[j]) {
                newArray[index++] = array[i++];
            } else {
                newArray[index++] = array[j++];
            }
        }
        // 边界条件 当一边 全赋值完，另一边还有值没有加入时做处理
        int start = i;
        int end = m;
        if (j <= r){
            start = j;
            end = r;
        }
        while (start <= end) {
            newArray[index++] = array[start++];
        }

        // 将排序后的值回写到原数组
        for (int i1 = 0; i1 < newArray.length; i1++) {
            array[p+i1] = newArray[i1];
        }
        return array;
    }


    /**
     * 快速排序
     *
     * @param nums
     * @return
     */
    public List<Integer> quickSortSolution(int[] nums) {
        this.quickSort(nums,0,nums.length-1);
        List<Integer> resultList = new ArrayList<>(nums.length);
        for (int num : nums) {
            resultList.add(num);
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        SortArray sortArray = new SortArray();
        sortArray.quickSort(nums, 0, nums.length - 1);
        for (int anInt : nums) {
            System.out.println(anInt);
        }
    }

    private void quickSort(int[] nums,int p,int r){
        if (p >= r) {
            return;
        }
        int m = this.segmentationAndPosition(nums,p,r);
        quickSort(nums,p,m);
        quickSort(nums,m+1,r);
    }

    /**
     * 分割 并获取中间位置
     * @param nums
     * @param p
     * @param r
     * @return
     */
    private int segmentationAndPosition(int[] nums,int p,int r){
        // i 标记第一个大于 base的坐标和数字， i 之前都是小于base ，i以及之后都是大于base
        int i = p;
        int base = nums[r];
        for(int j = p; j < r; j++) {
            if (nums[j] < base && i == j) {
                i ++;
            } else if (nums[j] < base) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i ++;
            }
        }
        int temp = nums[i];
        nums[i] = nums[r];
        nums[r] = temp;
        // 注意 i 会先 j 到达r，如果i = r 会死循环
        return --i;
    }



}
