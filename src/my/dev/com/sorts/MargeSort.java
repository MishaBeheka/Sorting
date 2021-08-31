package my.dev.com.sorts;

import java.util.Arrays;

public class MargeSort {
    public static void main(String[] args) {
        int[] inputArray = {11,9,0,8,1,7,2,6,3,5,4};
        System.out.println("Array before sort: " + Arrays.toString(inputArray));
        mergeSort(inputArray, inputArray.length);
        System.out.println("Array after sort:  " + Arrays.toString(inputArray));
    }

    public static void mergeSort(int[] inputArray, int arraySize) {
        if (arraySize < 2) {
            return;
        }
        int leftArraySize = arraySize / 2;
        int rightArraySize = arraySize - leftArraySize;
        int[] leftArrayHalf = new int[leftArraySize];
        int[] rightArrayHalf = new int[rightArraySize];

        for (int i = 0; i < leftArraySize; i++) {
            leftArrayHalf[i] = inputArray[i];
        }

//        System.arraycopy(inputArray, 0, leftArrayHalf, 0, leftArraySize);

        for (int i = leftArraySize; i < arraySize; i++) {
            rightArrayHalf[i - leftArraySize] = inputArray[i];
        }

//        if (arraySize - leftArraySize >= 0) {
//            System.arraycopy(inputArray, leftArraySize, rightArrayHalf, 0, arraySize - leftArraySize);
//        }

        mergeSort(leftArrayHalf, leftArraySize);
        mergeSort(rightArrayHalf, rightArraySize);

        merge(inputArray, leftArrayHalf, rightArrayHalf, leftArraySize, rightArraySize);
    }

    public static void merge(int[] inputArray, int[] leftArrayHalf, int[] rightArrayHalf, int leftArraySize, int rightArraySize) {

        int i = 0, j = 0, k = 0;

        while (i < leftArraySize && j < rightArraySize) {
            if (leftArrayHalf[i] <= rightArrayHalf[j]) {
                inputArray[k++] = leftArrayHalf[i++];
            } else {
                inputArray[k++] = rightArrayHalf[j++];
            }
        }

        while (i < leftArraySize) {
            inputArray[k++] = leftArrayHalf[i++];
        }

        while (j < rightArraySize) {
            inputArray[k++] = rightArrayHalf[j++];
        }
    }

}
