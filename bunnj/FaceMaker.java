/*
 * Course: CS1021 - 041
 * Winter 2021
 * Lab 4 - Facemaker
 * Name: John Paul Bunn
 * Created: Jan 5 2021
 */
package bunnj;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * This class draws a face out of a bunch of shapes.
 * @author bunnj
 * @version 20191216
 */
public class FaceMaker extends Application {
    /**
     * Defines the size of the window
     */
    public static final int WINDOW_SIZE = 800;
    /**
     * Defines the grid increment
     */
    public static final int GRID_INCREMENT = WINDOW_SIZE/10;
    /**
     * Defines the size of the head
     */
    public static final int HEAD_SIZE = 700;

    /**
     * Defines the menu width of the menu application
     */
    public static final int MENU_WIDTH = 700;

    /**
     * Defines the height of the menu application
     */
    public static final int MENU_HEIGHT = 900;

    /**
     * Defines the font size of a header label
     */
    public static final int HEADER_FONT_SIZE = 20;

    /**
     * Defines the number of possible given shapes
     */
    public static final int NUM_OF_POSSIBLE_SHAPES = 5;

    /**
     * Launches the JavaFX application
     * @param args ignored
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Use the Shape class and its descendants to draw a face.
     * @param stage Default stage given to a JavaFX program.
     */
    private static Label plot = new Label();
    private static HashMap<String, TextField> faceMap = new HashMap<String, TextField>();
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Pane pane = new VBox();
        Scene scene = new Scene(pane, MENU_WIDTH, MENU_HEIGHT);

        Label label = new Label("Enter your shapes to create a face! Choose from the list below:");
        label.setFont(new Font(HEADER_FONT_SIZE));

        ArrayList<String> shapeItems = new ArrayList<String>();
        shapeItems.add("Rectangle");
        shapeItems.add("Circle");
        shapeItems.add("Triangle");
        shapeItems.add("LabeledTriangle");
        shapeItems.add("LabeledRectangle");
        shapeItems.add("Random");

        ListView options = new ListView();
        options.getItems().setAll(shapeItems);

        //Head data
        Label headLabel = new Label("Enter the shape for the head");
        TextField headField = new TextField();
        TextField headNameField = new TextField("<Name for labeled shape>");
        faceMap.put("head", headField);
        faceMap.put("headName", headNameField);
        Pane head = new VBox();
        head.getChildren().addAll(headLabel, headField, headNameField);

        //Right Eye data
        Label rightEyeLabel = new Label("Enter the shape for the right eye");
        TextField rightEyeField = new TextField();
        TextField rightEyeNameField = new TextField("<Name for labeled shape>");
        faceMap.put("rightEye", rightEyeField);
        faceMap.put("rightEyeName", rightEyeNameField);
        Pane rightEye = new VBox();
        rightEye.getChildren().addAll(rightEyeLabel, rightEyeField, rightEyeNameField);

        //Left Eye data
        Label leftEyeLabel = new Label("Enter the shape for the left eye");
        TextField leftEyeField = new TextField();
        TextField leftEyeNameField = new TextField("<Name for labeled shape>");
        faceMap.put("leftEye", leftEyeField);
        faceMap.put("leftEyeName", leftEyeNameField);
        Pane leftEye = new VBox();
        leftEye.getChildren().addAll(leftEyeLabel, leftEyeField, leftEyeNameField);

        //Nose data
        Label noseLabel = new Label("Enter the shape for the nose");
        TextField noseField = new TextField();
        TextField noseNameField = new TextField("<Name for labeled shape>");
        faceMap.put("nose", noseField);
        faceMap.put("noseName", noseNameField);
        Pane nose = new VBox();
        nose.getChildren().addAll(noseLabel, noseField, noseNameField);

        //Mouth data
        Label mouthLabel = new Label("Enter the shape for the mouth");
        TextField mouthField = new TextField();
        TextField mouthNameField = new TextField("<Name for labeled shape>");
        faceMap.put("mouth", mouthField);
        faceMap.put("mouthName", mouthNameField);
        Pane mouth = new VBox();
        mouth.getChildren().addAll(mouthLabel, mouthField, mouthNameField);

        Button submit = new Button("Click me when all fields have been filled");

        pane.getChildren().addAll(label, options, head, rightEye, leftEye, nose, mouth, submit);
        submit.setOnAction(e -> activateWinplotter());

        stage.setTitle("Face-Shape Selector");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Runs the set of commands necessary to produce a drawn head
     */
    public void activateWinplotter() {

        WinPlotterFX plotter = new WinPlotterFX();
        plotter.setWindowTitle("Face Maker");
        plotter.setWindowSize(WINDOW_SIZE, WINDOW_SIZE);
        plotter.setBackgroundColor(Color.BLACK.getRed(), Color.BLACK.getGreen(),
                Color.BLACK.getBlue());
        final boolean showGrid = true;
        plotter.setGrid(showGrid, GRID_INCREMENT, GRID_INCREMENT, Color.GRAY);
        Shape head = createHead(faceMap.get("head").getText());
        Shape leftEye = createLeftEye(faceMap.get("leftEye").getText());
        Shape rightEye = createRightEye(faceMap.get("rightEye").getText());
        Shape nose = createNose(faceMap.get("nose").getText());
        Shape mouth = createMouth(faceMap.get("mouth").getText());

        head.draw(plotter);
        leftEye.draw(plotter);
        rightEye.draw(plotter);
        nose.draw(plotter);
        mouth.draw(plotter);

        plotter.showPlotter();
    }

    /**
     * Creates and returns a shape representing the head
     * @param givenShape a String representing the given shape
     * @return shape representing the head
     */
    private Shape createHead(String givenShape) {
        final int xLeft = (WINDOW_SIZE-HEAD_SIZE)/2;
        final int yBottom = (WINDOW_SIZE-HEAD_SIZE)/2;

        String name = faceMap.get("headName").getText();
        return determineShape(givenShape, xLeft, yBottom, HEAD_SIZE, HEAD_SIZE, Color.WHITE, name);
    }

    /**
     * Creates and returns a shape representing the right eye
     * @param givenShape a String representing the given shape
     * @return shape representing the right eye
     */
    private Shape createRightEye(String givenShape) {
        final double scaleFactor = 0.15;
        final double size = scaleFactor*HEAD_SIZE;
        final double yBottom = WINDOW_SIZE/2 + size*3/2;
        final double xLeft = WINDOW_SIZE/2 + size;

        String name = faceMap.get("rightEyeName").getText();
        return determineShape(givenShape, xLeft, yBottom, size, size, Color.WHITE, name);
    }

    /**
     * Creates and returns a shape representing the left eye
     * @param givenShape a String representing the given shape
     * @return shape representing the left eye
     */
    private Shape createLeftEye(String givenShape) {
        final double scaleFactor = 0.15;
        final double size = scaleFactor*HEAD_SIZE;
        final double yBottom = WINDOW_SIZE/2 + size*3/2;
        final double xLeft = WINDOW_SIZE/2 - size*2;

        String name = faceMap.get("leftEyeName").getText();
        return determineShape(givenShape, xLeft, yBottom, size, size, Color.WHITE, name);

    }

    /**
     * Creates and returns a shape representing the nose
     * @param givenShape a String representing the given shape
     * @return shape representing the nose
     */
    private Shape createNose(String givenShape) {
        final double scaleFactor = 0.2;
        final double size = scaleFactor*HEAD_SIZE;
        final double xLeft = WINDOW_SIZE/2 - size/2;
        final double yBottom = (WINDOW_SIZE)/2;

        String name = faceMap.get("noseName").getText();
        return determineShape(givenShape, xLeft, yBottom, size, size, Color.WHITE, name);
    }

    /**
     * Creates and returns a shape representing the mouth
     * @param givenShape a String representing the given shape
     * @return shape representing the mouth
     */
    private Shape createMouth(String givenShape) {
        final double scaleFactor = 0.3;
        final double size = scaleFactor*HEAD_SIZE;
        final double xLeft = WINDOW_SIZE/2 - size/2;
        final double yBottom = (WINDOW_SIZE)/2 - size*3/2;

        String name = faceMap.get("mouthName").getText();
        return determineShape(givenShape, xLeft, yBottom, size, size, Color.WHITE, name);
    }

    private Shape determineShape(String givenShape, double x, double y,
                                 double width, double height,
                                 Color color, String name) {
        switch(givenShape.toLowerCase()) {
            case ("circle"):
                return new Circle(x, y, width, height, color);
            case ("triangle"):
                return new Triangle(x, y, width, height, color);
            case("rectangle"):
                return new Rectangle(x, y, width, height, color);
            case ("labeledtriangle"):
                return new LabeledTriangle(x, y, width, height, color, name);
            case("labeledrectangle"):
                return new LabeledRectangle(x, y, width, height, color, name);
            default:
                switch(randomVal(NUM_OF_POSSIBLE_SHAPES)) {
                    case (0):
                        return new Circle(x, y, width, height, color);
                    case (1):
                        return new Triangle(x, y, width, height, color);
                    case (2):
                        return new LabeledTriangle(x, y, width, height, color, name);
                    case(3):
                        return new LabeledRectangle(x, y, width, height, color, name);
                    default:
                        return new Rectangle(x, y, width, height, color);
                }
        }
    }

    private int randomVal(int bound) {
        Random generator = new Random();
        return generator.nextInt(bound);
    }

}