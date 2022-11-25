package _02_vong_lap_trong_java.bai_tap;

public class DisplayPrimesLessThan100 {
    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            boolean flag = true;
            if (i < 2) {
                flag = false;
            } else {
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        flag = false;
                        break;
                    }

                }

            }
            if (flag == true) {
                System.out.println(i);
            }
        }
    }
}
