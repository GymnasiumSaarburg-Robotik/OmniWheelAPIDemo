package de.lejostest.demo;

import com.sun.javafx.geom.Vec2d;
import de.lejostest.api.OmniWheelBase;
import de.lejostest.api.Vector2d;
import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.Key;
import lejos.hardware.KeyListener;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.hardware.lcd.LCD;
import lejos.hardware.lcd.TextLCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.internal.ev3.EV3Video;
import lejos.utility.Delay;
import org.jfree.data.xy.Vector;

import java.lang.reflect.Array;

public class HelloWorld {


    static int movementSpeedR = 50;
    static int movementSpeedL = 40;
    static boolean running = true;


    public static void main(String[] args) {
        // SCREEN SIZE 178 x 128

        while (running) {
            Vector2d R = new Vector2d(0, movementSpeedR);
            Vector2d notR = new Vector2d(0, movementSpeedR);
            R.rotate(-1.0 / 360 * 55);

            Vector2d L = new Vector2d(0, movementSpeedL);
            Vector2d notL = new Vector2d(0, movementSpeedL);
            L.rotate(1.0 / 360 * 55);


            EV3 ev3 = (EV3) BrickFinder.getLocal();
            GraphicsLCD lcd = ev3.getGraphicsLCD();
            lcd.clear();


            drawVector(lcd, L, 59, 64);
            drawVector(lcd, notL, 59, 64);


            drawVector(lcd, R, 119, 64);
            drawVector(lcd, notR, 119, 64);


            Vector2d sum = R.add(L);

            drawVector(lcd, sum, 89, 178);

            lcd.refresh();


            OmniWheelBase base = new OmniWheelBase();

            if (Button.LEFT.isDown()) {
                movementSpeedL -= 1;
            } else if (Button.RIGHT.isDown()) {
                movementSpeedL += 1;
            } else if (Button.ESCAPE.isDown()) {
                running = false;
            }


            base.forward(movementSpeedL, movementSpeedR);
        }

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

    public static void drawVector(GraphicsLCD lcd, Vector2d vector2d, int xStart, int yStart) {
        lcd.drawLine(xStart, yStart, xStart - (int) (vector2d.getX()), yStart - (int) (vector2d.getY()));
    }
}
