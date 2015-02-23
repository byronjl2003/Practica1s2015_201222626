
package Estructuras;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class P_Z extends JLabel implements Runnable {
    
    private String nombre;
    private int ataque, defensa;
    private ImageIcon  imagen;
    boolean tipoataque;
    int w;
    //NodoM contenedr;
    public P_Z()
    {
        
    }

    
    public void run() {
        
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String ToString()
    {
        return "ZOMBI";
    }
    
    
    
}
