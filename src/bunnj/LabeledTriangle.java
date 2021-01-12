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
 * This class defines a labeled triangle, which is a triangle that is labeled
 */
public class LabeledTriangle extends Triangle {

    private final String name;

    /**
     * Constructor defines features for the labeled triangle
     *
     * @param x the x coordinate for the shape
     * @param y the y coordinate for the shape
     * @param base the base of the triangle
     * @param height the height of the triangle
     * @param color the color for the shape
     * @param name the message assigned to the label of the triangle
     */
    public LabeledTriangle(double x, double y, double base, double height, Color color,
                           String name) {
        super(x, y, base, height, color);
        this.name = name;
    }

    @Override
    public void draw(WinPlotterFX plotter) {
        super.draw(plotter);
        plotter.printAt(this.getX(), this.getY(), this.name);
    }


}
