package my.dev.com.algoritms.sorts.merge_sort;

import java.util.Arrays;

public class SimpleMergeSort {

    public static void mergeSort(int[] inputArr) {
        if (inputArr.length < 2) {
            return;
        }

        int[] leftArr = new int[inputArr.length/2];
        int[] rightArr = new int[inputArr.length - leftArr.length];

        leftArr = Arrays.copyOfRange(inputArr, 0, leftArr.length);
        rightArr = Arrays.copyOfRange(inputArr, leftArr.length, inputArr.length);


        mergeSort(leftArr);
        mergeSort(rightArr);
        sort(inputArr, leftArr, rightArr, leftArr.length, rightArr.length);
    }

    private static void sort(int[] inputArr, int[] leftArr, int[] rightArr, int leftArrSize, int rightArrSize) {
        int inputIdx = 0, leftArrIdx = 0, rightArrIdx = 0;

        while (leftArrIdx < leftArrSize && rightArrIdx < rightArrSize) {
            if (leftArr[leftArrIdx] < rightArr[rightArrIdx]) {
                inputArr[inputIdx++] = leftArr[leftArrIdx++];
            } else {
                inputArr[inputIdx++] = rightArr[rightArrIdx++];
            }
        }

        while (leftArrIdx < leftArr.length) {
            inputArr[inputIdx++] = leftArr[leftArrIdx++];
        }

        while (rightArrIdx < rightArr.length) {
            inputArr[inputIdx++] = rightArr[rightArrIdx++];
        }
    }

}
