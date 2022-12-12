package TrabajoBeta3;

import java.awt.*;

public class Herramienta {

    /*public static void main(String[] args) throws Exception {
        while (true) {
            try {
                System.out.println(getPointerColor().toString().replace("r","Rojo")
                        .replace("g","Verde").replace("b","Azul"));
                Thread.sleep(1000);
            } catch (AWTException awte) {
                System.out.println("Error while getting pointer's color!");
            } catch (InterruptedException ie) {
                System.out.println("Error while sleeping!");
            }
        }
    }*/

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

    public static void main(String[] args) {
        while (true){
            {
                Color color = null;
                try {
                    color = (new Robot()).getPixelColor(300, 300);
                } catch (AWTException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Red   = " + color.getRed() + " Green = " + color.getGreen()+" Blue  = " + color.getBlue());
            }
        }
    }
}