package my.dev.com.algoritms.sorts;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {8, 6, 4, 3, 1};
        System.out.println(Arrays.toString(insertionSort(arr)));
    }

    public static int[] insertionSort(int[] inputArray) {
        for (int currentIndex = 1; currentIndex < inputArray.length; currentIndex++) {

            int currentElement = inputArray[currentIndex];

            int indexBeforeCurrent = currentIndex - 1;

            while (indexBeforeCurrent >= 0 && inputArray[indexBeforeCurrent] > currentElement) {
                inputArray[indexBeforeCurrent + 1] = inputArray[indexBeforeCurrent];
                indexBeforeCurrent = indexBeforeCurrent - 1;
            }
            inputArray[indexBeforeCurrent + 1] = currentElement;
        }
        return inputArray;
    }
}
