package _06_inheritance.bai_tap.MoveAblePoint;

public class MoveAblePoint extends Point {
    private float xSpeed;
    private float ySpeed;

    public MoveAblePoint() {

    }

    public MoveAblePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveAblePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        return new float[]{xSpeed, ySpeed};
    }

    public MoveAblePoint move() {
        super.setX(xSpeed + getX());
        super.setY(ySpeed + getY());
        return this;
    }

    @Override
    public String toString() {
        return "(" + xSpeed + "," + ySpeed +","+super.toString()+ ")";
    }
}
