/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafico;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Byron<Byron.jose at ByronJose.org>
 */
public class VentanaJugador extends JPanel implements ActionListener {
    JFrame ventana;
    JButton agregar;
    JLabel name,cantidad,titulo;
    JTextField box1,box2;
    JPanel panelcampos,lienzo;
    JScrollPane scroll;
    
    public VentanaJugador(String tipo)
    {
        ventana = new JFrame();
        agregar = new JButton("Agregar Campo");
        lienzo = new JPanel();
        lienzo.setLayout(null);
        lienzo.setBackground(new Color(60,60,60));
        name = new JLabel("Nombre:");
        name.setForeground(Color.WHITE);
        cantidad = new JLabel("Cantidad");
        cantidad.setForeground(Color.WHITE);
        titulo = new JLabel(tipo);
        titulo.setForeground(Color.WHITE);
         agregar = new JButton();
         box1 = new JTextField();
        box2 = new JTextField();
        scroll = new JScrollPane(); 
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.getContentPane().setLayout(null);
        ventana.setSize(600, 489);
        panelcampos = new JPanel(){
                        public void paintComponent(Graphics g){
                            super.paintComponent(g);
                            Dimension d = getSize();
                            setOpaque(false);
                            ImageIcon imagen = new ImageIcon("C:\\byron\\Fondo1.jpg");
                             g.drawImage(imagen.getImage(),0,0,200,480,this);
                                }
 
 
                                    };
        

        panelcampos.setLayout(null);
        panelcampos.setPreferredSize(new Dimension(200,480));
        
        scroll.setViewportView(panelcampos);
        scroll.setBounds(400, 0, 200, 480);
        
        this.setBounds(0, 0, 600, 489);
        this.setLayout(null);
        titulo.setBounds(130, 30,100,30);
        name.setBounds(30, 120, 50, 30);
        box1.setBounds(85, 120, 75, 30);
        cantidad.setBounds(30, 160, 50, 30);
        box2.setBounds(85, 160, 75, 30);
        
        agregar.setBounds(110, 200,100,30);
        lienzo.setBounds(30, 30, 300, 300);
        this.add(lienzo);
        lienzo.add(titulo);
        lienzo.add(name);
        lienzo.add(cantidad);
        lienzo.add(box1);
        lienzo.add(box2);
       // this.add(scroll);
        
        
        ventana.add(this);
        
        
        ventana.setVisible(true);
        
        
        
        
        
        
        
        
        
        
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
        
         @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==this.agregar)
        {
            
        }
    }
    
}
