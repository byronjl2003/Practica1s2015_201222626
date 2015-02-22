
package Grafico;

import Estructuras.Cola;
import Estructuras.ListaDoble;
import Estructuras.NodoLista;
import Estructuras.Pila;
import javax.swing.JPanel;

public class PanelCola {

    Cola cola;
    JPanel canvas;
    int maxtam;
    
    
    public PanelCola(Cola col, int tam)
    {
        this.cola = col;
        this.canvas = new JPanel();
        this.maxtam = tam;
        
    }
    
    public void redibujar()
    {
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
    }
    
    
    
}
