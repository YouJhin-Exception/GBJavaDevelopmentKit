package tsk3;

import java.util.Arrays;

public class ArrayLengthComparison {
    /**
     * Сравнивает два массива по длине, а также, опционально, по типу их элементов.
     *
     * @param arr1             массив для сравнения
     * @param arr2             другой массив для сравнения
     * @param checkElementType если true, то метод также проверяет, содержат ли оба массива элементы одного типа
     * @return true если массивы равны по длине и, при необходимости, содержат элементы одного типа
     */
    public <T> boolean compareArrays(T[] arr1, T[] arr2, boolean checkElementType) {
        if (checkElementType && areAllElementsOfSameType(arr1)) {
            return false;
        }
        if (checkElementType && areAllElementsOfSameType(arr2)) {
            return false;
        }
        return arr1.length == arr2.length;
    }

    /**
     * Проверяет, содержат ли все элементы массива один и тот же тип.
     *
     * @param arr массив для проверки
     * @return true если все элементы массива имеют один и тот же тип
     */
    public <T> boolean areAllElementsOfSameType(T[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        Class<?> firstElementType = arr[0].getClass();

        return !Arrays.stream(arr)
                .allMatch(element -> element == null || element.getClass().equals(firstElementType));
    }
}
