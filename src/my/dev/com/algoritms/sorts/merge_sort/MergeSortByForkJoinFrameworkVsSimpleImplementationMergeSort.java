package my.dev.com.algoritms.sorts.merge_sort;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MergeSortByForkJoinFrameworkVsSimpleImplementationMergeSort {
    public static void main(String[] args) {

        int[] arr = new int[20_000_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt();

        }
        System.out.println("Merge sort by Fork/Join Framework");
        int count = 0;
        long timeBeforeLoop = System.nanoTime();
        while (count != 10) {
            long startTime = System.nanoTime();
            ForkJoinPool.commonPool().invoke(new MergeSortRecursiveAction(arr));
            long endTime = System.nanoTime() - startTime;
            System.out.println("Nano time: " + endTime + " or " + TimeUnit.MILLISECONDS.convert(endTime, TimeUnit.NANOSECONDS) + " ms");
            count++;
        }
        long timeAfterLoop = System.nanoTime();
        System.out.println("Total time 10 iterations: " + (timeAfterLoop - timeBeforeLoop) + " or " +
                TimeUnit.MILLISECONDS.convert(timeAfterLoop - timeBeforeLoop, TimeUnit.NANOSECONDS) + " ms");
        System.out.println();


        int[] arr1 = new int[20_000_000];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = ThreadLocalRandom.current().nextInt();
        }
        count = 0;
        System.out.println("Merge sort without Fork/Join Framework");
        timeBeforeLoop = System.nanoTime();
        while (count != 10) {
            long startTime = System.nanoTime();
            SimpleMergeSort.mergeSort(arr1);
            long endTime = System.nanoTime() - startTime;
            System.out.println("Nano time: " + endTime + " or " + TimeUnit.MILLISECONDS.convert(endTime, TimeUnit.NANOSECONDS) + " ms");
            count++;
        }
        timeAfterLoop = System.nanoTime();
        System.out.println("Total time 10 iterations: " + (timeAfterLoop - timeBeforeLoop) + " or " +
                TimeUnit.MILLISECONDS.convert(timeAfterLoop - timeBeforeLoop, TimeUnit.NANOSECONDS) + " ms");

    }
}
