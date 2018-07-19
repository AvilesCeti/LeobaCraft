/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bloques;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

/**
 *
 * @author avile
 */
public class Block extends Box
{
    private static String id;
    private PhongMaterial material=new PhongMaterial();
    
    public Block(String id, Color color)
    {
        setWidth(50);
        setHeight(50);
        setDepth(50);
        this.id=id;
        material.setDiffuseColor(color);
        material.setSpecularColor(color);
        setMaterial(material);
    }

}
