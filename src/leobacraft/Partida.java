/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leobacraft;

import Bloques.Block;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javafx.application.Platform;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author avile
 */
public class Partida
{
    private double axisX=0, axisY=0;
    private long x=0, y=0, z=0;
    private static final short chunkX=15, chunkY=10, chunkZ=15;
    private static short iX, iY, iZ;
    private Scene pantalla;
    private Group esquema;
    public static int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
    public static int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();
    private Block[][][] chunk;
    private PerspectiveCamera camara;
    private static final int WIDTH=800, HEIGH=WIDTH/12*7;
    
    public Partida(Stage primaryStage)
    {
        esquema=new Group();
        pantalla=new Scene(esquema, WIDTH, HEIGH);
        chunk=new Block[chunkX][chunkY][chunkZ];
        camara=new PerspectiveCamera(false);
        
        for(iX=0;iX<chunkX;iX++)
        {
            for(iY=0;iY<chunkY;iY++)
            {
                for(iZ=0;iZ<chunkZ;iZ++)
                {
                    Random r=new Random();
                    chunk[iX][iY][iZ]=new Block("1", Color.rgb(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
                    chunk[iX][iY][iZ].setTranslateX(iX*60);
                    chunk[iX][iY][iZ].setTranslateY(iY*60);
                    chunk[iX][iY][iZ].setTranslateZ(iZ*60);
                    
                    esquema.getChildren().addAll(chunk[iX][iY][iZ]);
                }
            }
        }
        
        pantalla.setOnKeyPressed(e->
        {
            if(e.getCode()==KeyCode.W)
            {
                z=z+2;
                camara.setTranslateZ(z);
            }
            else if(e.getCode()==KeyCode.A)
            {
                x=x-2;
                camara.setTranslateX(x);
            }
            else if(e.getCode()==KeyCode.S)
            {
                z=z-2;
                camara.setTranslateZ(z);
            }
            else if(e.getCode()==KeyCode.D)
            {
                x=x+2;
                camara.setTranslateX(x);
            }
            else if(e.getCode()==KeyCode.SPACE)
            {
                y=y-2;
                camara.setTranslateY(y);
            }
            else if(e.getCode()==KeyCode.V)
            {
                y=y+2;
                camara.setTranslateY(y);
            }
            else if(e.getCode()==KeyCode.UP)
            {
                axisY++;
                camara.setRotationAxis(Rotate.X_AXIS);
                camara.setRotate(axisY);
            }
            else if(e.getCode()==KeyCode.LEFT)
            {
                axisX--;
                camara.setRotationAxis(Rotate.Y_AXIS);
                camara.setRotate(axisX);
            }
            else if(e.getCode()==KeyCode.DOWN)
            {
                axisY--;
                camara.setRotationAxis(Rotate.X_AXIS);
                camara.setRotate(axisY);
            }
            else if(e.getCode()==KeyCode.RIGHT)
            {
                axisX++;
                camara.setRotationAxis(Rotate.Y_AXIS);
                camara.setRotate(axisX);
            }
        });
        
        esquema.getChildren().add(new AmbientLight());
        pantalla.setCamera(camara);
        primaryStage.setScene(pantalla);
        primaryStage.centerOnScreen();
    }
    private void moveCursor(int screenX, int screenY) {
        Platform.runLater(() -> {
        try {
            Robot robot = new Robot();
            robot.mouseMove(screenX, screenY);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    });
}

}
