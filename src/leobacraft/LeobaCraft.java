package leobacraft;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Aviles
 */
public class LeobaCraft extends Application
{
    
    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/Imagenes/logo.png")));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("LeobaCraft");
        primaryStage.centerOnScreen();
        primaryStage.show();
        Inicio principal=new Inicio(primaryStage);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
    
}
