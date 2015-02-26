/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafico;

import Estructuras.Cola;
import Estructuras.ListaUsuarios.LUsuarios;
import Estructuras.P_Z;
import Estructuras.Pila;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Byron<Byron.jose at ByronJose.org>
 */
public class VCatalogo {
    
    JFrame ventana;
    JButton crear;
    Pila pila;
    Cola cola;
    LUsuarios lusu;
    public VCatalogo(LUsuarios l)
    {
        this.lusu = l;
    }
    
    
    
    private class Panelito extends JPanel
    {
        JLabel lblimagen,nom,ataque,defensa,tipo;
        JButton elim,mod;
        P_Z per;
        
        public Panelito(P_Z personaje)
        {
            this.per = personaje;
            lblimagen = new JLabel(per.getImagen());
            nom = new JLabel(per.getNombre());
            ataque = new JLabel(String.valueOf(per.getAtaque()));
            defensa = new JLabel(String.valueOf(per.getDefensa()));
            tipo = new JLabel();
            if(per.isTipoataque())
                tipo.setText("Disparo");
            else
                tipo.setText("Directo");
            elim = new JButton();
            mod = new JButton();
            this.setSize(700, 150);
            this.setLayout(null);
            
        }
        
        
    }
    
    private class VMod
    {
        P_Z per;
        JLabel Imagen,nom,ataq,def;
        JRadioButton rb1,rb2;
        ButtonGroup grup;
        JButton exam,guardar;
        
        public VMod(P_Z pers)
        {
            this.per = pers;
        }
    }
    
}
