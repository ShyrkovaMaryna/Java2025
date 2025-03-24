package homeWork19;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int size = 10;
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(100);
        }

        System.out.println("Array before sorting: " + Arrays.toString(numbers));

        ArrayUtils.mergeSort(numbers, 0, numbers.length - 1);
        System.out.println("Array after sorting: " + Arrays.toString(numbers));

        int target = numbers[random.nextInt(size)];
        int index = ArrayUtils.binarySearch(numbers, target);

        if (index != -1) {
            System.out.println("Element " + target + " found by index " + index);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
    }
}
