
package Estructuras.ListaUsuarios;

import Estructuras.ListaDoble;

public class NUsuario {
    private String Nombre,id;
    private int cantidad;
    private NUsuario next;
    private NUsuario back;
    private LString lstuff;
    private ListaDoble lpersonajes;
    public NUsuario(String nom, int cant,String id)
    {
        this.id = id;
        this.Nombre = nom;
        this.cantidad = cant;
        this.next = this.back = null;
        lstuff = new LString(id);
        lpersonajes = new ListaDoble();
        
    }
    public void AgregarStuff(String st,String idusu)
    {
        this.lstuff.Insertar(st,idusu);
    }
    
     public String ToStringEncabezado()
    {
        return "NodoU"+id+"[label=\""+this.Nombre+"\\"+"n"+this.cantidad+"\"];";
    }
    
    public String ToString()
    {
        return "NodoU"+id;
    }
    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the next
     */
    public NUsuario getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(NUsuario next) {
        this.next = next;
    }

    /**
     * @return the back
     */
    public NUsuario getBack() {
        return back;
    }

    /**
     * @param back the back to set
     */
    public void setBack(NUsuario back) {
        this.back = back;
    }

    /**
     * @return the lstuff
     */
    public LString getLstuff() {
        return lstuff;
    }

    /**
     * @param lstuff the lstuff to set
     */
    public void setLstuff(LString lstuff) {
        this.lstuff = lstuff;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the lpersonajes
     */
    public ListaDoble getLpersonajes() {
        return lpersonajes;
    }

    /**
     * @param lpersonajes the lpersonajes to set
     */
    public void setLpersonajes(ListaDoble lpersonajes) {
        this.lpersonajes = lpersonajes;
    }
    
}
