
package Grafico;

import Estructuras.P_Z;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class VMod extends JPanel implements ActionListener {
    JFrame ventana;
    JTextField txt1,txt2,txt3;
    JLabel lbl1,lbl2,lbl3,lbl4;
    JRadioButton rb1,rb2;
    ButtonGroup grb;
    JFileChooser chooser;
    JButton btnexa,btncambiante;
    JPanel lblimg;
    P_Z per = null;
    ImageIcon imagen;
    String path = "";
    String tipo = "";
    
    public VMod(P_Z personaje)
    {
        
        this.per = personaje;
        this.path = per.getImagen();
        imagen = new ImageIcon(path);
        btncambiante = new JButton("Modificar");
        btncambiante.addActionListener(this);
        btnexa = new JButton("Examinar");
        btnexa.addActionListener(this);
        ventana = new  JFrame("Modificacion de "+per.getRaza());
        txt1 = new JTextField(this.per.getNombre());
        txt2 = new JTextField(this.per.getAtaque());
        txt3 = new JTextField(this.per.getDefensa());
        //if(this.per.isTipoataque())
        rb1.setSelected(per.isTipoataque());
        rb2.setSelected(!per.isTipoataque());
        lbl1 = new JLabel("Nombre:");
        lbl2 = new JLabel("Ataque:");
        lbl3 = new JLabel("Defensa:");
        lbl4 = new JLabel("Tipo Ataque:");
        rb1 = new JRadioButton("Disparo");
        rb2 = new JRadioButton("Directo");
        grb = new ButtonGroup();
        lblimg = new JPanel(){
                        public void paintComponent(Graphics g){
                            super.paintComponent(g);
                            Dimension d = getSize();
                            setOpaque(false);
                            
                             g.drawImage(imagen.getImage(),0,0,d.width,d.height,this);
                                }
 
 
                                    };
        //lblimg.setFont();
        grb.add(rb1);
        grb.add(rb2);
        
        ventana.setSize(350,380);
        ventana.getContentPane().setLayout(null);
        this.setSize(350,380);
        this.setLayout(null);
        lblimg.setBounds(10, 5, 290,150);
        btnexa.setBounds(210, 160, 100 ,30);
        lbl1.setBounds(30,160, 50, 20);
        txt1.setBounds(100,160,100,20);
        lbl2.setBounds(30,190,50,20);
        txt2.setBounds(100,190,100,20);
        lbl3.setBounds(30,220,50,20);
        txt3.setBounds(100,220,100,20);
        lbl4.setBounds(50, 260,150,20);
        rb1.setBounds(50,280,100,20);
        rb2.setBounds(150,280,100,20);
        this.add(lblimg);
        this.add(btnexa);
        this.add(lbl1);
        this.add(txt1);
        this.add(lbl2);
        this.add(txt2);
        this.add(lbl3);
        this.add(txt3);
        this.add(rb1);
        this.add(rb2);
        this.add(lbl4);
        ventana.add(this);
        ventana.setVisible(true);
        
    }
    
    public VMod(String tipo)
    {
       // this.per = personaje;
        this.tipo = tipo;
        btncambiante = new JButton("Crear");
        btncambiante.addActionListener(this);
      
       imagen = new ImageIcon("C:\\byron\\noDisponible.jpg");
        btnexa = new JButton("Examinar");
        btnexa.addActionListener(this);
        ventana = new JFrame("Creacion de "+ tipo);
        txt1 = new JTextField();
        txt2 = new JTextField();
        txt3 = new JTextField();
        lbl1 = new JLabel("Nombre:");
        lbl2 = new JLabel("Ataque:");
        lbl3 = new JLabel("Defensa:");
        lbl4 = new JLabel("Tipo Ataque:");
        rb1 = new JRadioButton("Disparo");
        rb2 = new JRadioButton("Directo");
        grb = new ButtonGroup();
        lblimg = new JPanel(){
                        public void paintComponent(Graphics g){
                            super.paintComponent(g);
                            Dimension d = getSize();
                            setOpaque(false);
                            
                             g.drawImage(imagen.getImage(),0,0,d.width,d.height,this);
                                }
 
 
                                    };
        //lblimg.setFont();
        grb.add(rb1);
        grb.add(rb2);
        
        ventana.setSize(350,380);
        ventana.getContentPane().setLayout(null);
        this.setSize(350,380);
        this.setLayout(null);
        lblimg.setBounds(10, 5, 290,150);
        btnexa.setBounds(210, 160, 100 ,30);
        lbl1.setBounds(30,160, 50, 20);
        txt1.setBounds(100,160,100,20);
        lbl2.setBounds(30,190,50,20);
        txt2.setBounds(100,190,100,20);
        lbl3.setBounds(30,220,50,20);
        txt3.setBounds(100,220,100,20);
        lbl4.setBounds(50, 260,150,20);
        rb1.setBounds(50,280,100,20);
        rb2.setBounds(150,280,100,20);
        this.add(lblimg);
        this.add(btnexa);
        this.add(lbl1);
        this.add(txt1);
        this.add(lbl2);
        this.add(txt2);
        this.add(lbl3);
        this.add(txt3);
        this.add(rb1);
        this.add(rb2);
        this.add(lbl4);
        ventana.add(this);
        ventana.setVisible(true);
         
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.btnexa)
        {
            chooser = new JFileChooser();
            int seleccion = chooser.showOpenDialog(this);
            if(seleccion == JFileChooser.APPROVE_OPTION)
            {
                path = chooser.getSelectedFile().getPath();
                //ImageIcon icon = new ImageIcon(path);
                this.imagen = new ImageIcon(path);
                this.lblimg.repaint();
            }
        }
        else if(e.getSource()==this.btncambiante)
        {
            CrearPersonaje();
        }
    }
    
    public void CrearPersonaje()
    {
        if(this.per==null)
        {
            // no existe el personaje
            String nombre = this.txt1.getText();
            try
            {
                int ataque = Integer.parseInt(txt2.getText());
                int defensa = Integer.parseInt(txt3.getText());
                 if(this.rb1.isSelected())
                this.per = new P_Z(nombre,ataque,defensa,path,true,tipo);
                 else
                     this.per = new P_Z(nombre,ataque,defensa,path,false,tipo);
                     
            }
            catch(NumberFormatException nfe)
            {
                JOptionPane.showMessageDialog(null,"ES INVALIDO EL FORMATO DEL ATAQUE Y DEFENSA");
               
            }
            
        }
        else
        {
            // se modifica personaje ya existente
            
             String nombre = this.txt1.getText();
             this.per.setName(nombre);
             this.per.setImagen(path);
            try
            {
                int ataque = Integer.parseInt(txt2.getText());
                this.per.setAtaque(ataque);
                int defensa = Integer.parseInt(txt3.getText());
                this.per.setDefensa(defensa);
                 if(this.rb1.isSelected())
                     this.per.setTipoataque(true);
                 else
                     this.per.setTipoataque(false);
                       
                
                 
                     
            }
            catch(NumberFormatException nfe)
            {
                JOptionPane.showMessageDialog(null,"ES INVALIDO EL FORMATO DEL ATAQUE Y DEFENSA");
               
            }
            
        }
            
            
    }
    
}
