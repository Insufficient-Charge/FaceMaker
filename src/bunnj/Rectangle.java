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
 * This class defines the Rectangle shape, which forms a rectangular
 * box
 */
public class Rectangle extends Shape {
    protected final double height;
    protected final double width;

    /**
     * Constructor defines features associated with the rectangle
     *
     * @param x the x coordinate for the shape
     * @param y the y coordinate for the shape
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     * @param color the color for the shape
     */
    public Rectangle(double x, double y, double width, double height, Color color) {
        super(x, y, color);
        this.height = height;
        this.width = width;
    }

    @Override
    public void draw(WinPlotterFX plotter) {

        this.setColor(Color.WHITE);
        this.setPenColor(plotter);

        //BOTTOMLEFT to BOTTOMRIGHT
        plotter.moveTo(this.getX(), this.getY());
        plotter.drawTo(this.getX()+this.getWidth(), this.getY());

        //BOTTOMRIGHT to TOPRIGHT
        plotter.drawTo(this.getX()+this.getWidth(), this.getY()+this.getHeight());
        plotter.moveTo(this.getX()+this.getWidth(), this.getY()+this.getHeight());

        //TOPRIGHT to TOPLEFT
        plotter.drawTo(this.getX(), this.getY()+this.getHeight());
        plotter.moveTo(this.getX(), this.getY()+this.getHeight());

        //TOPLEFT to BOTTOMLEFT
        plotter.drawTo(this.getX(), this.getY());
        plotter.moveTo(this.getX(), this.getY());
    }

    protected double getWidth() {
        return this.width;
    }

    protected double getHeight() {
        return this.height;
    }

}
