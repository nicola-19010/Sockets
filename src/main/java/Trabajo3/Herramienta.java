package Trabajo3;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

public class Herramienta {

    public static void main(String[] args) throws Exception {
        while (true) {
            try {
                System.out.println(getPointerColor().toString().replace("r","Rojo")
                        .replace("g","Verde").replace("b","Azul"));

            } catch (AWTException awte) {
                System.out.println("Error while getting pointer's color!");
            }
        }
    }

    public static String obtenerColorDelPuntero(){
        while (true) {
            try {
                //System.out.println(getPointerColor());
                return getPointerColor().toString();
            } catch (AWTException awte) {
                System.out.println("Error while getting pointer's color!");
            }
        }
    }

    public static Color getPointerColor() throws AWTException {
        Point coordinates = MouseInfo.getPointerInfo().getLocation();
        Robot robot = new Robot();
        return robot.getPixelColor((int) coordinates.getX(), (int) coordinates.getX());
    }
}