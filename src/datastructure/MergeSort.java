package datastructure;

import java.util.Arrays;

/**
 * 归并排序，贪心算法实现，由小问题解，解决大问题
 */
public class MergeSort {
    /**
     * 执行该方法时，array的两半部分已经排好序
     */
    public void mergePortion(int[] array, int start, int mid, int end) {
        int[] temp = new int[array.length];
        int j = mid + 1;
        int i = start;
        int k = 0;
        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }

        while (j <= end) {
            temp[k++] = array[j++];
        }

        for (int index = 0; index < k; index++) {
            array[index + start] = temp[index];
        }
    }

    public void sort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        sort(array, start, mid);
        sort(array, mid+1, end);
        mergePortion(array, start, mid, end);
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] array = new int[]{1, 3, 5, 2, 6, 8, 10};
        mergeSort.sort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
