/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafico;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Byron <Byron.Jose at your.org>
 */
public class Ventana {
    
    JFrame ventana;
    JPanel panel;
    Tablero tab;
    public Ventana()
    {
        tab = new Tablero(6,6);
        ventana = new JFrame();
        ventana.setSize(1000,750);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setLayout(null);
        ventana.add(tab);
        ventana.setVisible(true);
    }
    
    public static void main(String [] args)
    {
        Ventana vent = new Ventana();
    }
    
}
