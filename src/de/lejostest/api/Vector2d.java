package de.lejostest.api;

public class Vector2d {
    private double x;
    private double y;

    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Rotate the vector by a given angle
     * @param n n times PI
     */
    public void rotate(double n) {
        n = n * Math.PI;
        double rx = (this.x * Math.cos(n)) - (this.y * Math.sin(n));
        double ry = (this.x * Math.sin(n)) + (this.y * Math.cos(n));
        this.x = Math.round(rx);
        this.y = Math.round(ry);
    }

    /**
     * Adds the given vector to itself
     * @param vector2d The vector you want to add to the current vector
     * @return Returns itself
     */
    public Vector2d add(Vector2d vector2d) {
        this.x += vector2d.getX();
        this.y += vector2d.getY();
        return this;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Vector2d{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
