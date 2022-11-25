package _04_OOP.bai_tap.fan;

public class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    private int speed = 1;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public Fan(int speed, int radius, String color, boolean on) {
        this.speed = speed;
        this.radius = radius;
        this.color = color;
        this.on = on;
    }

    public int getSLOW() {
        return SLOW;
    }

    public int getMEDIUM() {
        return MEDIUM;
    }

    public int getFAST() {
        return FAST;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (this.isOn()) {
            return "Fan{" +
                    ",Fan is On" +
                    ",speed=" + speed +
                    ", radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        } else {
            return "Fan{" +
                    ",Fan is Off" +
                    ",speed=" + speed +
                    ", radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}
