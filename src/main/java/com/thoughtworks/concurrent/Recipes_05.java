package com.thoughtworks.concurrent;

// lower: 0, upper: 10
// Thread 1: setLower(5)
// Thread 2: setUpper(4)

public class Recipes_05 {
    private int lower;
    private int upper;

    public void setLower(int value) {
        if (value > upper) {
            throw new IllegalArgumentException("Can't set lower to " + value + ", > upper");
        }
        this.lower = value;
    }

    public void setUpper(int value) {
        if (value < lower) {
            throw new IllegalArgumentException("Can't set upper to " + value + ", < lower");
        }
        this.upper = value;
    }

    public boolean isInRange(int i) {
        return i >= lower && i <= upper;
    }
}
