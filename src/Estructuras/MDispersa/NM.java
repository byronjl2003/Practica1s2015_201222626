/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras.MDispersa;

/**
 *
 * @author Byron <Byron.Jose at your.org>
 */
public class NM {
    
     private NM _next, _back;
     private String dato = "";
     int x,y;
     public NM(int x, int y)
     {
         this._next = null;
         this._back = null;
         this.x = x;
         this.y = y;
        

     }

        public String ToString()
        {
            return "NODO ["+this.x+","+this.y+"]";
        }

    /**
     * @return the _next
     */
    public NM getNext() {
        return _next;
    }

    /**
     * @param _next the _next to set
     */
    public void setNext(NM _next) {
        this._next = _next;
    }

    /**
     * @return the _back
     */
    public NM getBack() {
        return _back;
    }

    /**
     * @param _back the _back to set
     */
    public void setBack(NM _back) {
        this._back = _back;
    }

    /**
     * @return the dato
     */
    public String getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(String dato) {
        this.dato = dato;
    }
    
    
}
