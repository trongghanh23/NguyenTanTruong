public class Cach2 {
    public static void main(String[] args) {
        String string = "239438022wewfewfw1";
        String[] arr = string.split("");
        String temp;
        int size = string.length();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[i].charAt(0) > arr[j].charAt(0)) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (String result : arr) {
            System.out.print(result);
        }
    }
}
