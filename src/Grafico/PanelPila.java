
package Grafico;

import Estructuras.Cola;
import Estructuras.ListaDoble;
import Estructuras.NodoLista;
import Estructuras.Pila;
import javax.swing.JPanel;


public class PanelPila implements Runnable {
    Pila pila;
    JPanel canvas;
    int maxtam; 
    
    
     public PanelPila(Pila pil, int tam)
    {
        this.pila = pil;
        this.canvas = new JPanel();
        this.maxtam = tam;
        
    }
    
    public void redibujar()
    {/*
        this.canvas.removeAll();
        ListaDoble nodos = this.cola.ObtenerPrimeros5();
        int tamy = canvas.getBounds().height;
        NodoLista aux = nodos.getPrimero();
        int conty =10;
        while(aux!=null)
        {
            aux.getPersonaje().setBounds(10,conty,30,30);
            this.canvas.add(aux.getPersonaje());
            conty+=40;
            
        }
            */
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
