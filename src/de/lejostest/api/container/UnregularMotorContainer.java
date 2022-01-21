package de.lejostest.api.container;

import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.Port;

import java.util.HashMap;

public class UnregularMotorContainer {

    private static HashMap<Port, UnregulatedMotor> motors = new HashMap<>();

    public static UnregulatedMotor get(Port port) {
        UnregulatedMotor unregulatedMotor = motors.get(port);
        if (unregulatedMotor == null) {
            unregulatedMotor = new UnregulatedMotor(port);
            motors.put(port, unregulatedMotor);
        }
        return unregulatedMotor;
    }

    public static void closeAll() {
        for (UnregulatedMotor value : motors.values()) {
            value.stop();
        }
    }
}
