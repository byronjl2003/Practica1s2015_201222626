
package Estructuras;

import javax.swing.JLabel;

public class P_Z extends JLabel implements Runnable {
    
    private String nombre;
    
    public P_Z()
    {
        
    }

    
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    
    
    
}
