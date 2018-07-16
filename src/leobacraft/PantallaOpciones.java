package leobacraft;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Aviles
 */

public class PantallaOpciones
{
    private static final int WIDTH=800, HEIGH=WIDTH/12*7;
    private Scene pantalla;
    private GridPane esquema;
    private Button btnCancelar;
    
    public PantallaOpciones(Stage primaryStage)
    {
        esquema=new GridPane();
        pantalla=new Scene(esquema, WIDTH, HEIGH);
        
        btnCancelar=new Button("Cancelar");
        
        esquema.setPadding(new Insets(20, 20, 20, 20));
        esquema.setVgap(20);
        esquema.setHgap(25);
        
        btnCancelar.setOnAction(e->
        {
            pantalla=null;
            Inicio regresar=new Inicio(primaryStage);
        });
        
        GridPane.setConstraints(btnCancelar, 26, 19);
        esquema.getChildren().addAll(btnCancelar);
        
        pantalla.getStylesheets().add("/Estilos/Opciones.css");
        primaryStage.setScene(pantalla);
        primaryStage.centerOnScreen();
    }

}
