package me.stefano.worldgenerationdemo.math;

public interface Point<T extends Point> {

    double distance(T other);

}
