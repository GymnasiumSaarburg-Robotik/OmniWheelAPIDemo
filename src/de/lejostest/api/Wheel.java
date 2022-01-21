package de.lejostest.api;

import com.sun.javafx.geom.Vec2d;
import lejos.hardware.port.Port;

public class Wheel {

    private Port port;
    private int movementSpeed;

    public Wheel(Port port, int movementSpeed) {
        this.port = port;
        this.movementSpeed = movementSpeed;
    }

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }
}
