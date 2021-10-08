package my.dev.com.algoritms.search;

public class BinarySearch {
    private static int operationCount = 0;
    public static void main(String[] args) {
        int[] inputArray = new int[10000];
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = i;
        }
        System.out.println(binarySearch(inputArray, 400));
        System.out.println(simpleSearch(inputArray, 400));
        System.out.println("recursionBinarySearch result: " + recursionBinarySearch(inputArray, 400, 0, inputArray.length - 1));
    }

    public static Integer simpleSearch(int[] array, int searchElement) {
        int operationsCount = 0;
        for (int i = 0; i < array.length; i++) {
            operationsCount++;
            if (array[i] == searchElement) {
                System.out.println("Operation count in simple search: " + operationsCount);
                return i;
            }
        }
        return null;
    }

    public static Integer recursionBinarySearch(int[] array, int searchElement, int head, int tail) {
        operationCount ++;
        int middleIndex = (head + tail) / 2;
        int middleValue = array[middleIndex];
        if (middleValue == searchElement) {
            System.out.println("Operation count in recursionBinarySearch: " + operationCount);
            return array[middleIndex];
        } else if (middleValue > searchElement) {
            return recursionBinarySearch(array, searchElement, head, middleIndex - 1);
        } else {
            return recursionBinarySearch(array, searchElement, middleIndex + 1, tail);
        }
    }

    public static Integer binarySearch(int[] array, int searchElement) {
        int head = 0;
        int tail = array.length - 1;
        int operationsCount = 0;

        while (head <= tail) {
            operationsCount++;
            int middleIndex = (head + tail) / 2;
            int middleValue = array[middleIndex];

            if (middleValue == searchElement) {
                System.out.println("Operation count in binary search: " + operationsCount);
                return middleIndex;
            } else if (middleValue > searchElement) {
                tail = middleIndex - 1;
            } else {
                head = middleIndex + 1;
            }
        }
        return null;
    }
}
