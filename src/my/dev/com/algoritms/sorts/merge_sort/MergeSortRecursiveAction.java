package my.dev.com.algoritms.sorts.merge_sort;

public class MergeSortRecursiveAction extends java.util.concurrent.RecursiveAction {

    private int[] inputArray;

    public MergeSortRecursiveAction(int[] inputArray) {
        this.inputArray = inputArray;
    }

    @Override
    protected void compute() {
        if (inputArray.length < 2) {
            return;
        }

        int[] leftArray = new int[inputArray.length / 2];
        int[] rightArray = new int[inputArray.length - leftArray.length];

        System.arraycopy(inputArray, 0, leftArray, 0, leftArray.length);
        System.arraycopy(inputArray, leftArray.length, rightArray, 0, inputArray.length - leftArray.length);

        var leftTask = new MergeSortRecursiveAction(leftArray);
        var rightTask = new MergeSortRecursiveAction(rightArray);
        leftTask.fork();
        rightTask.compute();
        leftTask.join();
        sort(leftArray, rightArray, inputArray, leftArray.length, rightArray.length);

    }

    private void sort(int[] leftArray, int[] rightArray, int[] inputArray, int leftArrayLength, int rightArrayLength) {
        int inputArrayIndex = 0, leftArrayIndex = 0, rightArrayIndex = 0;

        while (leftArrayIndex < leftArrayLength && rightArrayIndex < rightArrayLength) {
            if (leftArray[leftArrayIndex] > rightArray[rightArrayIndex]) {
                inputArray[inputArrayIndex++] = leftArray[leftArrayIndex++];
            } else {
                inputArray[inputArrayIndex++] = rightArray[rightArrayIndex++];
            }
        }

        while (leftArrayIndex < leftArrayLength) {
            inputArray[inputArrayIndex++] = leftArray[leftArrayIndex++];
        }

        while (rightArrayIndex < rightArrayLength) {
            inputArray[inputArrayIndex++] = rightArray[rightArrayIndex++];
        }
    }
}
