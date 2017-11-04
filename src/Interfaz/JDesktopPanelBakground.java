
package Interfaz;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 */

//CLASE PARA NUESTRO FONDO DEL PANEL - DESKTOP PANE
public class JDesktopPanelBakground implements Border {

    public BufferedImage back;
    
    public JDesktopPanelBakground(){
        try {
            URL imagePath = new URL(getClass().getResource("/Imagenes/alimentacionSaludableImagen.jpg").toString());
            back = ImageIO.read(imagePath);
        } catch (Exception e) {
        }
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
        g.drawImage(back, (x + (w - back.getWidth())/2), (y + (h - back.getHeight())/2),null);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return  new Insets(0, 0, 0, 0);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}