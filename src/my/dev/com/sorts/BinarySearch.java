package my.dev.com.sorts;

public class BinarySearch {
    public static void main(String[] args) {
        int[] inputArray = new int[10000];
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = i;
        }
        System.out.println(binarySearch(inputArray, 400));
        System.out.println(simpleSearch(inputArray, 400));
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

    public static Integer binarySearch (int[] array, int searchElement) {
        int floor = 0;
        int ceil = array.length - 1;
        int operationsCount = 0;

        while (floor <= ceil) {
            operationsCount++;
            int middleIndex = (floor + ceil) / 2;
            int middleValue = array[middleIndex];

            if (middleValue == searchElement) {
                System.out.println("Operation count in binary sort: " + operationsCount);
                return middleIndex;
            } else if (middleValue > searchElement) {
                ceil = middleIndex - 1;
            } else {
                floor = middleIndex + 1;
            }
        }
        return null;
    }
}
