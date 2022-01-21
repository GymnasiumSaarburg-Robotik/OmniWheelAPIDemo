package de.lejostest.demo;

import com.sun.javafx.geom.Vec2d;
import de.lejostest.api.OmniWheelBase;
import de.lejostest.api.Vector2d;
import lejos.hardware.BrickFinder;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.TextLCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.internal.ev3.EV3Video;
import lejos.utility.Delay;
import org.jfree.data.xy.Vector;

import java.lang.reflect.Array;

public class HelloWorld {
    public static void main(String[] args) {

        Vector2d vector2d = new Vector2d(4.0, 1.0);
        Vector2d vector2d1 = new Vector2d(1.0, -1.0);
        vector2d.add(vector2d1);
        System.out.println(vector2d.toString());



        /* EV3 ev3 = (EV3) BrickFinder.getLocal();
        TextLCD lcd = ev3.getTextLCD();
        //lcd.drawString("OmniWheel API DEMO", 4, 4);

        OmniWheelBase base = new OmniWheelBase();
        EV3ColorSensor coloSens = new EV3ColorSensor(SensorPort.S4);

        base.forward(-40);

        for (int i = 0; i < 200; i++) {
            float[] foo = (float[]) Array.newInstance(float.class, coloSens.getRedMode().sampleSize());
            coloSens.getRedMode().fetchSample(foo, 0);

            float value = foo[0];
            lcd.drawString(String.valueOf(value), 1, 1);

            if (value > 0.7f) {
                base.getBackWheel().setMovementSpeed(30);
                base.apply();
                //lcd.drawString("Black", 1, 2);
            } else {
                base.getBackWheel().setMovementSpeed(-30);
                base.apply();
                //lcd.drawString("White", 1, 2);
            }

            Delay.msDelay(25);
        }

        /*base.forward(80);
        Delay.msDelay(1000);

        base.forward(60, 80);
        Delay.msDelay(1000);

        base.forward(80, 60);
        Delay.msDelay(1000);
        base.stop();
        */
    }
}
