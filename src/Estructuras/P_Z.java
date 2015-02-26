
package Estructuras;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class P_Z extends JLabel implements Runnable {
    
    private String nombre,raza;
    private int ataque, defensa;
    private String  imagen;
    private boolean tipoataque;// true disparo, false directo
    private int w;
    int id;
    //NodoM contenedr;
    public P_Z(String nom,int ata,int def,String ic,boolean tip,String raz,int id)
    {
        this.id = id;
        this.raza = raz;
        this.nombre = nom;
        this.ataque = ata;
        this.defensa = def;
        this.imagen = ic;
        this.tipoataque = tip;
    }
    public P_Z(String nom,int ata,int def,String ic,boolean tip,String raz)
    {
        
        this.raza = raz;
        this.nombre = nom;
        this.ataque = ata;
        this.defensa = def;
        this.imagen = ic;
        this.tipoataque = tip;
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
        return "NODOPZ"+id;
        
    }
    public String ToStringEnca()
    {
        return ToString()+"[label=\""+raza+"\\"+"n"+nombre+"\"];";
    }

    /**
     * @return the ataque
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * @param ataque the ataque to set
     */
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    /**
     * @return the defensa
     */
    public int getDefensa() {
        return defensa;
    }

    /**
     * @param defensa the defensa to set
     */
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the tipoataque
     */
    public boolean isTipoataque() {
        return tipoataque;
    }

    /**
     * @param tipoataque the tipoataque to set
     */
    public void setTipoataque(boolean tipoataque) {
        this.tipoataque = tipoataque;
    }

    /**
     * @return the w
     */
    public int getW() {
        return w;
    }

    /**
     * @param w the w to set
     */
    public void setW(int w) {
        this.w = w;
    }

    /**
     * @return the raza
     */
    public String getRaza() {
        return raza;
    }

    /**
     * @param raza the raza to set
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }
    
    
    
}
