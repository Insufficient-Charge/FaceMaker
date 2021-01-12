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
 * This class defines the Triangle shape, which forms an
 * isosceles triangle
 */
public class Triangle extends Shape {
    protected final double base;
    protected final double height;

    /**
     * Constructor that defines the features of the triangle shape
     *
     * @param x the x coordinate for the shape
     * @param y the y coordinate for the shape
     * @param base the length of the base of the triangt
     * @param height the length of the height of the triangle
     * @param color the color for the shape
     */
    public Triangle(double x, double y, double base, double height, Color color) {
        super(x, y, color);
        this.base = base;
        this.height = height;
    }

    @Override
    public void draw(WinPlotterFX plotter) {
        this.setColor(Color.WHITE);
        this.setPenColor(plotter);

        //LEFT to RIGHT
        plotter.moveTo(this.getX(), this.getY());
        plotter.drawTo(this.getX()+this.getBase(), this.getY());

        //RIGHT to TOP
        plotter.moveTo(this.getX()+this.getBase(), this.getY());
        plotter.drawTo(this.getX()+this.getBase()/2, this.getY()+this.getHeight());

        //TOP to LEFT
        plotter.moveTo(this.getX()+this.getBase()/2, this.getY()+this.getHeight());
        plotter.drawTo(this.getX(), this.getY());
    }

    protected double getBase() {
        return this.base;
    }

    protected double getHeight() {
        return this.height;
    }
}
