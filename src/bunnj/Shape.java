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
 * This abstract class defines the features required for many of its subclasses,
 * such as colors and drawing.
 */
public abstract class Shape {

    private Color color;
    protected final double x;
    protected final double y;

    /**
     * Constructor which defines the coordinates and color of the shape
     *
     * @param x the x coordinate for the shape
     * @param y the y coordinate for the shape
     * @param color the color of the shape
     */
    public Shape(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**
     * Abstract method which allows for the plotter to draw
     * the shape
     *
     * @param plotter the WinPlotterFX object
     */
    public abstract void draw(WinPlotterFX plotter);

    /**
     * Sets the pen color of the object
     *
     * @param plotter the WinPlotterFX object, whose color is set
     */
    public void setPenColor(WinPlotterFX plotter) {
        plotter.setPenColor(this.getColor().getRed(),
                            this.getColor().getGreen(),
                            this.getColor().getBlue());
    }

    public void setColor(Color color) {
        this.color = color;
    }

    protected double getX() {
        return this.x;
    }

    protected double getY() {
        return this.y;
    }

    protected Color getColor() {
        return this.color;
    }

}
