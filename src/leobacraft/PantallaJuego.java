package leobacraft;

import Bloques.Block;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Aviles
 */

public class PantallaJuego
{
    private static final int WIDTH=800, HEIGH=WIDTH/12*7;
    private Scene pantalla;
    private GridPane esquema;
    private Button btnCancelar, btnNuevaPartida;
    
    public PantallaJuego(Stage primaryStage)
    {
        esquema=new GridPane();
        pantalla=new Scene(esquema, WIDTH, HEIGH);
        btnCancelar=new Button("Cancelar");
        btnNuevaPartida=new Button("Nueva Partida");
        
        esquema.setPadding(new Insets(20, 20, 20, 20));
        esquema.setVgap(20);
        esquema.setHgap(25);
        
        btnCancelar.setOnAction(e->
        {
            pantalla=null;
            Inicio regresar=new Inicio(primaryStage);
        });
        btnCancelar.setId("btnCancelar");
        btnNuevaPartida.setOnAction(e->
        {
            pantalla=null;
            Partida partida=new Partida(primaryStage);
        });
        btnNuevaPartida.setId("btnJuego");
        
        GridPane.setConstraints(btnNuevaPartida, 12, 5);
        GridPane.setConstraints(btnCancelar, 20, 2);
        esquema.getChildren().addAll(btnCancelar, btnNuevaPartida);
        pantalla.getStylesheets().add("/Estilos/Juego.css");
        primaryStage.setScene(pantalla);
        primaryStage.centerOnScreen();
    }

}
