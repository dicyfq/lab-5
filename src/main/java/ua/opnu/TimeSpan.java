package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan() {
        this.hours = 0;
        this.minutes = 0;
    }

    public TimeSpan(int minutes) {
        if (minutes < 0) {
            minutes = 0;
        }
        this.hours = minutes / 60;
        this.minutes = minutes % 60;
    }

    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    public TimeSpan(TimeSpan span) {
        if (span != null) {
            this.hours = span.getHours();
            this.minutes = span.getMinutes();
        }
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void add(int hours, int minutes) {
        if (hours >= 0 && minutes >= 0 && minutes <= 59) {
            int total = getTotalMinutes() + (hours * 60 + minutes);
            this.hours = total / 60;
            this.minutes = total % 60;
        }
    }

    public void add(int minutes) {
        if (minutes >= 0) {
            int total = getTotalMinutes() + minutes;
            this.hours = total / 60;
            this.minutes = total % 60;
        }
    }

    public void add(TimeSpan span) {
        if (span != null) {
            add(span.getHours(), span.getMinutes());
        }
    }

    public void subtract(int hours, int minutes) {
        if (hours >= 0 && minutes >= 0 && minutes <= 59) {
            int toSub = hours * 60 + minutes;
            if (toSub <= getTotalMinutes()) {
                int diff = getTotalMinutes() - toSub;
                this.hours = diff / 60;
                this.minutes = diff % 60;
            }
        }
    }

    public void subtract(int minutes) {
        if (minutes >= 0 && minutes <= getTotalMinutes()) {
            int diff = getTotalMinutes() - minutes;
            this.hours = diff / 60;
            this.minutes = diff % 60;
        }
    }

    public void subtract(TimeSpan span) {
        if (span != null) {
            subtract(span.getHours(), span.getMinutes());
        }
    }

    public double getTotalHours() {
        return hours + (minutes / 60.0);
    }

    public int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    public void scale(int factor) {
        if (factor > 0) {
            int total = getTotalMinutes() * factor;
            this.hours = total / 60;
            this.minutes = total % 60;
        }
    }

    @Override
    public String toString() {
        return hours + " год " + minutes + " хв";
    }
}