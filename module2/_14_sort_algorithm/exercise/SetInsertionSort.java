package _14_sort_algorithm.exercise;

public class SetInsertionSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void insertionSort(int[] array) {

        int pos, x;
        for (int i = 1; i < array.length; i++) { //đoạn array[0] đã sắp xếp
            x = array[i];
            pos = i;
            while (pos > 0 && x < array[pos - 1]) {
                array[pos] = array[pos - 1]; // đổi chỗ
                pos--;
            }
            array[pos] = x;
        }
    }

    public static void main(String[] args) {
        insertionSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }

}
