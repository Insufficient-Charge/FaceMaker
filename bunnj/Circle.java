/*
 * Course: CS1021 - 041
 * Winter 2021
 * Lab 4 - Inheritance with Shapes
 * Name: John Paul Bunn
 * Created: Jan 5 2021
 */
package bunnj;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.scene.paint.Color;

/**
 * This class defines the Circle shape, which draws a Circle to the screen
 */
public class Circle extends Shape {

    private static final int CIRCUMFERENCE_LENGTH = 360;
    private final double radius;

    /**
     * Constructor defines features for the circle, by its radius
     *
     * @param x the x coordinate for the shape
     * @param y the y coordinate for the shape
     * @param radius the radius of the circle itself
     * @param color the color for the shape
     */
    public Circle(double x, double y, double radius, Color color) {
        super(x, y, color);
        this.radius = radius;
    }

    /**
     * Constructor defines features for the circle, by its height and width
     *
     * @param x the x coordinate for the shape
     * @param y the y coordinate for the shape
     * @param width the width of the circle, equal to the radius
     * @param height the height of the circle, equal to the radius
     * @param color the color for the shape
     */
    public Circle(double x, double y, double width, double height, Color color) {
        super(x, y, color);
        this.radius = width/2;
    }

    @Override
    public void draw(WinPlotterFX plotter) {
        this.setColor(Color.WHITE);
        this.setPenColor(plotter);

        double xCenter = this.getX() + radius;
        double yCenter = this.getY() + radius;

        double prevX = xCenter + radius * Math.cos(Math.toRadians(1));
        double prevY = yCenter + radius * Math.sin(Math.toRadians(1));

        double newX;
        double newY;
        double angle;
        for (int i = 1; i <= CIRCUMFERENCE_LENGTH; ++i) {
            angle = Math.toRadians(i);

            plotter.moveTo(prevX, prevY);

            newX = xCenter + radius * Math.cos(angle);
            newY = yCenter + radius * Math.sin(angle);
            plotter.drawTo(newX, newY);

            prevX = newX;
            prevY = newY;
        }

    }

}
