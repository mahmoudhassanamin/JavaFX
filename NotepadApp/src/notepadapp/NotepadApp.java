/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package notepadapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;


import javafx.scene.Scene;
import javafx.event.ActionEvent;

import javafx.scene.control.*;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

import javafx.stage.Stage;

/**
 *
 * @author eng. mahmoud hassan
 */
public class NotepadApp extends Application {
    private MenuBar bar;
    private Menu [] menus;
    
    private TextArea txtArea;
   
    private MenuItem [] fileItems;
    private MenuItem [] editItems;
    private MenuItem helpItems;
    private BorderPane root;
    private Image img ;
    FileChooser fil_chooser;
    
    
    
    @Override
    public void init() throws Exception {
        super.init();
        bar = new MenuBar();
        menus = new Menu[3];
        menus[0] = new Menu("File");
        menus[1] = new Menu("Edit");
        menus[2] = new Menu("Help");
        fileItems = new MenuItem[5];
        fileItems[0] = new MenuItem("New");
        fileItems[1]  = new MenuItem("Open...");
        fileItems[2]  = new MenuItem("Save");
        fileItems[3] = new SeparatorMenuItem();
        fileItems[4]  = new MenuItem("Exit");
        
        menus[0].getItems().addAll(fileItems);
        editItems = new MenuItem[8];
        editItems[0] = new MenuItem("Undo");
        editItems[1] = new SeparatorMenuItem();
        editItems[2] = new MenuItem("Cut");
        editItems[3] = new MenuItem("Copy");
        editItems[4] = new MenuItem("Paste");
        editItems[5] = new MenuItem("Delete");
        editItems[6] = new SeparatorMenuItem();
        editItems[7] = new MenuItem("Select All");
        
        menus[1].getItems().addAll(editItems);
        helpItems = new MenuItem("About NotePad");
        menus[2].getItems().addAll(helpItems);
       
        ////////////////////////////////
        fil_chooser = new FileChooser();
        fileItems[0].setOnAction((MouseEvent) -> {
            txtArea.setText("");
            
        });
        fileItems[4].setOnAction((MouseEvent)->{
            
        });
        editItems[0].setOnAction( (MouseEvent)->{
            txtArea.undo();
        });
        editItems[2].setOnAction( (MouseEvent)->{
            txtArea.cut();
        });
        editItems[3].setOnAction( (MouseEvent)->{
            txtArea.copy();
        });
        editItems[4].setOnAction( (MouseEvent)->{
            txtArea.paste();
        });
        editItems[5].setOnAction( (MouseEvent)->{
            txtArea.deletePreviousChar();
        });
        editItems[7].setOnAction( (MouseEvent)->{
            txtArea.selectAll();
        });
        bar.getMenus().addAll(menus);
        txtArea = new TextArea();
      
        root = new BorderPane();
        root.setTop(bar);
        root.setCenter(txtArea);
        img = new Image("notepadapp/notepad.png");
    }
    
   
//    notepadapp/
    @Override
    public void start(Stage primaryStage) {
        
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("done");
        ButtonType ok = new ButtonType("Ok", ButtonData.OK_DONE);
        
        
        Scene scene = new Scene(root, 800, 500);
        primaryStage.setTitle("NotePad");
        primaryStage.getIcons().add(img);
        primaryStage.setScene(scene);
        primaryStage.show();
        fileItems[1].setOnAction((MouseEvent)->{
            txtArea.setText("");
            fil_chooser.setTitle("Open File");  
            File file = fil_chooser.showOpenDialog(primaryStage); 
            Scanner reader;
            try {
                reader = new Scanner(file);
                while(reader.hasNext()){
                    txtArea.appendText(reader.nextLine()+'\n');
                    
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(NotepadApp.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        fileItems[2].setOnAction((MouseEvent)->{
            
            try {
                File file = fil_chooser.showSaveDialog(primaryStage);
                dialog.setContentText("the file is saved in ".concat(file.getPath()));
                dialog.getDialogPane().getButtonTypes().add(ok);
                dialog.showAndWait();
            } catch (Exception e) {
                System.out.println("");
            }
            
        });
        fileItems[4].setOnAction((MouseEvent)->{
            primaryStage.close();
        });
        helpItems.setOnAction((MouseEvent)->{
            dialog.setContentText("version 1.0 \ndeveloping by mahmoud hassan  ");
            dialog.getDialogPane().getButtonTypes().add(ok);
            dialog.showAndWait();
        });
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    
    
}


