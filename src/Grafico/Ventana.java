/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafico;


import Estructuras.ListaDoble;
import Estructuras.ListaUsuarios.LUsuarios;
import Estructuras.ListaUsuarios.NUsuario;
import Estructuras.MDispersa.MDisp;
import Estructuras.P_Z;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Byron <Byron.Jose at your.org>
 */
public class Ventana extends JPanel implements ActionListener {
    
    JFrame ventana;
    JButton btnplanta,btnzombi,btnbegin,btnborrar,btngraf;
    LUsuarios lusuarios;
    //JPanel canvas;
        public Ventana()
    {
        
      ventana = new JFrame();
      lusuarios = new LUsuarios();
      this.setBounds(0, 0, 600, 489);
      this.setLayout(null);
      btngraf = new JButton("GRAFICAR");
      btngraf.addActionListener(this);
      btnplanta = new JButton("JUGADOR PLANTA");
      btnzombi = new JButton("JUGADOR ZOMBI");
      btnbegin = new JButton("JUGAR");
      btnborrar = new JButton("BORRAR DATOS");
      ventana.setSize(600,489);
      btngraf.setBounds(350, 350, 200,30);
      btnplanta.setBounds(210,200, 200, 30);
      btnzombi.setBounds(210, 240, 200, 30);
      btnbegin.setBounds(120, 300, 150, 30);
      btnborrar.setBounds(350,300, 150, 30);
      btnplanta.addActionListener(this);
      btnzombi.addActionListener(this);
      btnbegin.addActionListener(this);
      btnborrar.addActionListener(this);
      this.add(btnplanta);
      this.add(btnzombi);
      this.add(btnbegin);
      this.add(btnborrar);
      this.add(btngraf);
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
        /*
       JFrame ventana = new JFrame();
       ventana.getContentPane().setLayout(null);
       ventana.setSize(800,700);
       Tablero tab = new Tablero(8,8);
       ventana.add(tab);
       ventana.setVisible(true);
        */
        
        Ventana mod = new Ventana();
       
        
        /*
        LUsuarios lista = new LUsuarios();
        for(int i=0;i<2;i++)
        {
            lista.Insertar("JUGADOR1",20+i,i+"");
            NUsuario aux = lista.getuserbyid(i+"");
            for(int y=0;y<5;y++)
            {
                aux.AgregarStuff("STUFF"+y,aux.ToString());
            }
            for(int j=0;j<5;j++)
            {
                P_Z auxv = new P_Z("nombre"+j,(j+10),j+20,"imagen",true,"raza",j);
                aux.getLpersonajes().Insertar(auxv);
            }
            
            
            
            
            
            
        }
        lista.Graficar("graficagen", "imgGen");*/
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()== btnplanta)
        {
           VentanaJugador  vent = new VentanaJugador("PLANTA",this,lusuarios);
            
        }
        else if(e.getSource()== btnzombi)
        {
            VentanaJugador  vent = new VentanaJugador("ZOMBI",this,lusuarios);
        }
        else if(e.getSource()==this.btngraf)
        {
            this.lusuarios.Graficar("gusuariosedd","GUsuariosedd");
        }
    }
    
}
