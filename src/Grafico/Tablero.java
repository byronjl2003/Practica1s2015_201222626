
package Grafico;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

public class Tablero extends JPanel {

    int filas=0;
    int columnas = 0;
    FilaPanel paneles[];
   public Tablero(int fi,int col)
   {
       this.setBounds(0, 0, 1000, 700);
       this.filas = fi;
       this.columnas = col;
       paneles = new FilaPanel[fi];
       
       CrearFilas(this.columnas);
   }
   
   public void CrearFilas(int col)
   {
       int y = 0;
       int h = 700/filas;
       for(int i=0;i<this.paneles.length;i++)
       {
           this.paneles[i] = new FilaPanel();
           this.paneles[i].setBounds(0, y,1000,h);
           this.add(this.paneles[i]);
           y = y+h;
           
       }
       }
   
   private class FilaPanel extends JPanel
   {
       @Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.RED);
		g2d.fillOval(0, 0, 30, 30);
		g2d.drawOval(0, 50, 30, 30);		
		g2d.fillRect(50, 0, 30, 30);
		g2d.drawRect(50, 50, 30, 30);

		g2d.draw(new Ellipse2D.Double(0, 100, 30, 30));
	}
   }
   
   }


   
   
    


