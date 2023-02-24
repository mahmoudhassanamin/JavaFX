/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication1;
import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
//import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.*;
/**
 *
 * @author eng. mahmoud hassan
 */
public class StyleByCSS extends Application{
    private Text txt2;
    private Rectangle rect2;
     private StackPane pane;
    
     
    @Override
    public void init() throws Exception {
        super.init();
        txt2 = new Text("Hello World");
        rect2 = new Rectangle(0,0,500,300);
        txt2.setId("txt2");
        rect2.setId("rect2");
        Reflection reflection = new Reflection();
        reflection.setFraction(1);
        txt2.setEffect(reflection);
        pane = new StackPane();
        pane.getChildren().add(rect2);
        pane.getChildren().add(txt2);
        
    }
    
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene s= new Scene(pane);
        s.getStylesheets().clear();
        s.getStylesheets().add(getClass().getResource("GUStyle.css").toExternalForm());
        primaryStage.setScene(s);
        primaryStage.show();
    }
     
}
