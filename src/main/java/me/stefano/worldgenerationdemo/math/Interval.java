package me.stefano.worldgenerationdemo.math;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Interval {

    private final float low;
    private final float high;

    public boolean contains(float value) {
        return low <= value && value <= high;
    }

    public static Interval empty() {
        return new Interval(0, 0);
    }

    public static Interval of(float low, float high) {
        return new Interval(low, high);
    }

}
