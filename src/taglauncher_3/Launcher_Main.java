/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taglauncher_3;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 *
 * @author ammar
 */
public class Launcher_Main extends Application {
    private static Stage applicationMainStage;
    private double xOffset = 0;
    private double yOffset = 0;

    private void setApplicationMainStage(Stage stage) {
        Launcher_Main.applicationMainStage = stage;
    }

    static public Stage getApplicationMainStage() {
        return Launcher_Main.applicationMainStage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
   
    @Override
    public void start(Stage stage) throws Exception {
        Launcher_Settings.userSettingsLoad();
        
        //Launcher_Main_Background.setBackgroundImages();
        
        Parent root = FXMLLoader.load(getClass().getResource("gui/main/Launcher_Main_GUI.fxml"));
        Scene scene = new Scene(root);
        initApplicationSettings(stage, scene);

        stage.setScene(scene);
        stage.show();
    }

    public void initApplicationSettings(Stage stage, Scene scene)
    {
        setApplicationMainStage(stage);
        
        stage.getIcons().add(new Image(Launcher_Main.class.getResourceAsStream("/taglauncher_3/css/images/app_icon_1.png" )));
        stage.setTitle("Minecraft Launcher");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setMinWidth(450);        
        stage.setMinHeight(450);
        stage.setMaxWidth(450);        
        stage.setMaxHeight(450);
        stage.setResizable(false);
        Launcher_Settings.setTheme(scene); 
        

        scene.setOnMousePressed(event -> {
            xOffset = stage.getX() - event.getScreenX();
            yOffset = stage.getY() - event.getScreenY();
        });
        
        scene.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() + xOffset);
            stage.setY(event.getScreenY() + yOffset);
        });
    }
}