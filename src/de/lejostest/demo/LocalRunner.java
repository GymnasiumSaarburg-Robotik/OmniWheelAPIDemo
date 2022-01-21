package de.lejostest.demo;

import de.lejostest.api.Vector2d;

public class LocalRunner {
    public static void main(String[] args) {


        Vector2d vector2d = new Vector2d(4.0, 1.0);
        Vector2d vector2d1 = new Vector2d(1.0, -1.0);
        vector2d.add(vector2d1);
        System.out.println(vector2d.toString());



    }
}
