package _02_vong_lap_trong_java.bai_tap;

public class PrimeNumberDisplay {
    public static void main(String[] args) {
        int count = 0;
        int n = 0;
        while (count < 20) {
            boolean flag = true;
            if (n < 2) {
                flag = false;
            } else {
                for (int i = 2; i < n; i++) {
                    if (n % i == 0) {
                        flag = false;
                        break;
                    }

                }
                if (flag == true) {
                    count++;
                    System.out.println(n);
                }

            }
            n++;

        }
    }
}
