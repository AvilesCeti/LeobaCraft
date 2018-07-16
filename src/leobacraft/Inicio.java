package leobacraft;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author AvilesCeti
 */
public class Inicio
{
    private static final int WIDTH=800, HEIGH=WIDTH/12*7;
    private VBox esquema;
    private Scene pantalla;
    private Button btnJugar, btnLogros, btnOpciones, btnSalir;
    private Label titulo;
    
    public Inicio(Stage primaryStage)
    {
        esquema = new VBox();
        pantalla = new Scene(esquema, WIDTH, HEIGH);
        titulo=new Label("LeobaCraft");
        btnJugar=new Button("Jugar");
        btnLogros=new Button("Logros");
        btnOpciones=new Button("Opciones");
        btnSalir=new Button("Salir");
        
        titulo.setId("TITULO");
        
        btnJugar.setOnAction(e->
        {
            pantalla=null;
            PantallaJuego juego=new PantallaJuego(primaryStage);
        });
        btnJugar.setId("buttonJugar");
        
        btnLogros.setOnAction(e->
        {
            pantalla=null;
            PantallaLogros logros=new PantallaLogros(primaryStage);
        });
        btnLogros.setId("buttonLogros");
        
        btnOpciones.setOnAction(e->
        {
            pantalla=null;
            PantallaOpciones opciones=new PantallaOpciones(primaryStage);
        });
        btnOpciones.setId("buttonOpcion");
        
        btnSalir.setOnAction(e->
        {
            System.exit(0);
        });
        btnSalir.setId("buttonSalir");
        
        esquema.setAlignment(Pos.CENTER);
        esquema.setSpacing(25);
        
        pantalla.getStylesheets().add("/Estilos/Menu.css");
        
        esquema.getChildren().addAll(titulo, btnJugar, btnLogros, btnOpciones, btnSalir);
        primaryStage.setScene(pantalla);
        primaryStage.centerOnScreen();
    }
    
}
