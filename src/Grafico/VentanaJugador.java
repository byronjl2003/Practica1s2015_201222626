/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafico;

import Estructuras.ListaUsuarios.LUsuarios;
import Estructuras.ListaUsuarios.NUsuario;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Byron<Byron.jose at ByronJose.org>
 */
public class VentanaJugador extends JPanel implements ActionListener {
    JFrame ventana;
    JButton agregar,btncrear,btnguardar,btnregresar,btngraf;
    JLabel name,cantidad,titulo;
    JTextField box1,box2;
    JPanel panelcampos,lienzo;
    JScrollPane scroll;
    Ventana vback;
    LUsuarios lusu;
    NUsuario nodo;
    int y = 0;
    String Tipo = "";
    public VentanaJugador(String tipo,Ventana v,LUsuarios l)
    {
        this.Tipo = tipo;
        this.lusu = l;
        this.vback = v;
        ventana = new JFrame();
        ventana.setLocationRelativeTo(null);
        btngraf = new JButton("GRAFICAR");
        btngraf.addActionListener(this);
        agregar = new JButton("Agregar Campo");
        btncrear = new JButton("crear");
        btncrear.addActionListener(this);
        btnguardar = new JButton("guardar");
        btnguardar.addActionListener(this);
        btnregresar = new JButton("regresar");
        btnregresar.addActionListener(this);
        lienzo = new JPanel();
        lienzo.setLayout(null);
        lienzo.setBackground(new Color(60,60,60));
        name = new JLabel("Nombre:");
        name.setForeground(Color.WHITE);
        cantidad = new JLabel("Cantidad");
        cantidad.setForeground(Color.WHITE);
        titulo = new JLabel(tipo);
        titulo.setForeground(Color.WHITE);
      
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
                            ImageIcon imagen = new ImageIcon("C:\\byron\\abs1.jpg");
                             g.drawImage(imagen.getImage(),0,0,200,480,this);
                                }
 
 
                                    };
        

        panelcampos.setLayout(null);
        panelcampos.setPreferredSize(new Dimension(200,1000));
        
        scroll.setViewportView(panelcampos);
        scroll.setBounds(400, 0, 200, 480);
        scroll.getViewport().setView(panelcampos);
        
        this.setBounds(0, 0, 600, 489);
        this.setLayout(null);
        titulo.setBounds(130, 30,100,30);
        name.setBounds(30, 120, 50, 30);
        box1.setBounds(85, 120, 100, 20);
        cantidad.setBounds(30, 160, 50, 30);
        box2.setBounds(85, 160, 100,20);
        
        agregar.setBounds(70, 200,175,30);
        agregar.addActionListener(this);
        lienzo.setBounds(30, 30, 300, 300);
        this.add(lienzo);
        lienzo.add(titulo);
        lienzo.add(name);
        lienzo.add(cantidad);
        lienzo.add(box1);
        lienzo.add(box2);
        lienzo.add(agregar);
        this.add(scroll);
        btncrear.setBounds(100,300,100,30);
        btnguardar.setBounds(100,340,100,30);
        btnregresar.setBounds(100,380,100,30);
        btngraf.setBounds(230,380,100,30);
        ventana.add(btncrear);
        ventana.add(btnguardar);
        ventana.add(btnregresar);
        ventana.add(btngraf);
        ventana.add(this);
        nodo = this.lusu.getuserbyid(tipo);
        
        if(nodo!=null)
        {
            System.out.println(nodo.getId() + "EN EL Constructor"+nodo.getNombre());
            this.box1.setText(nodo.getNombre());
            this.box2.setText(String.valueOf(nodo.getCantidad()));
            this.btncrear.setEnabled(false);
        }
        
        
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
            System.out.println("aqui estoy");
            JTextField aux = new JTextField();
            aux.setBounds(0,y,165,30);
            y= y+35;
            panelcampos.add(aux);
            panelcampos.repaint();
        }
        else if(e.getSource()==this.btncrear)
        {
            try
            {
                String nombre = this.box1.getText();
                int cant = Integer.parseInt(this.box2.getText());
                this.lusu.Insertar(nombre, cant, Tipo);
                this.nodo = this.lusu.getuserbyid(Tipo);
            }
            catch(NumberFormatException nfe)
            {
                JOptionPane.showMessageDialog(this,"EL FORMATO INGRESADO ES INCORRECTO");
            }
            
        }
        else if(e.getSource()==this.btnguardar)
        {
           Component[] componentes  = panelcampos.getComponents();
           for(int i=0;i<componentes.length;i++)
           {
               JTextField aux = (JTextField)componentes[i];
               nodo.getLstuff().Insertar(aux.getText(),"CATALOGO");
           }
        }
        else if(e.getSource()==this.btnregresar)
        {
            this.vback.setVisible(true);
            this.ventana.dispose();
        }
        else if(e.getSource()==this.btngraf)
        {
            this.lusu.Graficar("gusuariosedd","GUsuariosedd");
        }
    }
    
}
