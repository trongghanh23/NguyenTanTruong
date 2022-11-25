package _04_OOP.bai_tap.stop_watch;

public class StopWatch {
    long startTime, endTime;

    public StopWatch() {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void start() {
        setStartTime(System.currentTimeMillis());
    }

    public void stop() {
        setEndTime(System.currentTimeMillis());
    }

    public long getElapsedTime() {
        return getStartTime() - getEndTime();

    }

}

