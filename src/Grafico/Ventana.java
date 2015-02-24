/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafico;


import Estructuras.MDispersa.MDisp;
import Estructuras.P_Z;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Byron <Byron.Jose at your.org>
 */
public class Ventana extends JPanel {
    
    JFrame ventana;
    //JPanel canvas;
        public Ventana()
    {
        
      ventana = new JFrame();
      this.setBounds(0, 0, 600, 489);
      this.setLayout(null);
      ventana.setSize(600,489);
      ventana.add(this);
      ventana.setVisible(true);
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
                
       
    }
    
    @Override
	public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            Dimension tam = getSize();
            ImageIcon imagen = new ImageIcon("C:\\byron\\Fondo1.jpg");
            g.drawImage(imagen.getImage(), 0, 0, tam.width,tam.height,null);
            setOpaque(false);
            super.paint(g);
            
		
	}    
        
        
    public static void main(String [] args)
    {
       VentanaJugador vent = new VentanaJugador("ZOMBI");
        
        
    }
    
}
