package _06_inheritance.bai_tap.MoveAblePoint;

public class TestMoveAblePoint {
    public static void main(String[] args) {
        MoveAblePoint moveAblePoint = new MoveAblePoint(1, 2, 5, 7);
        System.out.println(moveAblePoint);
        moveAblePoint.setXSpeed(2);
        moveAblePoint.setYSpeed(5);
        System.out.println(moveAblePoint.move());
    }


}
