    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafxapplication1;


import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.effect.Reflection;
import javafx.scene.text.*;

/**
 *
 * @author eng. mahmoud hassan
 */
public class GuiByJava extends Application {
    private Text txt;
    private Rectangle rect;
    private StackPane pane;
   
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
  

    @Override
    public void init() throws Exception {
        super.init();
        txt = new Text("Hello World");
        rect = new Rectangle(0,0,500,300);
        rect.setFill(Color.GRAY);
        Stop[] stops = new Stop[] { new Stop(0, Color.BLACK),new Stop(2,Color.WHITE)};
        LinearGradient lg1 = new LinearGradient(0, 0, 0, 0.5, true, CycleMethod.REFLECT, stops);
        rect.setFill(lg1 );
        txt.setFill(Color.RED);
        txt.setFont(Font.font("verdana", FontWeight.BOLD, 40));
        Reflection reflection = new Reflection();
        reflection.setFraction(1);
        txt.setEffect(reflection);
        pane = new StackPane();
        pane.getChildren().add(rect);
        pane.getChildren().add(txt);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene s = new Scene(pane,500,300);
        primaryStage.setTitle("my first fx project");
        primaryStage.setScene(s);
        primaryStage.show();
    }
    
}
