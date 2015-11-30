package javafxapplication7;

import static java.lang.Math.random;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Polygon;

public class JavaFXApplication7 extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private Object circle;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(300, 350);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawTriangle(gc);
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        Group circles = new Group();
        for (int i = 0; i < 30; i++) {
            Circle circle = new Circle(150, Color.web("white", 0.05));
            circle.setStrokeType(StrokeType.OUTSIDE);
            circle.setStroke(Color.web("white", 0.16));
            circle.setStrokeWidth(4);
            circles.getChildren().add(circle);
        }

        Group triangles = new Group();
        for (int i = 0; i < 30; i++) {
            double[] xs = {50, 150, 250};
            double[] ys = {100, 200, 100};
            Polygon polygon;
            polygon = new Polygon(new double[]{0.0, 0.0, 20.0, 10.0, 10.0, 20.0});
            polygon.setStrokeType(StrokeType.OUTSIDE);
            polygon.setStroke(Color.web("white", 0.16));
            polygon.setStrokeWidth(4);

        }
        Polygon polygon = new Polygon();
        double[] xs = {50, 150, 250};
        double[] ys = {100, 200, 100};
        polygon.getPoints().addAll(new Double[]{
            0.0, 0.0,
            20.0, 10.0,
            10.0, 20.0});
        Rectangle colors = new Rectangle(scene.getWidth(), scene.getHeight(),
                new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new Stop[]{
                    new Stop(0, Color.web("#f8bd55")),
                    new Stop(0.14, Color.web("#c0fe56")),
                    new Stop(0.28, Color.web("#5dfbc1")),
                    new Stop(0.43, Color.web("#64c2f8")),
                    new Stop(0.57, Color.web("#be4af7")),
                    new Stop(0.71, Color.web("#ed5fc2")),
                    new Stop(0.85, Color.web("#ef504c")),
                    new Stop(1, Color.web("#f2660f")),}));
        colors.widthProperty().bind(scene.widthProperty());
        colors.heightProperty().bind(scene.heightProperty());
        Group blendModeGroup
                = new Group(new Group(new Rectangle(scene.getWidth(), scene.getHeight(),
                                        Color.MAROON), circles, triangles), colors);
        colors.setBlendMode(BlendMode.OVERLAY);
        root.getChildren().add(blendModeGroup);
        circles.setEffect(new BoxBlur(10, 10, 3));
        Timeline timeline = new Timeline();
        for (Node circle : circles.getChildren()) {
            for (Node triangle : triangles.getChildren()) {
                timeline.getKeyFrames().addAll(
                        new KeyFrame(javafx.util.Duration.ZERO, // set start position at 0
                                new KeyValue(circle.translateXProperty(), random() * 800),
                                new KeyValue(circle.translateYProperty(), random() * 600)),
                        new KeyFrame(javafx.util.Duration.ZERO, // set start position at 0
                                new KeyValue(triangle.translateXProperty(), random() * 400),
                                new KeyValue(triangle.translateYProperty(), random() * 300)),
                        //new KeyValue(triangle.translateYProperty(), random() * 600)),
                        new KeyFrame(new javafx.util.Duration(40000), // set end position at 40s
                                new KeyValue(triangle.translateXProperty(), random() * 800),
                                new KeyValue(triangle.translateYProperty(), random() * 600)));
                
                KeyFrame keyFrame = new KeyFrame(new javafx.util.Duration(40000), // set end position at 40s
                        new KeyValue(circle.translateXProperty(), random() * 800),
                        new KeyValue(circle.translateYProperty(), random() * 600));
            
        
                
            
        }}
         drawTriangle(gc);
//        // play 40s of animation
        //     timeline.play();
        primaryStage.show();

    }

    private void drawTriangle(GraphicsContext gc) {
        gc.setFill(Color.POWDERBLUE);
        int shiftx = 100;
        double[] xs = {50, 150, 250};
        double[] ys = {100, 200, 100};
        gc.fillPolygon(xs, ys, 3);
    }


    }

