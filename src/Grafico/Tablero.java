
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
       this.setLayout(null);
       paneles = new FilaPanel[fi];
       
       CrearFilas();
   }
   
   public void CrearFilas()
   {
       int y = 0;
       int w = 70* this.columnas;
       for(int i=0;i<this.paneles.length;i++)
       {
           
           this.paneles[i] = new FilaPanel(this.columnas,this.filas,i+1);
           this.paneles[i].setBounds(0, y,w,70);
           this.add(this.paneles[i]);
           y = y+70;
           
       }
       }
   
   private class FilaPanel extends JPanel
   {
       int columnas,filas;
       int x=0;
       int y=0;
       Color colores[] = new Color[2];
       public FilaPanel(int col,int fil,int flag)
       {
           this.columnas = col;
           this.filas = fil;
           CrearColores(flag%2);
           
       }
       public void CrearColores(int flag)
       {
           System.out.println("EN FLAG EN LA CREACION DE COLORES: "+flag);
           if(flag==0)
           {
               
               colores[0] = new Color(128,255,0);
               colores[1] = new Color(76,153,0);
           }
           else
           {
               colores[1] = new Color(128,255,0);
               colores[0] = new Color(76,153,0);
           }
           
       }
       @Override
	public void paint(Graphics g) {
            
            
            Graphics2D g2d = (Graphics2D) g;
            int colornum =0;
            for(int i=0;i<this.columnas;i++)
            {
              System.out.println("Columna: "+(i+1));
              g2d.setColor(colores[colornum]);
              if(colornum==1)
                  colornum=0;
              else
                  colornum++;

              g2d.fillRect(this.x,this.y,70,70);
              System.out.println("SE DIBUJO EN: x: "+this.x+" y en y: "+this.y);
              x=x+70;
              //y=y+70;
            }
            x=0;
            y=0;
            
            
		
	}
   }
   
   }


   
   
    


