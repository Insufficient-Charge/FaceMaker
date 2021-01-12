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
 * This class defines a labeled rectangle, which is a rectangle that is labeled
 */
public class LabeledRectangle extends Rectangle {
    private final String name;

    /**
     * Constructor defines features for the labeled rectangle
     *
     * @param x the x coordinate for the shape
     * @param y the y coordinate for the shape
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     * @param color the color for the shape
     * @param name the String message assigned to the label
     */
    public LabeledRectangle(double x, double y, double width, double height, Color color,
                            String name) {
        super(x, y, width, height, color);
        this.name = name;
    }

    @Override
    public void draw(WinPlotterFX plotter) {
        super.draw(plotter);

        plotter.printAt(this.getX(), this.getY(), this.name);
    }
}
