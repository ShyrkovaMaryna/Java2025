package homeWork21;
public class ArrayUtils {
    @MethodInfo(
            name = "calculateSum",
            returnType = "int",
            description = "Calculates the sum of array elements")
    @Author(
            firstName = "Johny",
            lastName = " Depp")
    public static int calculateSum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    @MethodInfo(
            name = "findPosition",
            returnType = "int",
            description = "finds the position of the element in the array")
    @Author(
            firstName = "Brad",
            lastName = " Pitt")
    public static int findPosition(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}

