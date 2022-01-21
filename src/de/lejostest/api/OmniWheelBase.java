package de.lejostest.api;

import de.lejostest.api.container.UnregularMotorContainer;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;
import lejos.utility.Delay;

public class OmniWheelBase {

    public static Port DEFAULT_PORT_L = MotorPort.A;
    public static Port DEFAULT_PORT_B = MotorPort.B;
    public static Port DEFAULT_PORT_R = MotorPort.C;


    private Wheel leftWheel;
    private Wheel rightWheel;
    private Wheel backWheel;

    public OmniWheelBase() {
        this.leftWheel = new Wheel(DEFAULT_PORT_L, 0);
        this.backWheel = new Wheel(DEFAULT_PORT_B, 0);
        this.rightWheel = new Wheel(DEFAULT_PORT_R, 0);
    }

    public OmniWheelBase(Wheel leftWheel, Wheel rightWheel, Wheel backWheel) {
        this.leftWheel = leftWheel;
        this.rightWheel = rightWheel;
        this.backWheel = backWheel;
    }

    public static Port getDefaultPortL() {
        return DEFAULT_PORT_L;
    }

    public static Port getDefaultPortB() {
        return DEFAULT_PORT_B;
    }

    public static Port getDefaultPortR() {
        return DEFAULT_PORT_R;
    }

    public Wheel getLeftWheel() {
        return leftWheel;
    }

    public Wheel getRightWheel() {
        return rightWheel;
    }

    public Wheel getBackWheel() {
        return backWheel;
    }

    public void setLeftWheel(Wheel leftWheel) {
        this.leftWheel = leftWheel;
    }

    public void setRightWheel(Wheel rightWheel) {
        this.rightWheel = rightWheel;
    }

    public void setBackWheel(Wheel backWheel) {
        this.backWheel = backWheel;
    }

    public void apply() {
        stop();

        UnregulatedMotor unregulatedMotor = UnregularMotorContainer.get(leftWheel.getPort());
        unregulatedMotor.setPower(Math.abs(leftWheel.getMovementSpeed()));
        if (leftWheel.getMovementSpeed() > 0) unregulatedMotor.forward();
        else unregulatedMotor.backward();

        unregulatedMotor = UnregularMotorContainer.get(rightWheel.getPort());
        unregulatedMotor.setPower(Math.abs(rightWheel.getMovementSpeed()));
        if (rightWheel.getMovementSpeed() > 0) unregulatedMotor.forward();
        else unregulatedMotor.backward();

        unregulatedMotor = UnregularMotorContainer.get(backWheel.getPort());
        unregulatedMotor.setPower(Math.abs(backWheel.getMovementSpeed()));
        unregulatedMotor.forward();
        if (backWheel.getMovementSpeed() > 0) unregulatedMotor.forward();
        else unregulatedMotor.backward();
    }

    public void forward(int speed) {
        this.getLeftWheel().setMovementSpeed(-speed);
        this.getRightWheel().setMovementSpeed(speed);
        this.apply();
    }

    public void forward(int speedL, int speedR) {
        this.getLeftWheel().setMovementSpeed(-speedL);
        this.getRightWheel().setMovementSpeed(speedR);
        this.apply();
    }

    public void stop() {
        UnregularMotorContainer.closeAll();
    }
}
