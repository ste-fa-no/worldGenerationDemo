package me.stefano.worldgenerationdemo.math;

public record Vector(double x, double y) {

    public Vector add(Vector vector) {
        return new Vector(this.x + vector.x, this.y + vector.y);
    }

    public Vector scale(double scalar) {
        return new Vector(this.x * scalar, this.y * scalar);
    }

    public double norm() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public Vector normalize() {
        double norm = this.norm();
        return new Vector(this.x / norm, this.y / norm);
    }

}
