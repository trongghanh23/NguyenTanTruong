package _06_inheritance.bai_tap.Point2DAndPoint3D;

public class TestPoint3D {
    public static void main(String[] args) {
        Point3D point3D = new Point3D(1, 2, 3);
        System.out.println(point3D);
      Point2D point2D=new Point3D();
        point2D=((Point3D)point2D);
        point3D.getXYZ();



    }
}
